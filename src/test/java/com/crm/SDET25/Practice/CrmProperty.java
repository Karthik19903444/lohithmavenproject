package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrmProperty {
	
	@Test
	public void crmProperty() throws FileNotFoundException, IOException
	
	{
		Properties properties = new Properties();
		properties.load(new FileInputStream("./data.properties"));
		String url=properties.getProperty("url");
		String username=("username");
		String password=properties.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.get(url);
	
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		
		
		
		
		
		
		
		
		
	}
	
	

}
