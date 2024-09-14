package org.example.lesson_16.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
        private final By framePopUp = By.xpath("//iframe[@class='bepaid-iframe']");
        private final By totalTitle = By.xpath("//div[@class='pay-description__cost']/span");
        private final By phoneText = By.xpath("//div[@class='pay-description__text']/span");
        private final By cardNumber = By.id("cc-number");
        private final By validityPeriod = By.xpath("//div[@class='content ng-tns-c46-4']/input");
        private final By secretCode = By.xpath("//input[@name='verification_value']");
        private final By holderName = By.xpath("//div[@class='content ng-tns-c46-3']/input");
        private final By popupButton = By.xpath("//button[@class='colored']");
        private final By labelCardNumber = By.xpath("//p[@class='error-message ng-tns-c46-1 ng-star-inserted']");
        private final By labelValidityPeriod = By.xpath("//p[@class='error-message ng-tns-c46-4 ng-star-inserted']");
        private final By labelSecretCode = By.xpath("//p[@class='error-message ng-tns-c46-5 ng-star-inserted']");
        private final By labelHolderName = By.xpath("//p[@class='error-message ng-tns-c46-3 ng-star-inserted']");

        private final By cardBrands = By.xpath("//div[@class='icons-container ng-tns-c46-1']//img");

        public WebElement getFramePopUp() {
            return webDriver.findElement(framePopUp);
        }

        public WebElement getTotalTitle() {
            return webDriver.findElement(totalTitle);
        }

        public WebElement getPhoneText() {
            return webDriver.findElement(phoneText);
        }

        public WebElement getCarNumber() {
            return webDriver.findElement(cardNumber);
        }

        public WebElement getValidityPeriod() {
            return webDriver.findElement(validityPeriod);
        }

        public WebElement getSecretCode() {
            return webDriver.findElement(secretCode);
        }

        public WebElement getPopUpButton() {
            return webDriver.findElement(popupButton);
        }

        public WebElement getHolderName() {
            return webDriver.findElement(holderName);
        }

        public WebElement getLabelCardNumber() {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(10000));
            wait.until(ExpectedConditions.textToBePresentInElement(webDriver.findElement(labelCardNumber), "Некорректный номер карты"));
            return webDriver.findElement(labelCardNumber);
        }

        public WebElement getLabelValidityPeriod() {
            return webDriver.findElement(labelValidityPeriod);
        }

        public WebElement getLabelSecretCode() {
            return webDriver.findElement(labelSecretCode);
        }

        public WebElement getLabelHolderName() {
            return webDriver.findElement(labelHolderName);
        }

        public List<WebElement> getCardBrands() {
            return webDriver.findElements(cardBrands);
        }
    }
}
