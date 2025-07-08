package com.readExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	@Test
	public void readExcel() throws Exception {
		
		String excelFilePath="C:\\Users\\jyotikumar\\eclipse-workspace\\PracticeTestNG\\datafiles\\country.xlsx";
		String fileNameString="country";
		String sheetName="test";
		
		FileInputStream inputstream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);	
	
		int rows = sheet.getLastRowNum();
		System.out.println("Total Rows: " +rows);
		String data = sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data);
		
		for(int r=0;r<=rows; r++) {
			XSSFRow row = sheet.getRow(r);//0
			for(int j=0; j<row.getLastCellNum(); j++) {
				String data1 = sheet.getRow(r).getCell(j).getStringCellValue();
				System.out.println(data1+ " ");
//				XSSFCell cell = row.getCell(c);
//				switch(cell.getCellType()) {
//				case STRING: System.out.println(cell.getStringCellValue()); break;
//				case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
//				case BOOLEAN: System.out.println(cell.getBooleanCellValue());break;
//				}
//			}
		}
		System.out.println();
		}
		workbook.close();
	}
}

//int cols = sheet.getRow(1).getLastCellNum();
