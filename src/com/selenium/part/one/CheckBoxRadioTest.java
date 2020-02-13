package com.selenium.part.one;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.Constants;

public class CheckBoxRadioTest {

	public static WebDriver driver;
	public static WebElement radio1, radio2, option1,oCheckBox,rdBtn_Exp;
	 public static List<WebElement> rdBtn_Sex,chkBx_Profession;

	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
		System.setProperty(Constants.cromeDriver, Constants.cromeDriverFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	//	guruRedioCheckBoxTest();
		apRedioCheckTest();
		
	}

	private static void apRedioCheckTest() {
		// TODO Auto-generated method stub
		 
		 // Put an Implicit wait, 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 // Launch the URL
		 driver.get(Constants.urlAutomationPractice);
		 
		 // Step 3 : Select the deselected Radio button (female) for category Sex (Use IsSelected method)
		 // Storing all the elements under category 'Sex' in the list of WebLements 
		  rdBtn_Sex = driver.findElements(By.name("sex"));
		 
		 // Create a boolean variable which will hold the value (True/False)
		 boolean bValue = false;
		 
		 // This statement will return True, in case of first Radio button is selected
		 bValue = rdBtn_Sex.get(0).isSelected();
		 
		 // This will check that if the bValue is True means if the first radio button is selected
		 if(bValue == true){
		 // This will select Second radio button, if the first radio button is selected by default
		 rdBtn_Sex.get(1).click();
		 }else{
		 // If the first radio button is not selected by default, the first will be selected
		 rdBtn_Sex.get(0).click();
		 }
		 
		 //Step 4: Select the Third radio button for category 'Years of Exp' (Use Id attribute to select Radio button)
		  rdBtn_Exp = driver.findElement(By.id("exp-2"));
		 rdBtn_Exp.click();
		 
		 // STep 5: Check the Check Box 'Automation Tester' for category 'Profession'( Use Value attribute to match the selection)
		 // Find the Check Box or radio button element by Name
		  chkBx_Profession = driver.findElements(By.name("profession"));
		 
		 // This will tell you the number of Check Boxes are present
		 int iSize = chkBx_Profession.size();
		 
		 // Start the loop from first Check Box to last Check Boxe
		 for(int i=0; i < iSize ; i++ ){
		 // Store the Check Box name to the string variable, using 'Value' attribute
		 String sValue = chkBx_Profession.get(i).getAttribute("value");
		 
		 // Select the Check Box it the value of the Check Box is same what you are looking for
		 if (sValue.equalsIgnoreCase("Automation Tester")){
		 chkBx_Profession.get(i).click();
		 // This will take the execution out of for loop
		 break;
		 }
		 }
		 // Step 6: Check the Check Box 'Selenium IDE' for category 'Automation Tool' (Use cssSelector)
		 oCheckBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
		 oCheckBox.click();
		 
		 // Kill the browser
		// driver.quit();
	}

	private static void guruRedioCheckBoxTest() {
		// TODO Auto-generated method stub

		driver.get(Constants.urlGuru99CheckRadio);

		radio1 = driver.findElement(By.id("vfb-7-1"));
		radio2 = driver.findElement(By.id("vfb-7-2"));

		// Radio Button1 is selected
		radio1.click();
		System.out.println("Radio Button Option 1 Selected");

		// Radio Button1 is de-selected and Radio Button2 is selected
		radio2.click();
		System.out.println("Radio Button Option 2 Selected");

		// Selecting CheckBox
		option1 = driver.findElement(By.id("vfb-6-0"));

		// This will Toggle the Check box
		option1.click();

		// Check whether the Check box is toggled on
		if (option1.isSelected()) {
			System.out.println("Checkbox is Toggled On");

		} else {
			System.out.println("Checkbox is Toggled Off");
		}

		driver.close();
	}
}
