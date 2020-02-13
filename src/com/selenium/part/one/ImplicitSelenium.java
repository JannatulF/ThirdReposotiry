package com.selenium.part.one;

import static org.junit.Assert.assertSame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.Constants;

public class ImplicitSelenium {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		chromeDriver();
	}

	private static void chromeDriver() {
		System.setProperty(Constants.cromeDriver,Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		// implemented implicit wait
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		String expecttedTitle = "Most Exhaustive WebDriver Locators Cheat Sheet";
		String actualTitle = "" ;
		driver.get(Constants.urlLocators);
		
		driver.manage().window().maximize() ;
		//get the actual value of the title
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		//compare the actual title with the expected title
		if (actualTitle.equalsIgnoreCase(expecttedTitle))
		{
		System.out.println( "Test Passed") ;
		}
		else {
		System.out.println( "Test Failed" );
		}
		//close browser
		
		
		driver.close();
		
		
		
		
	}

}
