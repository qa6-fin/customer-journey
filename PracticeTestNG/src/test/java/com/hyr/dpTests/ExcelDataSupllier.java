package com.hyr.dpTests;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataSupllier {
	public static void main(String[] args) throws Exception {
		File excelFile = new File("C:\\Users\\jyotikumar\\eclipse-workspace\\PracticeTestNG\\datafiles\\caldata.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
//		System.out.println(sheet.getPhysicalNumberOfRows());
//		System.out.println(sheet.getLastRowNum());
		int noOfRows= sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		
		for (int i = 1; i<noOfRows; i++) {
			for (int j= 0; j< noOfColumns; j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println();
		}
		
		
		workbook.close();
		fis.close(); 
	}

}
