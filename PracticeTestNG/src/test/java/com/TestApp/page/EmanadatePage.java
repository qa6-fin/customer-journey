package com.TestApp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmanadatePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By iframeLocator = By.cssSelector("iframe.razorpay-checkout-frame");
    private By contactDetails = By.xpath("//input[@id='contact' and @name='contact']");
    private By authenticateBtn = By.xpath("//button[contains(text(), 'Authenticate')]");
    By authenticateUsingAadhaar= By.xpath("//div[contains(@class, 'auth-option') and contains(., 'Aadhaar')]");

    public EmanadatePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void enterContactNumber(String number) {
        // Switch to iframe
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
        WebElement contactField = wait.until(ExpectedConditions.visibilityOfElementLocated(contactDetails));
        contactField.clear();
        contactField.sendKeys(number);
        System.out.println("Filled number: " + number);
    }
    public void clickAuthenticate() {
        WebElement authBtn = wait.until(ExpectedConditions.elementToBeClickable(authenticateBtn));
        authBtn.click();
        System.out.println("Clicked Authenticate");

        // Switch back to main content
        driver.switchTo().defaultContent();
    }
    public void clickUsingAadhaar() {
    	WebElement adhaarAuthBtn = wait.until(ExpectedConditions.elementToBeClickable(authenticateUsingAadhaar));
    	adhaarAuthBtn.click();
    }
    
}
