package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {

	protected WebDriver driver;
	private String drName;
	private By newAppointmentButton = By.cssSelector( "input[value='Create new appointment']");
	private By selectDoctor = By.xpath("//h4[normalize-space()='Dr."+drName+"']/ancestor::ul/following-sibling::button" );
	private By datePickerId = By.id("datepicker");
	private By yearDatePicker = By.cssSelector(".ui-datepicker-year");
	private By monthDatePicker = By.cssSelector(".ui-datepicker-month");
	private By arrowDatePicker = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
	private By timeID = By.id("time");
	private By continueButton =  By.id("ChangeHeatName") ;
	private By symptomsID =  By.id("sym");
	private By submitButton = By.cssSelector("input[value='Submit']");
	private By actualDateXpath = By.xpath("//table[@class='table']/tbody/tr[1]/td[1]");
	private By actualTimeXpath = By.xpath("//table[@class='table']/tbody/tr[1]/td[2]");
	private By actualAppointmentXpath = By.xpath("//table[@class='table']/tbody/tr[1]/td[3]");
	private By actualDoctorXpath = By.xpath("//table[@class='table']/tbody/tr[1]/td[4]");
	 
	
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
		 
	}
	
	public HashMap<String, String> scheduleAppointment(String doctorName,String date, String time,String sym)
	{
		
		   		HashMap<String,String> hMap= new HashMap<String,String>();
		   		 
				//Create New Appointment button
				driver.findElement(newAppointmentButton).click();
				
				//Select the doctor
				drName=doctorName;
				
				driver.findElement(selectDoctor).click();
				//Switch to a frame
				driver.switchTo().frame("myframe");		
				//Datepicker
				driver.findElement(datePickerId).click();
			
				String expectedDate = date;
				 
				String expectedDateArr[] = expectedDate.split("/");
				String expMonth=expectedDateArr[1];
				String expDay=expectedDateArr[0];
				String expYear=expectedDateArr[2];
				
				String actualYear = driver.findElement(yearDatePicker).getText();
				
				while(!(actualYear.equals(expYear)))
				{
					driver.findElement(arrowDatePicker).click();
					actualYear = driver.findElement(yearDatePicker).getText();
				}
				String actualMonth=driver.findElement(monthDatePicker).getText();
				while(!(actualMonth.equals(expMonth)))
				{
					driver.findElement(arrowDatePicker).click();
					actualMonth=driver.findElement(monthDatePicker).getText();
				}
				driver.findElement(By.linkText(expDay)).click();
				Select timeSelect = new Select(driver.findElement(timeID));
				timeSelect.selectByVisibleText(time);
				driver.findElement(continueButton).click();
				driver.findElement(symptomsID).sendKeys(sym);
				driver.findElement(submitButton).click();
				String actualDate = driver.findElement(actualDateXpath).getText().trim();
				String actualTime = driver.findElement(actualTimeXpath).getText().trim();
				String actualAppointment = driver.findElement(actualAppointmentXpath).getText().trim();
				String actualDoctor= driver.findElement(actualDoctorXpath).getText().trim();
				
				hMap.put("date",  actualDate);
				hMap.put("time",  actualTime);
				hMap.put("sym",  actualAppointment);
				hMap.put("doctor",  actualDoctor);
				return hMap;
	}
}
