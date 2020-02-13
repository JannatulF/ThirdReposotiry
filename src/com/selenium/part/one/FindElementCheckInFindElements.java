package com.selenium.part.one;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.constants.Constants;

public class FindElementCheckInFindElements {

	public static WebDriver driver;
	WebElement contentElement;

	public static void main(String[] args) throws InterruptedException {
	
		chromeDriver();
		
	}

	private static void chromeDriver() throws InterruptedException {

		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.urlAutomationPractice);

		// Find the checkbox by Name

		List<WebElement> checkBox = driver.findElements(By.name("tool"));
		int iSize = checkBox.size();
		System.out.println(String.valueOf(iSize));
		
 
		for (int i = 0; i < iSize; i++) {
			String sValue = checkBox.get(i).getAttribute("value");
			System.out.println(sValue);
			if (sValue.equalsIgnoreCase("QTP")) {
				
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement element = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tool-0")));
				
				System.out.println(element.getText());
				//driver.findElement(By.id("tool-0")).click();
				Actions actions = new Actions(driver);
				actions.moveToElement(checkBox.get(i)).click().build().perform();
				break;
			}

		}}
	}

 
