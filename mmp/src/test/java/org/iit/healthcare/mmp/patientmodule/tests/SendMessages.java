package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.LoginPage;
import org.iit.healthcare.mmp.MMPLibrary;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.SendMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMessages extends BaseClass {

	@Test
	public void validateScheduleAppointment()
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser(pro.getProperty("patientURL"));
		LoginPage lPage  = new LoginPage(driver);
		HomePage hPage = lPage.login(pro.getProperty("patientusername"),pro.getProperty("patientpassword"));
		hPage.navigateToAModule("Messages");
	    SendMessagesPage sPage =new SendMessagesPage(driver);
	    HashMap<String,String> hMap = sPage.sendMessages("", "");
	    String expected="Messages Successfully sent.";
	    MMPLibrary lib = new MMPLibrary(driver);
	    String actual = lib.getAlertText();
	    Assert.assertEquals(actual, expected);

	}
	
}
