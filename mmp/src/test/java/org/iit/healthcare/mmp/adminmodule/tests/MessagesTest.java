package org.iit.healthcare.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.LoginPage;
import org.iit.healthcare.mmp.MMPLibrary;
import org.iit.healthcare.mmp.adminmodule.pages.MessagesPage;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.SendMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MessagesTest 	extends BaseClass {

	@Test
	public void validateMessagesE2E()
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser(pro.getProperty("patientURL"));
		LoginPage lPage  = new LoginPage(driver);
		HomePage hPage = lPage.login(pro.getProperty("patientusername"),pro.getProperty("patientpassword"));
		hPage.navigateToAModule("Messages");
		SendMessagesPage sPage =new SendMessagesPage(driver);
		HashMap<String,String> expectedHMap = sPage.sendMessages("Appointment for Orthopedic Doctor", "Pain in legs");
		
		mmpLib.launchBrowser(pro.getProperty("adminURL"));
		hPage = lPage.login(pro.getProperty("adminusername"),pro.getProperty("adminpassword"));
		hPage.navigateToAModule("Messages");
		MessagesPage mPage = new MessagesPage(driver);
		HashMap<String,String> actualHMap =mPage.getMessageDetails();
		Assert.assertEquals(actualHMap, expectedHMap);

	}

}
