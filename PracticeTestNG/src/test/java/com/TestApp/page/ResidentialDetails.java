package com.TestApp.page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResidentialDetails {
	private WebDriver driver;
	private final By residenceOption = By.xpath("");//Your Residence
	private final By clickNext = By.xpath("//span[text()='Next']");//Enter your current address
	private final By nextBtn = By.xpath("//span[text()='Next']");

	public ResidentialDetails(WebDriver driver) {
		this.driver = driver;
	}
	//Your Residence
	 public void selectResidence() throws InterruptedException {
		 List<WebElement> options = driver.findElements(residenceOption);
		 if (options.isEmpty()) {
			 Random rand = new Random();
			 WebElement randomOption = options.get(rand.nextInt(options.size()));
			 System.out.println("Your Residence: " + randomOption.getText());
			 randomOption.click();
			 Thread.sleep(1000);
		 }
		 else {
			 throw new RuntimeException(" ERRORRRRR ");
		 }
	 }
	 //Enter your current address
	 public void clickNext() {
		 driver.findElement(clickNext).click();
	 }
	 public void nextBtn() {
		 driver.findElement(nextBtn).click();
	 }
}
