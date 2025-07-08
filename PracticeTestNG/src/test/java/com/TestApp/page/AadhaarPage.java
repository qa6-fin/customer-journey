package com.TestApp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AadhaarPage {

    private WebDriver driver;

    private By aadhaarField = By.xpath("//input[@placeholder='Enter your aadhaar number']");
    private By nextBtn = By.xpath("//span[text()='Next']");
    private By otpField = By.xpath("//input[@placeholder='Enter OTP']");
    private By verifyBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[2]/button");
    private By errorText = By.xpath("//*[@id=\"root\"]/div/form/div/div[1]/div[2]/div[2]/div[2]/div");
    private By resendOtpBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[1]/div[2]/div[2]/div[5]/p[2]/span[1]");
    private By digilockerBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[1]/div[2]/div[1]/div/div[2]");
    
    public AadhaarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAadhaar(String aadhaar) {
        driver.findElement(aadhaarField).sendKeys(aadhaar);
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }

    public void enterOtp(String otp) {
        driver.findElement(otpField).sendKeys(otp);
    }

    public void clickVerify() {
        driver.findElement(verifyBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorText).getText();
    }

    public boolean isResendOtpVisible() {
        return driver.findElement(resendOtpBtn).isDisplayed();
    }
    
    public void clickDigilockerOption() {
        driver.findElement(digilockerBtn).click();
    }
}

