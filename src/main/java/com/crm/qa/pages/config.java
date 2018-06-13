package com.crm.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class config {
	HSSFWorkbook hwb; 
	HSSFSheet sheet1;
	 public config(String excelPath) throws IOException {
		
		    File src = new File("/Users/sreejon/Desktop/EXDATA.xls");
	        FileInputStream fis = new FileInputStream(src);
	        hwb= new HSSFWorkbook (fis);
	        
	}
	 public String getData(int sheetNumber,int row, int column) {
		 sheet1 = hwb.getSheetAt(sheetNumber);
		 String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		 return data;
	 }
	 
	 // to return number of rows 
	 
	 public int getRowCount(int sheetIndex) {
		int row1 = hwb.getSheetAt(sheetIndex).getLastRowNum();
		row1 = row1+1;
		return row1;  
	 }

}
