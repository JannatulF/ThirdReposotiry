package com.selenium.part.one;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.constants.Constants;

public class BrowserTestSelenium {
	
   public static String browserName=Constants.cromeDriver;
   public static  WebDriver driver;
	
	public static void main(String[] args) {
		
		if(browserName.contains("chrome")) {
			chromeDriver();
		}else if(browserName.contains("ie")) {
			internetExploberDriver();
		}else if(browserName.contains("gecho")) {
			try {
				gechoDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("No broser found");
		}

	}

	private static void gechoDriver() {
		
		System.setProperty(Constants.gechoDriver,Constants.gechoDriverFilePath);
		 driver = new FirefoxDriver();
		driver.get(Constants.urlGoogle);
		
	}

	private static void chromeDriver() {
		
		System.setProperty(Constants.cromeDriver,Constants.cromeDriverFilePath);
		 driver = new ChromeDriver();
		driver.get(Constants.urlGoogle);
		
	}

	private static void internetExploberDriver() {
		
		System.setProperty(Constants.ieDriver,Constants.ieDriverFilePath);
	    driver = new InternetExplorerDriver();
		driver.get(Constants.urlGoogle);
	

	}


}
