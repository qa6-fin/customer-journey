package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PanVerificationPage {

//	private WebDriver driver;
	WebDriverWait wait;
	private By panField = By.cssSelector("input.form-control[name='pan']");
	private By nextBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[2]/button");
	private By errorMsg = By.xpath("//*[@id=\"root\"]/div/form/div/div[1]/div[3]/div");
	private By button = By.xpath("//*[@id=\"root\"]/div/form/div/div[4]/div/button[2]");
	
	
	public PanVerificationPage(WebDriver driver) {
//		this.driver = driver; 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void enterPan(String pan) {
		WebElement panInput = wait.until(ExpectedConditions.visibilityOfElementLocated(panField));
		panInput.clear();
		panInput.sendKeys(pan);
	}
	public void clickNext() {
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		nextButton.click();
	}
	public void errorMsg() {
		WebElement errorMSG = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
		errorMSG.isDisplayed();
	}
	public void clickYes() {
		WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(button));
		yesBtn.click();
	}
}
