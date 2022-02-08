package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.List;

import org.iit.healthcare.mmp.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaymentInformationPage {
	protected WebDriver driver;
   
   private By SearchSSN=By.xpath("//input[@id='search']");
   private By FindPatient=By.xpath("//a[normalize-space()='1']");
   
   private By FirstName=By.name("fname");
   private By LastName=By.name("lname");
   private By datePickerId = By.id("datepicker");
   private By selectSex=By.xpath("//input[@id='male']");
   private By workingStatus= By.xpath("//input[@id='worksts']");
   private By license= By.xpath("//input[@id='worksts']");
   private By docName= By.xpath("//select[@id='doc']']");
   private By dateID = By.xpath("//input[@id='dos']");
   private By modifierCode=By.xpath("//select[@id='mcode')]");
   private By icdCode=By.xpath("//select[@id='dia']");
   private By balance=By.xpath("//input[@id='bal']");
   
   public PaymentInformationPage(WebDriver driver)
	{
		this.driver = driver;
		driver.findElement( SearchSSN).getText();
		driver.findElement(FindPatient).click();
		driver.findElement(FirstName).getText();
		driver.findElement(LastName).getText();
		driver.findElement(datePickerId).getText();
		driver.findElement(selectSex).click();
		driver.findElement(workingStatus).click();
		driver.findElement(license).sendKeys("medical123");
		
		List<WebElement> docdrop=driver.findElements(docName);
		Select sel=new Select((WebElement) docdrop);
		sel.selectByValue("Beth");
		
		driver.findElement(dateID).click();
		
		AppLibrary dd= new AppLibrary();
		dd.getFutureDate(0, null);
		
		List<WebElement>modrop =driver.findElements(docName);
		Select mm=new Select((WebElement) modrop);
		mm.selectByValue("100");
		
		List<WebElement>icddrop =driver.findElements(docName);
		Select cc=new Select((WebElement) icddrop);
		cc.selectByValue("200");
		driver.findElement(balance).sendKeys("40");
		
	
	}
}