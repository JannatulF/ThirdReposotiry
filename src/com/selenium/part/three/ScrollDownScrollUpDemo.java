package com.selenium.part.three;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.Constants;

public class ScrollDownScrollUpDemo {
	
	static WebElement elemantTab,elemantDraggable;
	static WebDriver driver;
	static JavascriptExecutor js ;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		 driver = new ChromeDriver();
         js = (JavascriptExecutor) driver;
        // Launch the application		
         driver.manage().window().maximize();
        driver.get(Constants.urlJquary);

        getScrollUpDown();
       
	}

	private static void getScrollUpDown() throws InterruptedException {
        elemantTab = driver.findElement(By.linkText("Tabs"));
       //This will scroll the page Horizontally till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", elemantTab);
        System.out.println("page is scrolled  down now");
       
        if(elemantTab.getText().equalsIgnoreCase("Tabs")) {
        	 Thread.sleep(5000);
        	 elemantDraggable = driver.findElement(By.linkText("Draggable"));
        	 js.executeScript("arguments[0].scrollIntoView();", elemantDraggable);
        	 System.out.println("page is scrolled  up now");
        	
        }
       
	}

}
