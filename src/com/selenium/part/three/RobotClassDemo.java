package com.selenium.part.three;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.selenium.constants.Constants;

/*Selenium Webdriver cannot handle these OS pop-ups/applications.
In Java version 1.3 Robot Class was introduced. Robot Class can handle OS pop-ups/applications.
there is a need to control keyboard or mouse to interact with OS windows like Download pop-up, Alerts, Print Pop-ups, etc. 
or native Operation System applications like Notepad, Skype, Calculator, etc.
*/

public class RobotClassDemo {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.edureka.co");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Courses")).click();
		Robot robot = new Robot();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("a");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("b");
		robot.keyPress(KeyEvent.VK_TAB);	
		Thread.sleep(4000);
		System.out.println("c");
		robot.mouseMove(30,100);
		Thread.sleep(4000);
		System.out.println("d");
		driver.quit();
		 
	}

}
