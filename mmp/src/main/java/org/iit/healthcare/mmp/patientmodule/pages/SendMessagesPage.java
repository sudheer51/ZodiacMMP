package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iit.healthcare.mmp.AppLibrary;
import org.iit.healthcare.mmp.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesPage {

	private WebDriver driver;
	
	public SendMessagesPage(WebDriver driver)
	{
		this.driver = driver;
		 
	}
	
	public HashMap<String, String> sendMessages(String subject,String message)
	{
		HashMap<String,String> msgHMap = new HashMap<String,String>();
		 
		msgHMap.put("subject", subject);
		msgHMap.put("message", message);
		driver.findElement(By.id("subject")).sendKeys(subject);
		driver.findElement(By.id("message")).sendKeys(message);
		driver.findElement(By.cssSelector("input[value='Send']")).submit();
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.getAlertText();
		ProfilePage profPage = new ProfilePage(driver);
		HomePage hPage = new HomePage(driver);
		hPage.navigateToAModule("Profile");
		String patientName = profPage.getPatientName();
		msgHMap.put("patientName", patientName);
		msgHMap.put("date",AppLibrary.getFutureDate(0,"dd-MM-YYYY"));
		return msgHMap;
		
	}
}
