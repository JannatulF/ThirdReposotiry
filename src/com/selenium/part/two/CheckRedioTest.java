package com.selenium.part.two;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.selenium.constants.Constants;

public class CheckRedioTest {
	public static WebDriver driver;
	public static WebElement checkBoxHotel, redioEliment,checkBoxBedType,mTab;
	public static List<WebElement> redioElements;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		    System.setProperty(Constants.cromeDriver,Constants.cromeDriverFilePath);
		    driver= new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
	        driver.get(Constants.urlJQCheckOrRedio);  
	        
	   
	       
	        redioElements=driver.findElements(By.tagName("fieldset"));
	        String elementSRCAttribute =
	        		driver.findElement(By.xpath(" //*[@id=\"content\"]/iframe")).getAttribute("src");
	        System.out.println(elementSRCAttribute);
	        
	        driver.switchTo().frame(0);
	        System.out.println("********We are switch to the iframe*******");
	        
	      getRedioCheckBox();
	    //    getTab();
	     

	}

	private static void getTab() {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		//driver.close();
		//driver.switchTo().window(tabs2.get(0));
		
	}

	private static void getRedioCheckBox() {
		    redioEliment=  driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[2]"));
	        redioEliment.click();
	        System.out.println(redioEliment.getText());
	        checkBoxHotel=  driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[1]"));
	        checkBoxHotel.click();
	        
	        checkBoxBedType=  driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[3]"));
	        checkBoxBedType.click();
		
	}

}
