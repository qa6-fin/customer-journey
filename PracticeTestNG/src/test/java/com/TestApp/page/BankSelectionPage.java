package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BankSelectionPage {

    WebDriver driver;
    WebDriverWait wait;
    private By verifyBankDetails = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/button");
    private By searchInput = By.xpath("//input[@placeholder='Search Bank']");
    private By clickSBIBank = By.xpath("//div[@data-ref='normal_bank' and .//div[text()='State Bank of India']]");
    
    public BankSelectionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickverifyBankDetails() {
    	wait.until(ExpectedConditions.elementToBeClickable(verifyBankDetails));
    }

 // Search and select a bank
    public void searchAndSelectBank(String bankName) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(bankName);;
    }
//   click on SBI bank
    public void clickOnSBIBank() {
    	wait.until(ExpectedConditions.elementToBeSelected(clickSBIBank));
    }
   
}
