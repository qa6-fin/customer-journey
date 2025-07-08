package com.TestApp.page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmploymentDetails {
	private WebDriver driver;
	private final By experienceOption = By.xpath("//div[contains(@class, 'select-option')]");//work experience
	
	private final By dateOptions = By.xpath("");//Date of Salary

	public EmploymentDetails(WebDriver driver) {
		this.driver = driver;
	}
	public void WorkExperience() throws InterruptedException {
		List<WebElement> options =  driver.findElements(experienceOption);
		System.out.println("\nWork Experience Options: " + options.size());
		for(WebElement option : options) {
			System.out.println("Option Text: " + option.getText());
		} 
		if(!options.isEmpty()) {
			Random rand = new Random();
			WebElement randomOption = options.get(rand.nextInt(options.size()));
			randomOption.click();
			Thread.sleep(1000);
		}
		else {
			throw new RuntimeException("No Work Experience");
		}
	}
	//Date of Salary 
	 public void selectRandomSalaryDate() throws InterruptedException {
	        List<WebElement> dates = driver.findElements(dateOptions);

	        if (!dates.isEmpty()) {
	        	Random rand = new Random();
	            WebElement randomDate = dates.get(rand.nextInt(dates.size()));
	            System.out.println("\nSelected date: " + randomDate.getText());
	            randomDate.click();

	            Thread.sleep(1000); // Wait for UI transition if needed
	        } else {
	            throw new RuntimeException(" No salary date options found!");
	        }
	 }
	 
}
