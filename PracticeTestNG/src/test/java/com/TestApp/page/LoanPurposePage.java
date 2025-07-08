package com.TestApp.page;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanPurposePage {


    private WebDriver driver;
    WebDriverWait wait;
    

    // XPath to capture all the loan purpose options
    private final By loanPurposeOptions = By.xpath("//div[contains(@class, 'select-option')]");
    
    public LoanPurposePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    public void selectRandomLoanPurpose() {
        System.out.println("Options: " + loanPurposeOptions);
        List<WebElement> options = driver.findElements(loanPurposeOptions);
        System.out.println("Total Options: " + options.size());

//        for (WebElement option : options) {
//            System.out.println("Option Text: " + option.getText());
//        }

        if (!options.isEmpty()) {
            Random rand = new Random();
            WebElement randomOption = options.get(rand.nextInt(options.size()));
            randomOption.click();
        } else {
            throw new RuntimeException("No loan purpose options found!");
        }
    }
}
