package org.iit.healthcare.mmp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTestCase{

@Test

public void verifyTitle()
{
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  String actual = driver.getTitle();
	  String expected="Google";
	  Assert.assertEquals(actual,expected);
	 }
}