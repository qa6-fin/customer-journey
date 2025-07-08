package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyBankDetailsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By verifyBank = By.xpath("//button[.//span[text()='Verify bank details']]");
	By oneTimeVerification = By.xpath("(//div[contains(@class,'loan-lists') and .//h3[text()='One-time Repayment']])[1]");
	By continueBtn = By.xpath("//button[.//span[text()='Continue']]");

	public VerifyBankDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	public void clickOnVerifyBankDetails() {
		WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(verifyBank));
		verifyButton.click();
		System.out.println("bankverify");
	}
	public void clickOneTimeVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(oneTimeVerification)).click();
		System.out.println("one time bankverify");
	}
	public void clickOnContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
		System.out.println("OTR continue click");
	}
}
