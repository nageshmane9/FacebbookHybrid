package com.facebook.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelData 
{
	
	public static XSSFSheet data() throws Exception
	{
		//Specify the location  of the file
		File sourcefile = new File(".\\src\\test\\resources\\Exel\\CajitonSirExelData.xlsx");
		
		//Create fis object and pass the source into the FileInputStream
		FileInputStream fis= new FileInputStream(sourcefile);
		
		//Load the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		// Load Sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//Get the name of the loaded sheet
		System.out.println("Sheet Name-  "+sheet.getSheetName());
		
		// Get the total number of rows present in the table
		System.out.println("Total number of rows- "+sheet.getPhysicalNumberOfRows());
		
		// To get the first row number present in the table
		System.out.println("First row Number - "+sheet.getFirstRowNum());
		
		// To get the Last row number present in the table
		System.out.println("Last row number-  "+sheet.getLastRowNum());
		
		
		return sheet;
		
	}

}
