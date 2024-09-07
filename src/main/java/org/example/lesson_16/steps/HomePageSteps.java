package org.example.lesson_16.steps;

import org.example.lesson_16.DTO.OnlinePaymentPageDTO;
import org.example.lesson_16.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.example.lesson_16.WebDriverInstance.webDriver;

public class HomePageSteps {
    private final HomePage homePage = new HomePage();
    private final HomePage.OnlinePaymentPage onlinePaymentPage = new HomePage.OnlinePaymentPage();

    public void scrollToPaymentSection() {
        WebElement paymentSection = homePage.getOnlinePaymentPage();
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", paymentSection);
    }

    public void clickDropdownButton() {
        onlinePaymentPage.getDropdownButton().click();
    }

    public void selectPaymentType(String paymentType) {
        onlinePaymentPage.getPaymentType(paymentType).click();
    }

    public String getPlaceholderPhoneNumber() {
        return onlinePaymentPage.getPhoneField().getAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return onlinePaymentPage.getEmailField().getAttribute("placeholder");
    }

    public String getPlaceholderTotal() {
        return onlinePaymentPage.getTotalField().getAttribute("placeholder");
    }

    public void fillOnlyPaymentTypeField(OnlinePaymentPageDTO onlinePaymentPageDTO) {
        selectPaymentType(onlinePaymentPageDTO.getPaymentType());
    }

    public void fillSpecialField(String paymentType, String text) {
        onlinePaymentPage.getSpecialField(paymentType).sendKeys(text);
    }

    public void fillSumField(String sumAmount) {
        onlinePaymentPage.getTotalField().sendKeys(sumAmount);
    }

    public void fillEmailField(String email) {
        onlinePaymentPage.getEmailField().sendKeys(email);
    }

    public void fillPaymentPage(OnlinePaymentPageDTO onlinePaymentPageDTO) {
        selectPaymentType(onlinePaymentPageDTO.getPaymentType());
        fillSpecialField(onlinePaymentPageDTO.getPaymentType(), onlinePaymentPageDTO.getSpecialField());
        fillSumField(onlinePaymentPageDTO.getTotal());
        fillEmailField(onlinePaymentPageDTO.getEmail());
    }

    public void clickButton() {
        onlinePaymentPage.getButton().click();
    }
}
