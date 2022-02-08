package org.iit.healthcare.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

//package org.iit.healthcare.mmp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class MMPLibrary {
	
	WebDriver driver;
	
	public MMPLibrary(WebDriver driver)
	{
		this.driver = driver;
	}
	public String getAlertText()
	{
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		return text;
	}
	public void launchBrowser(String applicationURL)
	{
		driver.get(applicationURL);
	}
	 
	 
}

	 
	 

