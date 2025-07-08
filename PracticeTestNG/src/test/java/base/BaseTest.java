package base;

import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ExtentManager;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void initReport() {
        extent = ExtentManager.getInstance();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
