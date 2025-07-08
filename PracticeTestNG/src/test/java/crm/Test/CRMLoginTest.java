package crm.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import crm.Test.page.CRMlogin;
import crm.Test.page.SearchPage;
import excelOperation.ExcelReader;
//import excelOperation.ExcelWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Screenshots;

public class CRMLoginTest {
	
	WebDriver driver;
	CRMlogin crmLogin;
	
	//Excel file and path
	String filePath = ".\\datafiles\\loginData.xlsx";
	String sheetName = "sheet1";
	
	
	@BeforeClass
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://crmstaging-sandeepa.ramfincorp.co.in/");
	        crmLogin = new CRMlogin(driver);
	        
	    }
	@DataProvider (name = "loginData")
	public Object[][] getLoginData() throws Exception {
        return ExcelReader.readLoginData(filePath, sheetName);
    }
	
	@Test (dataProvider = "loginData")
	public void loginToCRM(String username, String password, int rowIndex) {
		
		try {
		crmLogin.enterUserName(username);
		System.out.println(driver.getTitle());
		crmLogin.enterPassword(password);
		crmLogin.clickSignIn();
		Thread.sleep(5000);
		
		//Get Otp
		MySQLConnectionCrmDemo mydb = new MySQLConnectionCrmDemo();
	    String otp = mydb.getOtpFromDB("jyotiKumari");
	    crmLogin.enterOtp(otp);
	    crmLogin.clickVerify();
	    Thread.sleep(5000);
	    Screenshots.takeScreenshot(driver, "TC_Demorf2_013.png");
	    SearchPage searchPage = new SearchPage(driver);
	    searchPage.enterSearch("9782967441");
	    Thread.sleep(5000);
	    searchPage.selectFilter();
		Thread.sleep(10000);
	    Screenshots.takeScreenshot(driver, "TC_Demorf2_014.png");
	
		 } catch (Exception e) {
	            System.out.println("Login failed for: " + username + " → " + e.getMessage());
	        }
	    }
	
	@AfterClass
	public void afterclass() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}

}

