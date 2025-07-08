package com.TestApp.page;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndustryPage {
	
	private WebDriver driver;
	WebDriverWait wait;
	private final By industryOptions = By.xpath("//div[contains(@class, 'select-option')]");//industry
	private By designationOption = By.xpath("//div[contains(@class, 'select-option')]");//designation
	
	
	public IndustryPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void SelectrandomIndustry() {
		List<WebElement> options =  driver.findElements(designationOption);
		System.out.println("\nTotal Industry Options: " + options.size());
//	for (WebElement option : options) {
//		System.out.println("Option Text: " + option.getText());
//	}
	if(!options.isEmpty()) {
		Random rand = new Random();
		WebElement randomOption = options.get(rand.nextInt(options.size()));
		randomOption.click();
	}
	else {
		throw new RuntimeException("No Industry Option found");
	}	
	
  }
	public void selectRandomDesignation() {
		List<WebElement> options = driver.findElements(industryOptions);
		System.out.println("\nTotal Designation Options: " +options.size());
		for(WebElement option : options) {
			System.out.println("Option Text: "+ option.getText());
		}
		if(!options.isEmpty()) {
			Random rand = new Random();
				WebElement randomOption = options.get(rand.nextInt(options.size()));
				randomOption.click();
			}
		
		else {
			throw new RuntimeException("No designation found");
		}
	}
}
