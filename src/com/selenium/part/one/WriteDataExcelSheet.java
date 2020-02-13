package com.selenium.part.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.constants.Constants;

public class WriteDataExcelSheet {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 
          writeFileUsingPoi();
	}

	private static void writeFileUsingPoi() throws IOException {
		// TODO Auto-generated method stub
		
		//create blank workbook
		  XSSFWorkbook workbook = new XSSFWorkbook(); 
		  //Create a blank sheet
		  XSSFSheet sheet = workbook.createSheet("UserDetails");
		 
		  ArrayList<Object[]> data=new ArrayList<Object[]>();
		  data.add(new String[]{"Email Id","User Name","Password"});
		  data.add(new Object[]{"abc@gmail.com","abc",1234});
		  data.add(new Object[]{"xyz@gmail.com","xyz",5678});
		  data.add(new Object[]{"pqr@gmail.com","pqr",4321});
		  data.add(new Object[]{"rst@gmail.com","rst",8765});
		 
	
		  //Iterate over data and write to sheet
		  int rownum = 0;
		  for (Object[] userInfos : data)
		  {
		   Row row = sheet.createRow(++rownum);
		 
		   int cellnum = 0;
		   for (Object obj : userInfos)
		   {
		    Cell cell = row.createCell(++cellnum);
		    if(obj instanceof String)
		     cell.setCellValue((String)obj);
		    else if(obj instanceof Double)
		     cell.setCellValue((Double)obj);
		    else if(obj instanceof Integer)
		     cell.setCellValue((Integer)obj);
		   }
		  }
		  try
		  {
		   //Write the workbook in file system
		   FileOutputStream out = new FileOutputStream(new File(Constants.path+Constants.slash+"userdetails.xlsx"));
		   workbook.write(out);
		   out.close();
		   System.out.println("CountriesDetails.xlsx has been created successfully");
		  } 
		  catch (Exception e) 
		  {
		   e.printStackTrace();
		  }
		  finally {
		   workbook.close();
		  }
		 }
		 
}

