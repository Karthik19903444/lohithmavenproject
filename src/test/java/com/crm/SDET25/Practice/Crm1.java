package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Crm1 {
	@Test 
	public void Create() throws IOException, InterruptedException	
	{
	WebDriver driver = null;
	
	FileInputStream file = new FileInputStream("./data.properties");
	
	Properties p = new Properties();
	p.load(file);
	
	String url = p.getProperty("url");
	String username = p.getProperty("username");
	String password = p.getProperty("password");
	String browser = p.getProperty("browser");
	
	if(browser.equals("chrome"))
	{driver=new ChromeDriver();}
	else driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	// via property file
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	//click on organization and enter fields
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("lohith1112");
	
	
	int y=driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).getLocation().getY();
	
	Thread.sleep(4000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,"+y+")");
	
	Thread.sleep(4000);
	driver.findElement(By.name("button")).click();
	
	Thread.sleep(4000);
	WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px'])[1]"));
	Actions a= new Actions(driver);
	a.moveToElement(ele).perform();
	
	//logout
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[text()='Sig Out']")).click();	
	
	
	

}

	
		
	}
