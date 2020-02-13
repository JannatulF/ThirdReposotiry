package com.selenium.part.two;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.Constants;

public class DatePickerTest {
	public static WebDriver driver;
	public static WebElement datepicker, selectedMonth,nextMonth;
	public static List<WebElement> dates;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(Constants.urlJQDatePicker);

		driver.switchTo().frame(0);
		System.out.println("********We are switch to the iframe*******");

		getDatePicker();

	}

	private static void getDatePicker() throws InterruptedException {
		datepicker = driver.findElement(By.id("datepicker"));
		datepicker.click();

		/*
		selectedMonth = driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > span.ui-datepicker-month"));
		
		while(!selectedMonth.getText().contains("May"))
		{
			nextMonth=driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-next.ui-corner-all > span"));
			nextMonth.click();
		}

		*/
		dates = driver.findElements(By.className("ui-state-default"));
		// Grab common attribute//Put into list and iterate
		int count =dates.size();
		System.out.println(String.valueOf(count));

		for (int i = 0; i < count; i++) {
			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("14")) {
				dates.get(i).click();
				break;
			}

		}



	}

}
