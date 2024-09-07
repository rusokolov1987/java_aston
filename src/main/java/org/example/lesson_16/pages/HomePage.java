package org.example.lesson_16.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.lesson_16.WebDriverInstance.webDriver;

public class HomePage {
    private final By onlinePaymentPage = By.xpath("//section[@class='pay']");
    private final By onlinePaymentPopUp = By.xpath("//div[@class='app-wrapper']");

    public WebElement getOnlinePaymentPage() {
        return webDriver.findElement(onlinePaymentPage);
    }

    public WebElement getOnlinePaymentPopUp() {
        return webDriver.findElement(onlinePaymentPopUp);
    }

    public static class OnlinePaymentPage {
        private final By dropDownButton = By.xpath("//div[@class='select']");
        private final By paymentTypes = By.xpath("//div[@class='select']//ul[@class='select__list']/li/p");
        private final By phoneField = By.id("connection-phone");
        private final By totalField = By.id("connection-sum");
        private final  By emailField = By.id("connection-email");
        private final By button = By.xpath("//*[@id='pay-connection']/button");

        public WebElement getDropdownButton() {
            return webDriver.findElement(dropDownButton);
        }

        public WebElement getSpecialField(String paymentType) {
            String specialFieldPattern = "//form[@class='pay-form opened']//input[@id='%s']";
            String specialFieldName = getSpecialFieldId(paymentType);
            By specialField = By.xpath(String.format(specialFieldPattern, specialFieldName));
            return webDriver.findElement(specialField);
        }

        public WebElement getPhoneField() {
            return webDriver.findElement(phoneField);
        }

        public WebElement getTotalField() {
            return webDriver.findElement(totalField);
        }

        public WebElement getEmailField() {
            return webDriver.findElement(emailField);
        }

        public WebElement getButton() {
            return webDriver.findElement(button);
        }

        private String getSpecialFieldId(String paymentType) {
            return switch (paymentType) {
                case "Услуги связи" -> "connection-phone";
                case "Домашний интернет" -> "internet-phone";
                case "Рассрочка" -> "score-instalment";
                case "Задолженность" -> "score-arrears";
                default -> throw new IllegalStateException("Unexpected value: " + paymentType);
            };
        }

        public WebElement getPaymentType(String paymentType) {
            WebElement elementType = null;
            List<WebElement> types = webDriver.findElements(paymentTypes);
            for (WebElement element: types) {
                if(element.getText().equals(paymentType)) {
                    elementType = element;
                }
            }
            return elementType;
        }
    }

    public static class OnlinePaymentPopUp {
        private final By closePopUpButton = By.xpath("//svg-icon[@class='header__close-icon']");
        private final By totalTitle = By.xpath("//div[@class='pay-description__cost']/span");
        private final By phoneText = By.xpath("//div[@class='pay-description__text']/span");
        private final By cardInfo = By.id("cc-number");
        private final By validityPeriod = By.xpath("//div[@class='content ng-tns-c46-4']/input");
        private final By secretCode = By.xpath("//input[@name='verification_value']");
        private final By popupButton = By.xpath("//button[@class='colored']");



    }
}
