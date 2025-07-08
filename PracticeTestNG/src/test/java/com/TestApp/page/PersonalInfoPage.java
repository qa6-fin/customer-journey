package com.TestApp.page;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInfoPage {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	private By genderOptions = By.xpath("//div[contains(@class, 'select-option')]");
	private By maritalStatusOptions = By.xpath("//div[contains(@class, 'select-option')]");
	private By educationOptions = By.xpath("//div[contains(@class, 'select-option')]");
	//Employement Details
	private By salariedOption = By.xpath("/html/body/div/div/div[3]/div");
	private By selfEmployee = By.xpath("//*[@id=\"root\"]/div/div[4]/div");
	//Mode Of Payment
	private By paymentOption = By.xpath("//div[contains(@class, 'select-option')]");
	//Company's Details
	private final By companyNameInput = By.name("companyName");
	private final By nextBtn =By.xpath("//span[text()='Next']");
	
	
	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	 public void selectRandomGender() {
	        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(genderOptions));
	        System.out.println("Total Gender Options: " + options.size());

//	        for (WebElement option : options) {
//	    		System.out.println("Option Text: " + option.getText());
//	    	}
//	        
	        if (!options.isEmpty()) {
	            Random rand = new Random();
	            WebElement randomOption = options.get(rand.nextInt(options.size()));
	            System.out.println("Selected Gender: " + randomOption.getText());
	            randomOption.click();
	        } else {
	            throw new RuntimeException("No gender options found");
	        }
	    }
	// Select random marital status
    public void selectRandomMaritalStatus() {
    	System.out.println("Options: " + maritalStatusOptions);
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(maritalStatusOptions));
        System.out.println("Marital Status Options Found: " + options.size());
        
//        for (WebElement option : options) {
//            System.out.println("Marital Status Option: " + option.getText());
//        }
        if (!options.isEmpty()) {
            Random rand = new Random();
            WebElement selected = options.get(rand.nextInt(options.size()));
            System.out.println("Selected Marital Status: " + selected.getText());
            selected.click();
        } else {
            throw new RuntimeException("No marital status options found!");
        }
    }
    //SELECT HIGHEST EDUCATION DETAILS
    public void selectRandomEducation() {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(educationOptions));
        System.out.println("Total Education Options: " + options.size());

//        for (WebElement option : options) {
//            System.out.println("Option: " + option.getText());
//        }

        if (!options.isEmpty()) {
            Random random = new Random();
            WebElement randomOption = options.get(random.nextInt(options.size()));
            randomOption.click();
        } else {
            throw new RuntimeException("No education options found!");
        }
    }
    
    // Select Employment Details
    
    public void selectEmploymentStatus(String status) throws InterruptedException {
        if (status.equalsIgnoreCase("salaried")) {
            driver.findElement(salariedOption).click();
        } else if (status.equalsIgnoreCase("self")) {
            driver.findElement(selfEmployee).click();
        } else {
            throw new IllegalArgumentException("Invalid employment status: " + status);
        }
        Thread.sleep(1000); // optional wait for page transition or animation
    }
    
    //Mode of Payment 
    public void selectPaymentMode() {
    	List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentOption));
    	System.out.println("'Total Mode of Payment Options: " +options.size());
//    	for(WebElement option : options) {
//    		System.out.println("Options: " +option.getText());
//    	}
    	if (!options.isEmpty()) {
    		Random random = new Random();
    		WebElement randomOption = options.get(random.nextInt(options.size()));
    		randomOption.click();
    	}
    	else {
    		throw new RuntimeException("No payment options found");
    		}
    	}
    //Company's name
    public void enterCompanyName(String company) {
    	WebElement companyName = wait.until(ExpectedConditions.visibilityOfElementLocated(companyNameInput));
    	companyName.clear();
    	companyName.sendKeys(company);
    }
    public void clickNext() {
    	wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
    }
}