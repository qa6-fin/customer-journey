package crm.Test.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class RF2LoginPage {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demorf-sandeepa.ramfincorp.co.in/");
    }

    @Test(priority = 1)
    public void validMobileLoginTest() throws InterruptedException {
        driver.findElement(By.name("mobileNumber")).sendKeys("9782967441");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[1]/button")).click();

        System.out.println("Enter the correct OTP manually within 10 seconds...");
        Thread.sleep(10000); // Wait for manual OTP entry

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div/div[2]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/button/span")).click();
        System.out.println("clicked getcash..");

    }

    @Test(priority = 2)
    public void invalidMobileNumberTest() {
        driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("12345"); // invalid number
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        // Check error message
        // Update the XPath below if your application displays error messages
        // For now, we will just print something
        System.out.println("Expected: Error message for invalid mobile number");
    }

    @Test(priority = 3)
    public void blankMobileNumberTest() {
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        System.out.println("Expected: Error message for blank mobile number");
    }

    @Test(priority = 4)
    public void wrongOTPTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("9786745342");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        Thread.sleep(5000); // Simulate wait for OTP screen

        driver.findElement(By.xpath("//input[@placeholder='Enter Your OTP']")).sendKeys("9999"); // wrong OTP
        driver.findElement(By.xpath("//button[text()='Verify Now!']")).click();

        System.out.println("Expected: Error message for wrong OTP");
    }

    @Test(priority = 5)
    public void blankOTPTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("9786745342");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        Thread.sleep(5000); // Simulate wait for OTP screen

        driver.findElement(By.xpath("//button[text()='Verify Now!']")).click();

        System.out.println("Expected: Error message for blank OTP");
    }

  
}
