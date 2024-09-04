package org.example.lesson_15;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
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
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
        webDriver.get("https://www.mts.by/");
        actions = new Actions(webDriver);
        actions.click(webDriver.findElement(By.id("cookie-agree"))).perform();
    }

    @Test
    @DisplayName("Проверка названия блока.")
    @Order(1)
    public void testTitleBlock() {
        String expected = "Онлайн пополнение\nбез комиссии";
        String actual = webDriver.findElement(By.xpath("//div[@class='pay__wrapper']/h2")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем.")
    @Order(2)
    public void testLogoPaymentSystem() {
        List<WebElement> elements = webDriver.findElements(By.xpath("//div[@class='pay__partners']/ul/li/img"));
        boolean isDisplayed = true;
        for (WebElement element : elements) {
            if (element.getAttribute("src").isEmpty()) {
                isDisplayed = false;
            }
        }
        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("Проверка работы кнопки при заполненных полях.")
    @Order(4)
    public void testWorkButton() {
        webDriver.findElement(By.id("connection-phone")).sendKeys("29777-77-77");
        webDriver.findElement(By.id("connection-sum")).sendKeys("200");
        webDriver.findElement(By.id("connection-email")).sendKeys("test@ya.ru");
        Actions actions = new Actions(webDriver);
        actions.click(webDriver.findElement(By.xpath("//div[@class='pay__forms']//button"))).perform();
        boolean isDisabled = webDriver.findElement(By.xpath("//div[@class='bepaid-app']")).isDisplayed();
        assertTrue(isDisabled);
    }

    @Test
    @DisplayName("Проверка работы ссылки.")
    @Order(3)
    public void testLink() {
        WebElement element = webDriver.findElement(By.xpath("//div[@class='pay__wrapper']/a"));
        actions.click(element).perform();
        boolean displayed = webDriver.findElement(By.id("breadcrumbs")).isDisplayed();
        assertTrue(displayed);
        webDriver.navigate().back();
    }

    @AfterAll
    public static void close() {
        webDriver.close();
    }
}