package com.readExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelLibrary() throws Exception {
	String excelFilePath="C:\\Users\\jyotikumar\\eclipse-workspace\\PracticeTestNG\\datafiles\\country.xlsx";
	FileInputStream inputstream = new FileInputStream(excelFilePath);
	XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
	
	}
	public String readData(String sheetName, int row, int col) {
		sheet = workbook.getSheet(sheetName);
		String data =sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
