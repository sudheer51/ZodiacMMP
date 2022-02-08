package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyInformationsPage{
     protected WebDriver driver;
     private By selectInformations=By.xpath("//html/body/div[1]/div[1]/div[2]/div[2]/div");
	
     public VerifyInformationsPage(WebDriver driver)
 	{
 		this.driver = driver;
 		driver.findElement(selectInformations).getText();
 	}
}
