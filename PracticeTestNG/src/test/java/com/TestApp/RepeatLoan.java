package com.TestApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RepeatLoan {
	WebDriver driver;
	WebDriverWait wait;
	
	By enterMobNum = By.xpath("//input[@placeholder = 'Enter your mobile number']");
	By getOtp = By.xpath("//button[.//span[text()='Get OTP']]");
	By verifyBtn = By.xpath("//*[@id=\"root\"]/div/form/div/div[1]/div[2]/input");
	By otpField = By.xpath("//input[@type='tel']");
//	By loanAmount = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/h1");
	By getCash = By.xpath("//button/span[text()='Get Cash']");

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demorf-sandeepa.ramfincorp.co.in/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
	}
	public void mobileNumField() {
		WebElement mobInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobNum));
		mobInput.sendKeys("9782967441");
	}
	public void clickGetOtp() {
		WebElement getOtpBtn = wait.until(ExpectedConditions.elementToBeClickable(getOtp));
		getOtpBtn.click();
	}
	public void clickverifyBtn() {
		WebElement clickVerify = wait.until(ExpectedConditions.elementToBeClickable(verifyBtn));
		clickVerify.click();
	}
	   public void waitForManualOtpAndClickVerify() {
	        wait.until(driver -> {
	            WebElement otpInput = driver.findElement(otpField);
	            String value = otpInput.getAttribute("value");
	            return value != null && !value.trim().isEmpty();
	        });
	        System.out.println("OTP manually entered. Proceeding to click Verify.");
	        driver.findElement(verifyBtn).click();
	    }
	
//	public void enterOtpField() {
//		WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(otpField));
//		otpInput.sendKeys(null);
//	}
	
//	public boolean isLoanAmountVisible() {
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loanAmount));
//		return element.isDisplayed();
//	}

	public void clickGetCash() {
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(getCash));
		btn.click();
	}
	//Test Method
	@Test
	public void runTest() {
	
//		 if (isLoanAmountVisible()) {
//	            System.out.println("Loan amount is visible");
//	        } else {
//	            System.out.println("Loan amount not visible");
//	        }

		
		mobileNumField();
		clickGetOtp();
	    waitForManualOtpAndClickVerify();
		clickverifyBtn();
	    clickGetCash();
	        
		
	}
}
