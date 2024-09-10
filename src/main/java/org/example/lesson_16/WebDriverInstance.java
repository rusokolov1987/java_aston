package org.example.lesson_16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInstance {
    public static WebDriver webDriver;

    public static WebDriver getWebDriverInstance() {
        WebDriverManager.chromedriver().setup();
        if (webDriver == null) {
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }
}
