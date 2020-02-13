package com.selenium.part.one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.selenium.constants.Constants;




public class SeleniumLocatorsOfObject {
	
	public static WebDriver driver;
	public static String expectedTitle="Github";

	public static void main(String[] args) {
	
		chromeDriver();
		
	}

	private static void chromeDriver() {
		
		System.setProperty(Constants.cromeDriver,Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		driver.get(Constants.urlGitHub);
		driver.findElement(By.id("login_field")).sendKeys("my name");
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.name("commit")).click();
		//driver.findElement(By.linkText("Forgot password?")).click();
		//driver.findElement(By.xpath("//*[@id=\"login\"]/p/a")).click();
		
		Assert.assertEquals(true, driver.findElement(By.name("commit")).isDisplayed());
		
		
		
		
	}
}
