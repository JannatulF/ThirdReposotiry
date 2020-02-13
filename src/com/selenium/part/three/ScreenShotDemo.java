package com.selenium.part.three;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.Constants;

/*
 * Screenshots are desirable for bug analysis. Selenium can automatically take screenshots during execution.
 *  You need to type cast WebDriver instance to TakesScreenshot.
 */
public class ScreenShotDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		WebDriver driver = new ChromeDriver();
		driver.get(Constants.urlJquary);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("C:\\Users\\703177838.INDCORP\\Desktop\\Screen.png"));
		
		System.out.println("the Screenshot is taken");
	}

}
