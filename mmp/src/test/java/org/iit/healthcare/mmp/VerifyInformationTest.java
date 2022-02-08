package org.iit.healthcare.mmp;
	import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.VerifyInformationsPage;
	import org.testng.annotations.Test;
	  
	public class VerifyInformationTest  extends BaseClass{ 
         @Test
		  public void VerifyInformationTest()
		  
		  {
		    LoginPage lPage  = new LoginPage(driver);
			HomePage hPage = lPage.login(pro.getProperty("username"),pro.getProperty("password"));
		     hPage.navigateToAModule("Information");
		     VerifyInformationsPage sPage = new VerifyInformationsPage(driver);
		     System.out.println("Executed the tests successfully");
		  }
	  }
		
		
		
	
	


