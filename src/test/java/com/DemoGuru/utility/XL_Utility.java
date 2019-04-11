package com.DemoGuru.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL_Utility {

	public static  XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	public static int getrowcount(String excelfile,String sheetname) throws Exception
	{
		fis = new FileInputStream(excelfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetname);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	
	public static int getColcount(String excelfile,String sheetname,int rowNum) throws Exception
	{
		fis = new FileInputStream(excelfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetname);
		Row row = ws.getRow(rowNum);
		int colCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return colCount;
	}
	
	
	public static String getCellData(String excelfile,String sheetname,int rowNum,int cellnum) throws Exception
	{
		fis = new FileInputStream(excelfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetname);
		Row row = ws.getRow(rowNum);
		Cell cell =row.getCell(cellnum);
		String Data = null;
		try
		{
			DataFormatter format = new DataFormatter();
			String cellData = format.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			Data = " ";
		}
		
		wb.close();
		fis.close();
		
		return Data;
	}
	
	
	public static void setCellData(String excelfile,String sheetname,int rowNum,int col, String data2add) throws Exception
	{
		fis = new FileInputStream(excelfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rowNum);
		cell = row.createCell(col);
		cell.setCellValue(data2add);
		fos = new FileOutputStream(excelfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	
	}
	

}
