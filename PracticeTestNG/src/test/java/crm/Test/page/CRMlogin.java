package crm.Test.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMlogin {
	private WebDriver driver;
	WebDriverWait wait;
	private By userNameField = By.xpath("//input[@placeholder='Enter Name']");
	private By passwordField = By.xpath("//input[@placeholder='Password']");
	private By SignInBtn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/form/div/div/div[4]/button");
	private By errorMsg = By.xpath("");
	private By otpField = By.xpath("//input[@placeholder='Enter Your OTP']");
	private By verifyBtn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/form/div/div/div[2]/button");
	
	
	public CRMlogin(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void enterUserName(String userName) {
		driver.findElement(userNameField).clear();
		driver.findElement(userNameField).sendKeys(userName);
	}
	public void enterPassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickSignIn() {
		driver.findElement(SignInBtn).click();
	}
	public String getErrorMessage() {
		return driver.findElement(errorMsg).getText();
	}
	public void enterOtp(String otp) {
		wait.until(ExpectedConditions.elementToBeClickable(otpField)).sendKeys(otp);
	}
	public void clickVerify() {
		wait.until(ExpectedConditions.elementToBeClickable(verifyBtn)).click();
	}

}
