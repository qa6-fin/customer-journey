package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepeatJourneyPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public RepeatJourneyPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	
	private By mobileField = By.name("mobileNumber");
    private By getOtpBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[1]/button/span");
    private By otpField = By.name("otp");
    private By verifyOtpBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[2]/button");
    
	By greetText = By.xpath("//div[contains(text(), 'Hi, Ajay')]");
	By getCashBtn = By.xpath("//button[.//span[text()='Get Cash']]");
	
	
	 public void enterMobileNumber(String mobile) {
	    	WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
	    	mobileInput.clear();
	    	mobileInput.sendKeys(mobile);
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
	public String getGreetText() {
		return driver.findElement(greetText).getText();
		
	}
	public void clickGetCash() {
		wait.until(ExpectedConditions.elementToBeClickable(getCashBtn)).click();
	}

}
