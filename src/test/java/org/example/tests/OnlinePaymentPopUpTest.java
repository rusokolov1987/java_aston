package org.example.tests;

import org.example.lesson_16.DTO.OnlinePaymentPageDTO;
import org.example.lesson_16.DTO.OnlinePaymentPopUpDTO;
import org.example.lesson_16.steps.HomePageSteps;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.example.lesson_16.WebDriverInstance.getWebDriverInstance;
import static org.example.lesson_16.WebDriverInstance.webDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlinePaymentPopUpTest {
    private static HomePageSteps steps;
    private static Actions actions;

    @BeforeAll
    public static void setup() {
        steps = new HomePageSteps();
        webDriver = getWebDriverInstance();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.get("https://www.mts.by/");
        actions = new Actions(webDriver);
        actions.click(webDriver.findElement(By.id("cookie-agree"))).perform();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        OnlinePaymentPageDTO onlinePaymentPageDTO = OnlinePaymentPageDTO.builder()
                .paymentType("Услуги связи")
                .specialField("297777777")
                .total("200")
                .email("test@mail.ru")
                .build();
        steps.scrollToPaymentSection();
        steps.clickDropdownButton();
        steps.fillPaymentPage(onlinePaymentPageDTO);
        steps.clickButton();
        steps.switchToFramePopUp();
    }

    static Stream<String> providerLogo() {
        return Stream.of("visa-system.svg", "mastercard-system.svg", "belkart-system.svg", "mir-system-ru.svg", "maestro-system.svg");
    }

    static Stream<String> providerPlaceholder() {
        return Stream.of("Некорректный номер карты", "Исправьте срок действия", "Введите CVC-код", "Введите имя и фамилию как указано на карте");
    }

    @ParameterizedTest
    @Order(1)
    @DisplayName("Прверка корректного отображения суммы в заголовке pop-up.")
    @CsvSource({"200"})
    public void testTotalViewTitlePopUp(String total) {
        boolean contains = steps.getTextPopUpTitle().contains(total);
        assertTrue(contains);
    }

    @ParameterizedTest
    @Order(2)
    @DisplayName("Прверка корректного отображения телефона в заголовке pop-up")
    @CsvSource({"297777777"})
    public void testPhoneNumber(String phoneNumber) {
        String textPopUp = steps.getTextPopUp();
        boolean contains = textPopUp.contains(phoneNumber);
        assertTrue(contains);
    }

    @ParameterizedTest
    @DisplayName("Проверка подсказок в незаполненных полях.")
    @MethodSource("providerPlaceholder")
    @Order(3)
    public void testPlaceholder(String placeholder) {
        boolean contains = false;
        switch (placeholder) {
            case "Некорректный номер карты":
                steps.clickCardNumber();
                steps.clickOff();
                contains = steps.getCardNumberText().contains(placeholder);
                break;
            case "Исправьте срок действия":
                steps.clickValidityPeriod();
                steps.clickOff();
                contains = steps.getValidityPeriodText().contains(placeholder);
                break;
            case "Введите CVC-код":
                steps.clickSecretCode();
                steps.clickOff();
                contains = steps.getSecretCodeText().contains(placeholder);
                break;
            case "Введите имя и фамилию как указано на карте":
                steps.clickHolderName();
                steps.clickOff();
                contains = steps.getHolderNameText().contains(placeholder);
        }
        assertTrue(contains);
    }

    @ParameterizedTest
    @DisplayName("Проверка логотипов")
    @MethodSource("providerLogo")
    @Order(4)
    public void testMaestro(String cardBrand) {
        boolean contains = isCheck(cardBrand);
        assertTrue(contains);
    }

    @ParameterizedTest
    @CsvSource({"2200 2407 0118 3630, 03 / 26, 200, SEMEN SEMENOV"})
    @DisplayName("Прверка корректного отображения суммы на кнопке в pop-up.")
    @Order(5)
    public void testTotalViewButtonPopUp(String cardNumber, String validityPeriod, String secretCode, String holderName) {
        OnlinePaymentPopUpDTO onlinePaymentPopUpDTO = OnlinePaymentPopUpDTO.builder()
                .cardNumber(cardNumber)
                .validityPeriod(validityPeriod)
                .secretCode(secretCode)
                .holderName(holderName)
                .build();
        steps.fillPaymentPopUp(onlinePaymentPopUpDTO);
        boolean contains = steps.getTextPopUpButton().contains("200");
        assertTrue(contains);
    }

    private boolean isCheck(String cardBrand) {
        ArrayList<String> srcCardBrands = steps.getSrcCardBrands();
        for (String src : srcCardBrands) {
            if (src.contains(cardBrand)) {
                return true;
            }
        }
        return false;
    }

    @AfterAll
    public static void close() {
        webDriver.close();
        webDriver.quit();
    }
}
