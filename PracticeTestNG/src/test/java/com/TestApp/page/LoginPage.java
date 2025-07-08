package com.TestApp.page;import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriverWait wait;
    WebDriver driver;

    private By mobileField = By.name("mobileNumber");
    private By getOtpBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[1]/button/span");
    private By otpField = By.name("otp");
    private By verifyOtpBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[2]/button");
    private By errorMsg = By.xpath("//*[contains(text(),'Enter 10 digit valid mobile number') or contains(text(),'Incorrect OTP') or contains(text(),'required')]" );
    
    public LoginPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterMobileNumber(String mobile) {
    	WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
    	mobileInput.clear();
    	mobileInput.sendKeys(mobile);
    	;
    }

    public void clickGetOtp() {
        WebElement otpBtn  = wait.until(ExpectedConditions.elementToBeClickable(getOtpBtn));
        otpBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("otp")));
    }

    public void enterOtp(String otp) {
        WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(otpField));
        otpInput.sendKeys(otp);
    }

    public void clickVerify() {
    	WebElement verifyBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(verifyOtpBtn));
    	verifyBtn.click();
    	
    }

    public String getErrorMessage() {
    	WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return error.getText();
    }
}
