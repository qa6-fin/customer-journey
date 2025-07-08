package com.TestApp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfessionalPage {
	private WebDriver driver;
	
	private final By incomeInput = By.name("monthlyIncome");
	private final By nextBtn = By.xpath("//span[text()='Next']");
	private final By errorMSG = By.xpath("/html/body/div/div/form/div/div[1]/div[3]/div");
	
	
	 public ProfessionalPage(WebDriver driver){
		this.driver = driver;
	}
	 
	public void MonthlyIncomePage(String income) {
		driver.findElement(incomeInput).clear();
		driver.findElement(incomeInput).sendKeys(income);	
	}
	public void clickNext() {
		driver.findElement(nextBtn).click();
	}
	public String getError() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(errorMSG).getText();
	}
	
}
