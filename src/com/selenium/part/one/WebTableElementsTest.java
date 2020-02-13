package com.selenium.part.one;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.Constants;

public class WebTableElementsTest {

	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		
		   System.setProperty(Constants.cromeDriver,Constants.cromeDriverFilePath);
		   driver= new ChromeDriver();
	        driver.get(Constants.urlGuru99WebTable);         
	        //No.of Columns
	        List  col = driver.findElements(By.xpath(Constants.guruXpathTC));
	        System.out.println("No of cols are : " +col.size()); 
	        //No.of rows 
	        List  rows = driver.findElements(By.xpath(Constants.guruXpathTR)); 
	        System.out.println("No of rows are : " + rows.size());
	        driver.close();

	}

}
