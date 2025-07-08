package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetCash {

//	private WebDriver driver;
	WebDriverWait wait;
	private By getCashBtn = By.xpath("//button[.//span[text()='Get Cash']]");
	private By nameField = By.name("name");
	private By emailField = By.name("email");
	private By nextBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[2]/button/span");
	
	public GetCash(WebDriver driver) {
//		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	 public void clickGetCash() {
	        WebElement clickGet = wait.until(ExpectedConditions.elementToBeClickable(getCashBtn));
	        clickGet.click();
	    }

	    public void enterName(String name) {
	        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
	        nameInput.clear();
	        nameInput.sendKeys(name);
	    }

	    public void enterMail(String email) {
	        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
	        emailInput.clear();
	        emailInput.sendKeys(email);
	    }

	    public void clickNext() {
	        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
	    }

}