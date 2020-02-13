package com.selenium.part.one;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.constants.Constants;

public class DriverMethodImplement {

	public static WebDriver driver;
	public static WebElement linktextTestFrameWork,searchField,searchButton,subscribeXpath;
	

	public static void main(String[] args) throws InterruptedException {
		
     chromeDriver();
	}


	private static void  chromeDriver() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty(Constants.cromeDriver,Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		//get   manage, refresh  methods implemented
		driver.manage().window().maximize();
		driver.get(Constants.urlLocators);
		driver.navigate().refresh();
		
		linktextTestFrameWork=driver.findElement(By.id(Constants.idTextFramework));
		//getText method Implemented
		System.out.println(linktextTestFrameWork.getText());
		
		searchField=driver.findElement(By.xpath(Constants.searchFieldsXpath));
		//send keys methods is implemented
		searchField.sendKeys("Web driver Mathods");
	//	searchField.sendKeys(Keys.ENTER);
		
		//clear and get text method implemented
		if(searchField.getText().equalsIgnoreCase("Web driver Mathods"))
		searchField.clear();
		
		searchButton=driver.findElement(By.id(Constants.searchButton));
		//click  and isDisplayed method implemented
		
		if(searchField.isDisplayed()) {
			searchButton.click();
		}
		
	//	subscribeXpath=driver.findElement(By.xpath(Constants.subscribeXpath));
		
		// new getCurrent Url is taking
		System.out.println(driver.getCurrentUrl());
		//get title is taking
		System.out.println(driver.getTitle());
		//get page source is taking
		System.out.println(driver.getPageSource());
		
		if(driver.getTitle().contains("Web driver")) {
			Thread.sleep(1000);
			//navigate method implemented
			driver.navigate().back();
			System.out.println(driver.getWindowHandle());
			subscribeXpath=driver.findElement(By.xpath(Constants.subscribeXpath));
			if(subscribeXpath.isEnabled()) {
				
				System.out.println(subscribeXpath.getTagName()+","+subscribeXpath.getSize()+" ,"+subscribeXpath.getLocation());
				
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement element = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.subscribeXpath)));
				//element.click();
				System.out.println(element.getText());
		     
				Actions actions = new Actions(driver);
				actions.moveToElement(element).click().build().perform();
				
				//subscribeXpath.click();
			}
			
		}
	
		
		
	}

}
