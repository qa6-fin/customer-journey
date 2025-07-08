package crm.Test.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private By searchInput = By.xpath("//*[@id=\"rs-:r0:\"]"); 
    By searchDropdown = By.xpath("//*[@id=\"root\"]/section[1]/main/div/header/div[1]/form/div/div/div[3]/div/span"); 

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearch(String number) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(number);
    }

    public void selectFilter() {
        driver.findElement(searchDropdown).click();
    }

}
