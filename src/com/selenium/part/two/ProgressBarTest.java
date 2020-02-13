package com.selenium.part.two;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.constants.Constants;

public class ProgressBarTest {

	public static WebDriver driver;
	public static WebElement customLevel, dialogDownload, startDownload, closeDialogButton;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(Constants.urlProgressBar);

		customLevel = driver.findElement(By.linkText("Custom Label"));
		customLevel.click();

		Thread.sleep(3000);
		driver.switchTo().frame(0);
		System.out.println("********We are switch to the iframe*******");
		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("progress-label")));


		boolean status = element.isDisplayed();

		// customlevelComplete=driver.findElement(By.className("progress-label"));
		System.out.println(element.getText().toString());

		if (status) {
			driver.switchTo().defaultContent();
			dialogDownload = driver.findElement(By.linkText("Download Dialog"));
			dialogDownload.click();
			
             if(dialogDownload.isEnabled()) {
			  driver.switchTo().frame(0);
			  Thread.sleep(2000);
			  startDownload=driver.findElement(By.id("downloadButton"));
			  startDownload.click();
		}

	}

	}}
