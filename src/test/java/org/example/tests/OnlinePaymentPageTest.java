package org.example.tests;

import org.example.lesson_16.DTO.OnlinePaymentPageDTO;
import org.example.lesson_16.steps.HomePageSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.stream.Stream;

import static org.example.lesson_16.WebDriverInstance.webDriver;
import static org.example.lesson_16.WebDriverInstance.getWebDriverInstance;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlinePaymentPageTest {
    private static HomePageSteps steps;
    private static Actions actions;

    @BeforeAll
    public static void setup() {
        steps = new HomePageSteps();
        webDriver = getWebDriverInstance();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.mts.by/");
        actions = new Actions(webDriver);
        actions.click(webDriver.findElement(By.id("cookie-agree"))).perform();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        steps.scrollToPaymentSection();
    }

    static Stream<String> provider() {
        return Stream.of("Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность");
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("Проверка placeholders в поле ввода телефона во всех видах услуг.")
    public void placeholderNumberInputTest(String type) {
        OnlinePaymentPageDTO onlinePaymentPageDTO = OnlinePaymentPageDTO.builder()
                .paymentType(type)
                .build();
        steps.clickDropdownButton();
        steps.fillOnlyPaymentTypeField(onlinePaymentPageDTO);
        boolean check = isCheck(steps.getPlaceholderPhoneNumber());
        assertTrue(check);
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("Проверка placeholders в поле ввода телефона во всех видах услуг.")
    public void placeholderTotalInputTest(String type) {
        OnlinePaymentPageDTO onlinePaymentPageDTO = OnlinePaymentPageDTO.builder()
                .paymentType(type)
                .build();
        steps.clickDropdownButton();
        steps.fillOnlyPaymentTypeField(onlinePaymentPageDTO);
        boolean check = isCheck(steps.getPlaceholderTotal());
        assertTrue(check);
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("Проверка placeholders в поле ввода телефона во всех видах услуг.")
    public void placeholderEmailInputTest(String type) {
        OnlinePaymentPageDTO onlinePaymentPageDTO = OnlinePaymentPageDTO.builder()
                .paymentType(type)
                .build();
        steps.clickDropdownButton();
        steps.fillOnlyPaymentTypeField(onlinePaymentPageDTO);
        boolean check = isCheck(steps.getPlaceholderEmail());
        assertTrue(check);
    }

    private boolean isCheck(String element) {
        String[] placeholders = {"Номер телефона", "Сумма", "E-mail для отправки чека"};
        for (String placeholder : placeholders) {
            if (placeholder.equals(element)) {
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
