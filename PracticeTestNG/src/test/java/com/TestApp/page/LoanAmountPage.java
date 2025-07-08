package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanAmountPage {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	private final By amountInput = By.name("loanAmount");
	private final By nextBtn = By.xpath("//span[text()='Next']");
	private final By errorMsg = By.xpath("/html/body/div/div/form/div/div[1]/div[3]/div");

	
	public LoanAmountPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void enterAmount(String amount) {
		WebElement amountInp = wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
		amountInp.clear();
		amountInp.sendKeys(amount);
		
	}
	
	public void clickNext() {
		WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		next.click();
		
	}
	public String getErrorMessage() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(errorMsg).getText();
	}
	

}
