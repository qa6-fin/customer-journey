package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AggregatorPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By enterPhone = By.xpath("//input[@placeholder='Enter your 10 digit mobile number']");
	By getOtp = By.xpath("//button[text()='Get OTP']");
	By verifyBtn = By.xpath("//button[text()='Verify']");
	By useAccount = By.xpath("//button[text()='Use Account']");
	By clickAgree = By.xpath("//button[text()='I Agree']");
	
	public AggregatorPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void enterPhoneNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterPhone)).sendKeys(number);
    }

    public void clickGetOtp() {
        wait.until(ExpectedConditions.elementToBeClickable(getOtp)).click();
    }

    public void waitForVerifyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn));
    }

    public void clickVerifyBtn() {
        driver.findElement(verifyBtn).click();
    }

    public void waitForUseAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(useAccount));
    }

    public void useAccount() {
        driver.findElement(useAccount).click();
    }

    public void waitForAgreeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickAgree));
    }

    public void clickOnAgreeBtn() {
        driver.findElement(clickAgree).click();
    }
}
