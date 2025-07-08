//package excelOperation;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader{
//	
//	static Workbook workbook;
//	static Sheet sheet;
//	
//	public static void loadExcel(String filePath, String sheetName) throws Exception {
//		
//		FileInputStream file = new FileInputStream(filePath);
//		workbook = new XSSFWorkbook(file);
//		workbook = new XSSFWorkbook(file);
//		sheet = workbook.getSheet(sheetName);
//		
//	}
//	
//	public static String getCellData(int row, int col) {
//		Cell cell = sheet.getRow(row).getCell(col);
//		if(cell.getCellType()==CellType.STRING) {
//			return cell.getStringCellValue();
//		}
//		else if (cell.getCellType()==CellType.NUMERIC) {
//			return String.valueOf((int) cell.getNumericCellValue());
//		}
//		return ""; 
//	}
//	
//	public static int getRowCount() {
//		return sheet.getPhysicalNumberOfRows();
//	}
//	public static void closeExcel() throws IOException {
//		workbook.close();
//	}
//	
//}
//








package excelOperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReader {

	public static Object[][] readLoginData(String filePath, String sheetName) throws IOException {
	    FileInputStream fis = new FileInputStream(filePath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet(sheetName);

	    int rowCount = sheet.getPhysicalNumberOfRows();

	    Object[][] data = new Object[rowCount - 1][3]; // username, password, rowIndex

	    for (int i = 1; i < rowCount; i++) {
	        Row row = sheet.getRow(i);

	        String username = row.getCell(0).getStringCellValue();

	        Cell passwordCell = row.getCell(1);
	        String password = "";
	        if (passwordCell.getCellType() == CellType.NUMERIC) {
	            password = String.valueOf((long) passwordCell.getNumericCellValue());
	        } else {
	            password = passwordCell.getStringCellValue();
	        }

	        data[i - 1][0] = username;
	        data[i - 1][1] = password;
	        data[i - 1][2] = i; // rowIndex
	    }

	    workbook.close();
	    fis.close();
	    return data;
	}

}

