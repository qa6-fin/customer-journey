package crm.Test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	@Test
	public void TestGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Youtube", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();		
	}

		@Test
		public void TestYoutube() throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.youtube.com/");
	driver.findElement(By.name("search_query")).sendKeys("Selenium", Keys.ENTER);
	System.out.println(driver.getTitle());
	Thread.sleep(5000);
	driver.quit();
		}
		
		@Test
		public void Testapp() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			driver.findElement(By.name("q")).sendKeys("Youtube", Keys.ENTER);
			System.out.println(driver.getTitle());
			Thread.sleep(5000);
			driver.quit();	
		
		}
}