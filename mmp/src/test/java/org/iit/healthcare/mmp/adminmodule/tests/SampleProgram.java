package org.iit.healthcare.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.LoginPage;
import org.iit.healthcare.mmp.MMPLibrary;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.SendMessagesPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SampleProgram 	extends BaseClass {

	@Test
	public void validateMessagesE2E()
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser(pro.getProperty("patientURL"));
		LoginPage lPage  = new LoginPage(driver);
		HomePage hPage = lPage.login(pro.getProperty("patientusername"),pro.getProperty("patientpassword"));
		hPage.navigateToAModule("Profile");
		driver.findElement(By.id("Ebtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("#fname")).getAttribute("value"));
		 
		
	}
		 

}
