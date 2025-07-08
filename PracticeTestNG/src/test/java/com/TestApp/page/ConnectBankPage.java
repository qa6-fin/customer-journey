package com.TestApp.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class ConnectBankPage {

    WebDriver driver;
    WebDriverWait wait;
    By fetchOption = By.xpath("//div[contains(text(), 'Fetch using Phone Number')]");
    By netBanking = By.xpath("//div[contains(text(), 'Net Banking')]");
    By upload = By.xpath("//div[contains(text(), 'Upload Statement')]");
    By backButton = By.xpath("//*[@id=\"bcnavbar\"]/span[1]/svg/path[2]");
    
    public ConnectBankPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    //  Click Fetch using Phone Number
    public void clickFetchUsingPhoneNumber() {
    	wait.until(ExpectedConditions.elementToBeClickable(fetchOption)).click();
    }

    //  You can add others similarly:
    public void clickNetBanking() {
        wait.until(ExpectedConditions.elementToBeClickable(netBanking)).click();
    }

    public void clickUploadStatement() {
    	wait.until(ExpectedConditions.elementToBeClickable(upload)).click();
    }
    public void clickBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }
    public boolean isErrorMessageDisplayed() {
        try {
            return driver.findElement(By.xpath("//*[contains(text(),'Failed') or contains(text(),'Error')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
