package com.selenium.part.one;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.Constants;


public class SeleniumQaLocatorsOfObject {
	public static WebDriver driver;
	 public static WebElement userId,userPassword,userLogin;
	
	
	public static void main(String[] args) throws InterruptedException {
	
		//chromeDriver();
		System.setProperty(Constants.cromeDriver,Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		driver.get(Constants.urlPandG);
		
		userId= driver.findElement(By.id(Constants.userID));
		userId.sendKeys(Constants.givenInputUserOrPassword);
		userId.sendKeys(Keys.ENTER);
		
		userPassword=driver.findElement(By.name(Constants.userPassword));
		userPassword.sendKeys(Constants.givenInputUserOrPassword);
		driver.wait(2000);
		userLogin=driver.findElement(By.name(Constants.userLogin));
		userLogin.click();
	}


	
}
