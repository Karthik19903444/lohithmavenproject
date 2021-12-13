package com.crm.SDET25.Practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class selectTodaysDate {
	@Test
	
	public void getdates() {
		LocalDateTime dateAndTime = LocalDateTime.now();
		int day = dateAndTime.getDayOfMonth();
	    String month=dateAndTime.getMonth().name();
	    String updateMonth = month.substring(0,1)+month.substring(1).toLowerCase();
	    int year = dateAndTime.getYear();
	    String monthAndYear=updateMonth+" "+year;
	    
	    WebDriver driver = new ChromeDriver();driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	    driver.get("https://www.makemytrip.com/"); 
	    Actions action = new Actions(driver);
	    action.moveByOffset(0, 30).click().perform();
	    driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
	    driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	    String path="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
	    driver.findElement(By.xpath(path)).click();
	    
	    
		
		
		
		
		
		
	}
	

}
