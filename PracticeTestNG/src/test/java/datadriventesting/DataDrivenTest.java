package datadriventesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	}
	@Test (dataProvider = "LoginData")
	public void loginTest(String user, String pwd, String exp) {
		System.out.println(user + pwd + exp);
		
	}
	@DataProvider (name="LoginData")
	public String [] [] getData() {
		String loginData[][]= {
				{"jyotiKumari",	"12345","valid"},
				{"jyotiKumar",	"2345", "invalid"},
				{"jyotiKuamri",	"123", "invalid"}
		};
		return loginData;
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
	

}
