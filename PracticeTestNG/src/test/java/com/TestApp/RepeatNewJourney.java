package com.TestApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.TestApp.page.RepeatJourneyPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RepeatNewJourney {
	private WebDriver driver;
	RepeatJourneyPage repeatJrnyP;
	

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demorf-dev.ramfincorp.co.in");
        repeatJrnyP = new RepeatJourneyPage(driver);
     
    }

    @Test(priority = 1)
    public void validLoginTest() throws IOException {
    	
      
    	repeatJrnyP.enterMobileNumber("9782967441");
    	repeatJrnyP.clickGetOtp();
//            MySQLConnection_Stagging mydb = new MySQLConnection_Stagging();
            MySQLConnection_Dev mydb = new MySQLConnection_Dev();

            String otp = mydb.getOtpFromDB("9782967441");
            repeatJrnyP.enterOtp(otp);
            repeatJrnyP.clickVerify();
//            
            System.out.println("Login successful, screenshot saved.");
//            ScreenshotUtil.takeScreenshot(driver, "AfterLogin.png");
           
    }

}
