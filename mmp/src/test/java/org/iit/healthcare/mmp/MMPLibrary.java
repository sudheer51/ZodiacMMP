package org.iit.healthcare.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MMPLibrary {
	
	WebDriver driver;
	
	public MMPLibrary(WebDriver driver)
	{
		this.driver = driver;
	}

	public void login(String uname,String pword)
	{
		//Login
				driver.findElement(By.id("username")).sendKeys(uname);
				driver.findElement(By.id("password")).sendKeys(pword);
				driver.findElement(By.name("submit")).click();
	}
	public HashMap<String, String> scheduleAppointment(String doctorName,String date, String time,String sym)
	{
		
		   		HashMap<String,String> hMap= new HashMap<String,String>();
		   		
				//Create New Appointment button
				driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
				//Select the doctor
				driver.findElement(By.xpath("//h4[normalize-space()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();
				//Switch to a frame
				driver.switchTo().frame("myframe");		
				//Datepicker
				driver.findElement(By.id("datepicker")).click();
			
				String expectedDate = date;
				 
				String expectedDateArr[] = expectedDate.split("/");
				String expMonth=expectedDateArr[1];
				String expDay=expectedDateArr[0];
				String expYear=expectedDateArr[2];
				
				String actualYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
				
				while(!(actualYear.equals(expYear)))
				{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				}
				String actualMonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
				while(!(actualMonth.equals(expMonth)))
				{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					actualMonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
				}
				driver.findElement(By.linkText(expDay)).click();
				Select timeSelect = new Select(driver.findElement(By.id("time")));
				timeSelect.selectByVisibleText(time);
				driver.findElement(By.id("ChangeHeatName")).click();
				driver.findElement(By.id("sym")).sendKeys(sym);
				driver.findElement(By.cssSelector("input[value='Submit']")).click();
				String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText().trim();
				String actualTime = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText().trim();
				String actualAppointment = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText().trim();
				String actualDoctor= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText().trim();
				
				hMap.put("date",  actualDate);
				hMap.put("time",  actualTime);
				hMap.put("sym",  actualAppointment);
				hMap.put("doctor",  actualDoctor);
				return hMap;
	}
	 
}