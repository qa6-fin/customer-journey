package com.TestApp;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ScreenshotUtil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.TestApp.page.AadhaarPage;
import com.TestApp.page.AggregatorPage;
import com.TestApp.page.BankDetails;
import com.TestApp.page.BankSelectionPage;
import com.TestApp.page.ConnectBankPage;
import com.TestApp.page.EmanadatePage;
import com.TestApp.page.EmploymentDetails;
import com.TestApp.page.IndustryPage;
import com.TestApp.page.GetCash;
import com.TestApp.page.LoanAmountPage;
import com.TestApp.page.LoanPurposePage;
import com.TestApp.page.LoginPage;
import com.TestApp.page.PanVerificationPage;
import com.TestApp.page.PersonalInfoPage;
import com.TestApp.page.ProfessionalPage;
import com.TestApp.page.ResidentialDetails;
import com.TestApp.page.VerifyBankDetailsPage;


public class LoginTests {
	
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demorf-dev.ramfincorp.co.in");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void validLoginTest() throws IOException {
      
            loginPage.enterMobileNumber("9782967441");
            loginPage.clickGetOtp();
//            MySQLConnection_Stagging mydb = new MySQLConnection_Stagging();
            MySQLConnection_Dev mydb = new MySQLConnection_Dev();

            String otp = mydb.getOtpFromDB("9782967441");
            loginPage.enterOtp(otp);
            loginPage.clickVerify();
//            
            System.out.println("Login successful, screenshot saved.");
            ScreenshotUtil.takeScreenshot(driver, "AfterLogin.png");
           
    }
    //Get Cash page
//    @Test(priority = 2)
//    public void getCash() throws InterruptedException {
//    	 Thread.sleep(10000); // Wait for get cash Page
//         GetCash getCash = new GetCash(driver);
//         getCash.clickGetCash(); 
//         driver.get("https://demorf-sandeepa.ramfincorp.co.in/enter-name");
//         getCash.enterName("Ajay Kumar Meena");
//         getCash.enterMail("qa6@ramfincorp.com");
//         getCash.clickNext();
//    }
    //Pan Verification
//    @Test (priority = 3)
//    public void panVerify() {
//    	PanVerificationPage verifyPan = new PanVerificationPage(driver);
////    	 driver.get("https://demorf-sandeepa.ramfincorp.co.in/enter-your-pan");
//    			verifyPan.enterPan("GCXPM2357B");
//    			verifyPan.clickNext();
//    			verifyPan.clickYes();
//    }
//    //Aadhaar Verification
//    @Test(priority = 4)
//    public void aadharVerify() throws InterruptedException {
////    	driver.get("https://demorf-sandeepa.ramfincorp.co.in/enter-aadhar");
//    	AadhaarPage aadhaarPage = new AadhaarPage(driver);
//    	Thread.sleep(10000);
//    	aadhaarPage.enterAadhaar("604558262633");
//    	aadhaarPage.clickNextBtn();
//    	//aadhaarPage.enterOtp();//enter otp manually
//    	Thread.sleep(20000);
//    	aadhaarPage.clickNextBtn();
//    }
//
//    //Loan purpose page
//    @Test(priority = 5)
//    public void loanPurpose() throws IOException {
////    	driver.get("https://demorf2.ramfincorp.co.in/loan-purpose");
//        
//        LoanPurposePage loanPurpose = new LoanPurposePage(driver);
//        loanPurpose.selectRandomLoanPurpose();
//        ScreenshotUtil.takeScreenshot(driver, "Img2.jpg");
//    }
////    //Enter Loan Amount
//    @Test(priority = 6)
//    public void loanAmount() throws IOException {
////    	 driver.get("https://demorf2.ramfincorp.co.in/enter-loan-amount");
//         LoanAmountPage loanPage = new LoanAmountPage(driver);
//         loanPage.enterAmount("10000");
//         ScreenshotUtil.takeScreenshot(driver, "Img3.jpg");
//         loanPage.clickNext();
//    }
////    //Gender Options------------PersonalInformations
//    @Test(priority = 7)
//    public void personalDetails() throws InterruptedException {
////    	  driver.get("https://demorf2.ramfincorp.co.in/gender");
//          PersonalInfoPage personalInfo = new PersonalInfoPage(driver);
//          personalInfo.selectRandomGender();
////    		driver.get("https://demorf2.ramfincorp.co.in/marital-status");
//    	personalInfo.selectRandomMaritalStatus();
////    		driver.get("https:// demorf2.ramfincorp.co.in/highest-education");
//        personalInfo.selectRandomEducation();
////      	driver.get("https://demorf2.ramfincorp.co.in/employment-details");
//        personalInfo.selectEmploymentStatus("salaried");
//    	
////    		driver.get("https://demorf2.ramfincorp.co.in/payment-mode");
//        personalInfo.selectPaymentMode();
////    		driver.get("https://demorf2.ramfincorp.co.in/company-name");
//        personalInfo.enterCompanyName("Ramfincorp");
//        personalInfo.clickNext();
//    }
//
//    @Test(priority = 8)
//    public void industryDetails() {
//    	
////    	driver.get("https://demorf2.ramfincorp.co.in/industry");
//        IndustryPage industryPage = new IndustryPage(driver);
//        industryPage.SelectrandomIndustry();
////    	driver.get("https://demorf2.ramfincorp.co.in/your-designation");
//        industryPage.selectRandomDesignation();
//    }
//    @Test(priority = 9)
//    public void enterMonthlyIncome() {
////    	driver.get("https://demorf2.ramfincorp.co.in/monthly-income");
//        ProfessionalPage monthIncome = new ProfessionalPage(driver);
//        monthIncome.MonthlyIncomePage("15000");
//        monthIncome.clickNext();
//    }
//    
////    //Employment (Work Experience)
//    @Test (priority = 10)
//    public void selectSalaryDate() throws InterruptedException {
//    	
//        EmploymentDetails professional = new EmploymentDetails(driver);
//        professional.WorkExperience();
//        //salary page
//        professional.selectRandomSalaryDate();
//    } 
//    //Residential details
//    @Test (priority = 11)
//    public void residentialDetails() throws InterruptedException {
//    	
//    	ResidentialDetails residence = new ResidentialDetails(driver);
//    	residence.selectResidence();
//    	residence.clickNext();
//    	residence.nextBtn();
//    	
//    }
    //Bank Verification
//    @Test(priority = 12)
//    public void clickBankVerify() {
//    	
//    	BankSelectionPage bankSelection = new BankSelectionPage(driver);
//    	bankSelection.clickverifyBankDetails();
//    
// // Bank Search - Select Yes Bank using search
////    	driver.get("https://demorf-sandeepa.ramfincorp.co.in/finbox-create");
//        bankSelection.searchAndSelectBank("State Bank of India");
//        bankSelection.clickOnSBIBank();
//        
//        //Fetch using phone number
//        ConnectBankPage connectBank = new ConnectBankPage(driver);
//        connectBank.clickFetchUsingPhoneNumber();
//        
//        AggregatorPage accountAggregator = new AggregatorPage(driver);
//        accountAggregator.enterPhoneNumber("9782967441");
//        accountAggregator.clickGetOtp();
//        accountAggregator.waitForVerifyButton(); // waits for Verify button to become clickable
//        accountAggregator.clickVerifyBtn();
//        accountAggregator.waitForUseAccount();    // waits for Use Account button to become clickable
//        accountAggregator.useAccount();
//        accountAggregator.waitForAgreeButton();   // waits for I Agree button to become clickable
//        accountAggregator.clickOnAgreeBtn();
//        
//    }  
    //Bank Verification
//    @Test(priority = 13)
//    public void verifyBankDetails() throws InterruptedException {
//
//    	VerifyBankDetailsPage verify = new VerifyBankDetailsPage(driver);
//    	verify.clickOnVerifyBankDetails();
//    	verify.clickOneTimeVerification();
//    	System.out.println("bankverify, screenshot saved.");
//    	verify.clickOnContinue();
//    	verify.clickOnContinue();
//    }
    @Test(priority = 14)
    public void bankDetails() {
    	BankDetails bankDetails = new BankDetails(driver);
    	bankDetails.holderNameInput("Ajay Kumar Meena");
    	bankDetails.accountNumberInput("61189591231");
    	bankDetails.re_enterAccountNumInput("61189591231");
    	bankDetails.ifscInput("SBIN0031039");
////    	bankDetails.bankNameField("SBI Bank");
    	bankDetails.clickNext();
    	bankDetails.clickYES();
    	bankDetails.continueBtn();
    	bankDetails.continueBtn();
//    	driver.get("https://demorf2.ramfincorp.co.in/bank-list");
    	bankDetails.continueButon();
    	bankDetails.continueButon();
    	
    }
    @Test (priority = 15)
    public void emanadatePage() {
    	//RK Bansal Finance
    	EmanadatePage eManadate = new EmanadatePage(driver);
    	
    	eManadate.enterContactNumber("9782967441");
    	eManadate.clickAuthenticate();
    	eManadate.clickUsingAadhaar();
    	eManadate.clickAuthenticate();
    }
    
//    @AfterClass
//    public void tearup() throws InterruptedException {
//    	Thread.sleep(10000);
//    	driver.close();
//    }
}
