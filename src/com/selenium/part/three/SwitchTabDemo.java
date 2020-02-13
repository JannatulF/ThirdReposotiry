package com.selenium.part.three;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.constants.Constants;

public class SwitchTabDemo {

	static WebElement mS,searchButton;
	static WebDriver driver;
	public static void main(String[] args) {
		
		getSwitch();

	}
	private static void getSwitch() {
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
	     driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.urlJquary);
		
		String oldTab = driver.getWindowHandle();

		//For opening window in New Tab
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(By.linkText("Download")).sendKeys(selectLinkOpeninNewTab);

		// Perform Ctrl + Tab to focus on new Tab window
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();

		// Switch driver control to focused tab window
		driver.switchTo().window(oldTab);

		mS=driver.findElement(By.name("s"));
		mS.sendKeys("tabs");
		
		searchButton=driver.findElement(By.xpath("//*[@id=\"main\"]/form/button"));
		searchButton.click();
		
	}

}
