package com.demoo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestFDCalc {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='wzrk-confirm']")).click();
		
		String filePath=System.getProperty("user.dir")+"\\datafiles\\caldata.xlsx";
		
		int rows=FdCalc.getRowCount(filePath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//1) read data from excel
			String pric=FdCalc.getCellData(filePath, "Sheet1",i,0);
			String rateofinterest=FdCalc.getCellData(filePath, "Sheet1",i,1);
			String per1=FdCalc.getCellData(filePath, "Sheet1",i,2);
			String per2=FdCalc.getCellData(filePath, "Sheet1",i,3);
			String fre=FdCalc.getCellData(filePath, "Sheet1",i,4);
			String exp_mvalue=FdCalc.getCellData(filePath, "Sheet1",i,5);
			
			//2) pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); //clicked on calculate
			
			
			//validation
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test passed");
				FdCalc.setCellData(filePath, "Sheet1",i,7,"Passed");
				FdCalc.fillGreenColor(filePath, "Sheet1",i,7);
			}
			else
			{
				System.out.println("Test failed");
				FdCalc.setCellData(filePath, "Sheet1",i,7,"Failed");
				FdCalc.fillRedColor(filePath, "Sheet1",i,7);
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); // clicked on clear button
			
		} //ending of for loop
		
		driver.quit();
	}

}