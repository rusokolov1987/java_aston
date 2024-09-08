package org.example.tests;

import org.example.lesson_16.DTO.OnlinePaymentPageDTO;
import org.example.lesson_16.DTO.OnlinePaymentPopUpDTO;
import org.example.lesson_16.steps.HomePageSteps;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;

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
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        boolean contains = steps.getTextPopUp().contains(phoneNumber);
        assertTrue(contains);
    }

    @ParameterizedTest
    @DisplayName("Проверка placeholder в поле номер карты.")
    @CsvSource({"Номер карты"})
    @Order(3)
    public void testCardNumberPlaceholder(String placeholder) {
        boolean contains = steps.getCardNumberText().contains(placeholder);
        assertTrue(contains);
    }

    @ParameterizedTest
    @DisplayName("Проверка placeholder в поле CVC.")
    @CsvSource({"CVC"})
    @Order(4)
    public void testSecretCodePlaceholder(String placeholder) {
        boolean contains = steps.getSecretCodeText().contains(placeholder);
        assertTrue(contains);
    }

    @ParameterizedTest
    @DisplayName("Проверка placeholder в поле срок действия карты.")
    @CsvSource({"Срок действия"})
    @Order(5)
    public void testValidityPeriodPlaceholder(String placeholder) {
        boolean contains = steps.getValidityPeriodText().contains(placeholder);
        assertTrue(contains);
    }

    @ParameterizedTest
    @DisplayName("Проверка placeholder в поле имя держателя карты.")
    @CsvSource({"Имя держателя (как на карте)"})
    @Order(6)
    public void testHolderNamePlaceholder(String placeholder) {
        boolean contains = steps.getHolderNameText().contains(placeholder);
        assertTrue(contains);
    }

    @ParameterizedTest
    @CsvSource({"visa-system.svg"})
    @DisplayName("Проверка логотипа Visa")
    @Order(7)
    public void testLogoVisa(String svg) {
        ArrayList<String> srcCardBrands = steps.getSrcCardBrands();
        boolean contains = srcCardBrands.contains(svg);
        assertTrue(contains);
    }

    @ParameterizedTest
    @CsvSource({"mastercard-system.svg"})
    @DisplayName("Проверка логотипа Master Card")
    @Order(8)
    public void testLogoMasterCard(String svg) {
        ArrayList<String> srcCardBrands = steps.getSrcCardBrands();
        boolean contains = srcCardBrands.contains(svg);
        assertTrue(contains);
    }

    @ParameterizedTest
    @CsvSource({"belkart-system.svg"})
    @DisplayName("Проверка логотипа Master Belkart")
    @Order(9)
    public void testLogo(String svg) {
        ArrayList<String> srcCardBrands = steps.getSrcCardBrands();
        boolean contains = srcCardBrands.contains(svg);
        assertTrue(contains);
    }

    @ParameterizedTest
    @CsvSource({"2200 2407 0118 3630, 03 / 26, 200, SEMEN SEMENOV"})
    @DisplayName("Прверка корректного отображения суммы на кнопке в pop-up.")
    @Order(10)
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

    @AfterAll
    public static void close() {
        webDriver.close();
        webDriver.quit();
    }
}
