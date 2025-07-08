package excelOperation;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.*;

	public class ExcelWriter {

	    public static void main(String[] args ) throws Exception {
	    	XSSFWorkbook workbook = new XSSFWorkbook();
	    	XSSFSheet sheet = workbook.createSheet("Emp Info");
	    	
	    	Object empdata[][] = { {"EmpID","Name","Job"},
	    			{101,"David","Engineer"},
	    			{102,"Smith","Manager"},
	    			{103,"Scott","DataAnalyst"}
	    	};
	    	
	    	//Using for loop
	    int rows = empdata.length;
	    int cols = empdata[0].length;
	    
	    System.out.println(rows); //4
	    System.out.println(cols); //3
	    
	    for(int r = 0; r< rows; r++) //0
	    	{
	    	
	    	XSSFRow row = sheet.createRow(r);
	    	
	    	for(int c=0; c<cols; c++) {
	    		
	    		XSSFCell cell = row.createCell(c);//0
	    		Object value = empdata[r][c];
	    		
	    		if(value instanceof String)
	    			cell.setCellValue((String)value);
	    		if(value instanceof Integer)
	    			cell.setCellValue((Integer)value);
	    		if(value instanceof Boolean)
	    			cell.setCellValue((Boolean)value);
	 
	    	}
	    }
	    	
	    //using for...each loop	
	    	
	    int rowCount = 0;
	    for(Object emp[]:empdata) 
	    {
	    	XSSFRow row = sheet.createRow(rowCount++);
	    			int columnCount = 0;
	    	for(Object value:emp)
	    	{
	    		XSSFCell cell = row.createCell(columnCount++);
	    		
	    		if(value instanceof String)
	    			cell.setCellValue((String)value);
	    		if(value instanceof Integer)
	    			cell.setCellValue((Integer)value);
	    		if(value instanceof Boolean)
	    			cell.setCellValue((Boolean)value);
	    	}
	    }   	
	    	
	    String filePath = ".\\datafiles\\country.xlsx";
	    FileOutputStream outstream = new FileOutputStream(filePath);
	    workbook.write(outstream);
	    
	    outstream.close();
	    System.out.println("country.xls file written successfully..");
	}
}