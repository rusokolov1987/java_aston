package org.example.lesson_15;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainTest {
    static WebDriver webDriver;
    static Actions actions;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Aston\\webdriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        Duration duration = Duration.of(5, ChronoUnit.SECONDS);
        chromeOptions.setScriptTimeout(duration);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.mts.by/");
        actions = new Actions(webDriver);
        actions.click(webDriver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"))).perform();
    }

    @Test
    @DisplayName("Проверка названия блока.")
    @Order(1)
    public void testTitleBlock() {
        String expected = "Онлайн пополнение\nбез комиссии";
        String actual = webDriver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем.")
    @Order(2)
    public void testLogoPaymentSystem() {
        List<WebElement> elements = webDriver.findElements(By.xpath("/html/body/div[6]/main/div/div[3]/div[1]/div/div/div[2]/section/div/div[2]/ul"));
        boolean isDisplayed = true;
        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                isDisplayed = false;
            }
        }
        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("Проверка работы кнопки при заполненных полях.")
    @Order(3)
    public void testWorkButton() {
        webDriver.findElement(By.xpath("//*[@id=\"connection-phone\"]")).sendKeys("29777-77-77");
        webDriver.findElement(By.xpath("//*[@id=\"connection-sum\"]")).sendKeys("200");
        webDriver.findElement(By.className("email")).sendKeys("test@ya.ru");
        Actions actions = new Actions(webDriver);
        actions.click(webDriver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"))).perform();
        boolean isDisabled = webDriver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div")).isDisplayed();
        assertTrue(isDisabled);
        actions.click(webDriver.findElement(By.xpath("/html/body/app-root/div/div/app-header/header/div/app-back-navigation/div/div/svg-icon"))).perform();
    }

    @Test
    @DisplayName("Проверка работы ссылки.")
    @Order(4)
    public void testLink() {
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        actions.click(element).perform();
        String currentUrl = webDriver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }

    @AfterAll
    public static void close() {
        webDriver.close();
    }
}