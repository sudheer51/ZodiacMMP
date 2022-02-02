package org.iit.healthcare.mmp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleAppointmentTest {

	

	@Test
	public void validateScheduleAppointment()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		//Login
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		
		//navigation to a tab
		driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment']")).click();
	
		//Create New Appointment button
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
		
		
		//Select the doctor
		driver.findElement(By.xpath("//h4[normalize-space()='Dr.Beth']/ancestor::ul/following-sibling::button")).click();
		String expectedDoctor="Beth";
		
		//Switch to a frame
		driver.switchTo().frame("myframe");
		
		//Datepicker
		driver.findElement(By.id("datepicker")).click();
		
		
		String expectedDate = getFutureDate(15,"dd/MMMM/YYYY");
		String expectedDateFormat =  getFutureDate(15,"MM/dd/YYYY");
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
		timeSelect.selectByVisibleText("10Am");
		String expectedTime="10Am";
		
		driver.findElement(By.id("ChangeHeatName")).click();
		
		
		driver.findElement(By.id("sym")).sendKeys("Fever,Cold");
		String expectedAppointment="Fever,Cold";
		
		
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText().trim();
		String actualTime = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText().trim();
		String actualAppointment = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText().trim();
		String actualDoctor= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText().trim();
		
		Assert.assertEquals(actualDate, expectedDateFormat);
		
		Assert.assertEquals(actualTime, expectedTime);
		
		Assert.assertEquals(actualAppointment, expectedAppointment);
		
		Assert.assertEquals(actualDoctor, expectedDoctor);
	
	}
	
	public String getFutureDate(int days,String format)
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date = sdf.format(cal.getTime());
		cal.add(Calendar.DATE, days); 
		date = sdf.format(cal.getTime());
		System.out.println("To Date::" + date);
		return date;
	}
	 
 
}







