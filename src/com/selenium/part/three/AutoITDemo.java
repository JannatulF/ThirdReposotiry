package com.selenium.part.three;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.constants.Constants;

/*Selenium is an open source tool that is designed to automate web-based applications on different browsers
 *  but to handle window GUI and non HTML popups in application.
 *   AutoIT is required as these window based activity are not handled by Selenium.
 * */

public class AutoITDemo {

	static WebDriver driver;
	static WebElement mDownloadElement, mUploadElement;
	static JavascriptExecutor js;

	public static void main(String[] args) throws IOException {
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");

		getDownload();
		getUpload();

	}

	private static void getUpload() throws IOException {
		// TODO Auto-generated method stub
		mUploadElement = driver.findElement(By.xpath("//*[@id=\"uploadfile\"]"));

		Runtime.getRuntime().exec("C:\\Users\\703177838.INDCORP\\Documents\\UploadFile.exe");
		Actions actions = new Actions(driver);
		actions.moveToElement(mUploadElement).click().build().perform();

		// pass the path of the file to be uploaded using Sendkeys method
		// Runtime.getRuntime().exec("C:\\Users\\703177838.INDCORP\\Documents\\UploadFile.exe");
		// 'close' method is used to close the browser window
	}

	private static void getDownload() throws IOException {
		// TODO Auto-generated method stub
		mDownloadElement = driver
				.findElement(By.xpath("//*[@id='post-body-5864649494765988891']/div[1]/form/div[1]/a[1]"));
		mDownloadElement.click();
		// To call the AutoIt script
		Runtime.getRuntime().exec("C:\\Users\\703177838.INDCORP\\Documents\\DownloadFile.exe");

	}

}
