package com.selenium.part.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.constants.Constants;


/*
 *  data-driven testing,
 *  which allows you to automatically run a test case multiple times with different input and validation values.
 *  An additional advantage of using Excel is that you can easily outsource the test data administration to someone
 *  other than yourself,
 *  someone who might have better knowledge of the test cases that need to be run and the parameters required to execute them.
 */
public class ReadAndAppendTestData {

	static  String excelFilePath = Constants.path+Constants.slash+"blank.xlsx";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
      ReadDataByPOI();
      appendDataByPOI();
	}

	private static void appendDataByPOI() {
		
        
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
 
            Object[][] bookData = {
                    {"my name", "xyz", 11},
                    {"your name", "abc", 22},
                    {"his name", "pqr", 33},
                    {"her name", "rst", 44},
            };
 
            int rowCount = sheet.getLastRowNum();
 
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);
 
                int columnCount = 0;
                 
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                 
                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
 
            }
 
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }

	}

	private static void ReadDataByPOI() throws IOException {
		
		 
		  FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		 
		  Workbook workbook = new XSSFWorkbook(inputStream);
		  Sheet sheet = workbook.getSheetAt(0);
		 
		  
		  Iterator iterator = sheet.iterator();
		 
		  while (iterator.hasNext()) {
		   Row nextRow = (Row) iterator.next();
		   Iterator cellIterator = nextRow.cellIterator();
		 
		   while (cellIterator.hasNext()) {
		    Cell cell = (Cell) cellIterator.next();
		 
		    switch (cell.getCellType()) {
		    case STRING:
		     System.out.print(cell.getStringCellValue());
		     break;
		    case NUMERIC:
		     System.out.print(cell.getNumericCellValue());
		     break;
		    case BOOLEAN:
		     System.out.print(cell.getBooleanCellValue());
		     break;
		    }
		    System.out.print(" | ");
		   }
		   System.out.println();
		  }
		 
		  workbook.close();
		  inputStream.close();
		
	}

}
