package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	protected WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	    if (!driver.getTitle().equals("Home Page of logged in user")) {
	      throw new IllegalStateException("This is not Home Page of logged in user," +
	            " current page is: " + driver.getCurrentUrl());
	    }
	}
	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();
	}
}
