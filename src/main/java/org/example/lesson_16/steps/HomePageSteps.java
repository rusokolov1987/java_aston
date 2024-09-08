package org.example.lesson_16.steps;

import org.example.lesson_16.DTO.OnlinePaymentPageDTO;
import org.example.lesson_16.DTO.OnlinePaymentPopUpDTO;
import org.example.lesson_16.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.example.lesson_16.WebDriverInstance.webDriver;

public class HomePageSteps {
    private final HomePage homePage = new HomePage();
    private final HomePage.OnlinePaymentPage onlinePaymentPage = new HomePage.OnlinePaymentPage();
    private final HomePage.OnlinePaymentPopUp onlinePaymentPopUp = new HomePage.OnlinePaymentPopUp();

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

    public void fillCardNumber(String cardNumber) {
        onlinePaymentPopUp.getCarNumber().sendKeys(cardNumber);
    }

    public void fillValidityPeriod(String validityPeriod) {
        onlinePaymentPopUp.getValidityPeriod().sendKeys(validityPeriod);
    }

    public void fillSecretCode(String secretCode) {
        onlinePaymentPopUp.getSecretCode().sendKeys(secretCode);
    }

    public void fillHolderName(String holderName) {
        onlinePaymentPopUp.getHolderName().sendKeys(holderName);
    }

    public void fillPaymentPopUp(OnlinePaymentPopUpDTO onlinePaymentPopUpDTO) {
        fillCardNumber(onlinePaymentPopUpDTO.getCardNumber());
        fillSecretCode(onlinePaymentPopUpDTO.getSecretCode());
        fillValidityPeriod(onlinePaymentPopUpDTO.getValidityPeriod());
        fillHolderName(onlinePaymentPopUpDTO.getHolderName());
    }

    public void switchToFramePopUp() {
        webDriver.switchTo().frame(onlinePaymentPopUp.getFramePopUp());
    }

    public String getTextPopUpTitle() {
        return onlinePaymentPopUp.getTotalTitle().getText();
    }

    public String getTextPopUpButton() {
        return onlinePaymentPopUp.getPopUpButton().getText();
    }

    public String getTextPopUp() {
        return onlinePaymentPopUp.getPhoneText().getText();
    }

    public String getCardNumberText() {
        return onlinePaymentPopUp.getLabelCardNumber().getText();
    }

    public String getValidityPeriodText() {
        return onlinePaymentPopUp.getLabelValidityPeriod().getText();
    }

    public String getSecretCodeText() {
        return onlinePaymentPopUp.getLabelSecretCode().getText();
    }

    public String getHolderNameText() {
        return onlinePaymentPopUp.getLabelHolderName().getText();
    }

    public ArrayList<String> getSrcCardBrands() {
        ArrayList<String> list = new ArrayList<>();
        for (WebElement cardBrand : onlinePaymentPopUp.getCardBrands()) {
            list.add(cardBrand.getAttribute("src"));
        }
        return list;
    }
}
