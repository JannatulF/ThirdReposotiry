package com.selenium.part.two;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.Constants;

public class DialogTest {
	public static WebDriver driver;
	public static WebElement createNewUser,closeButton;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(Constants.urlJQDialog);

		driver.switchTo().frame(0);
		System.out.println("********We are switch to the iframe*******");

		createNewUser=driver.findElement(By.id("create-user"));
		createNewUser.click();
		
		getDialog();
	}
	private static void getDialog() {
		// TODO Auto-generated method stub
	
		//driver.switchTo().alert();
	//	driver.switchTo().activeElement();
		closeButton=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button[1]"));
		closeButton.click();
	}

}
