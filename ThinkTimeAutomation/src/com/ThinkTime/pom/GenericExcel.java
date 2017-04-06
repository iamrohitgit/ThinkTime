package com.ThinkTime.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GenericExcel 
{
		public List<String> getExcelData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException
		{
			List<String> datas= new LinkedList<>();
				 String excelFilePath = "C:/Users/rprakash/Documents/ThinkTimeAutomation/ThinkTimeAutomation/excelFiles/ContentsFile.xlsx";
			        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			         
			        Workbook workbook = new XSSFWorkbook(inputStream);
			        Sheet firstSheet = workbook.getSheet(sheetName);
			        Iterator<Row> iterator = firstSheet.iterator();
			         
			        while (iterator.hasNext()) {
			            Row nextRow = iterator.next();
			            Iterator<Cell> cellIterator = nextRow.cellIterator();
			             
			            while (cellIterator.hasNext()) {
			                Cell cell = cellIterator.next();
			                cell.setCellType(Cell.CELL_TYPE_STRING);
			                datas.add(cell.toString());
			            }
			            
			        }
			         
			        workbook.close();
			        inputStream.close();
			        return datas;
				
		}
		
		public int getRowCount(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
		{
			int rowCount=0;
			try 
			{
				FileInputStream fis = new FileInputStream("C:/Users/rprakash/Documents/ThinkTimeAutomation/ThinkTimeAutomation/excelFiles/ContentsFile.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				Sheet s = wb.getSheet(sheetName);		
				rowCount = s.getLastRowNum();
			
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (InvalidFormatException e) 
			{
				e.printStackTrace();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			return rowCount;
		}		
		
		
		public void writeToExcel(String sheetName, int rowNum, int cellNum, String data) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
		{
			try 
			{
				FileInputStream fis = new FileInputStream("C:/Users/rprakash/Documents/ThinkTimeAutomation/ThinkTimeAutomation/excelFiles/ContentsFile.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				Sheet s = wb.getSheet(sheetName);
				Row r = s.createRow(rowNum);
				Cell c = r.createCell(cellNum);
				c.setCellValue(data);
				FileOutputStream fos = new FileOutputStream("C:/Users/rprakash/Documents/ThinkTimeAutomation/ThinkTimeAutomation/excelFiles/ContentsFile.xlsx");
				wb.write(fos);
				
			
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (InvalidFormatException e) 
			{
				e.printStackTrace();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}	
}
