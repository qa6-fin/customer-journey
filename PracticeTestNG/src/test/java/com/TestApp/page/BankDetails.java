package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankDetails {
	WebDriver driver;
	WebDriverWait wait;
	
	By accountHolderField = By.name("accountHolderName");
	By accountNumberField = By.name("accountNo");
	By re_enterAccountNumber = By.name("confirmedAccountNo");
	By ifscField = By.name("ifsc");
	By bankNameField = By.name("bankName");
	By nextBtn = By.xpath("//button[.//span[text()='Next']]");
	By yesOrNo = By.xpath("//button[text()='YES']");
	By sbiContinueButton= By.xpath("//button[.//span[text()='Continue']]");
	By continueButton= By.xpath("//button[.//span[text()='Continue']]");
	By eManadateContinue = By.xpath("//button[.//span[text()='Continue']]");
	By continueButon= By.xpath("//button/span[text()='Continue']");
	
	
	public BankDetails(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void holderNameInput(String name) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountHolderField)).sendKeys(name);
	}
	public void accountNumberInput(String number) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountNumberField)).sendKeys(number);
	}
	public void re_enterAccountNumInput(String number) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(re_enterAccountNumber)).sendKeys(number);
	}
	public void ifscInput(String ifsc) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ifscField)).sendKeys(ifsc);
	}
	public void bankNameField(String bankname) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(bankNameField)).sendKeys(bankname);
	}
	public void clickNext() {
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
	}
	public void clickYES() {
		wait.until(ExpectedConditions.elementToBeClickable(yesOrNo)).click();
	}
	public void sbiContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(sbiContinueButton)).click();
		System.out.println("SBI continue click");
	}
	public void continueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
		System.out.println(" continue click");
	}
	public void eManadatecontinueButtn() {
		wait.until(ExpectedConditions.elementToBeClickable(eManadateContinue)).click();
		System.out.println("emanadate click");
	}
	public void continueButon() {
		wait.until(ExpectedConditions.elementToBeClickable(continueButon)).click();
	}
}
