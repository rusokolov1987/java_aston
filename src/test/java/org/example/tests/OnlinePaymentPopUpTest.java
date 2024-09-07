package org.example.tests;

import org.example.lesson_16.DTO.OnlinePaymentPageDTO;
import org.example.lesson_16.steps.HomePageSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.example.lesson_16.WebDriverInstance.getWebDriverInstance;
import static org.example.lesson_16.WebDriverInstance.webDriver;

public class OnlinePaymentPopUpTest {
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
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @ParameterizedTest
    @CsvSource({"Услуги связи, 297777777, 200, test@mail.ru"})
    @DisplayName("Прверка корректного отображения суммы в заголовке pop-up.")
    public void testTotalView(String type, String field, String total, String email) {
        OnlinePaymentPageDTO onlinePaymentPageDTO = OnlinePaymentPageDTO.builder()
                .paymentType(type)
                .specialField(field)
                .total(total)
                .email(email)
                .build();
        steps.scrollToPaymentSection();
        steps.clickDropdownButton();
        steps.fillPaymentPage(onlinePaymentPageDTO);
        steps.clickButton();

    }

    @AfterAll
    public static void close() {
        webDriver.close();
        webDriver.quit();
    }
}
