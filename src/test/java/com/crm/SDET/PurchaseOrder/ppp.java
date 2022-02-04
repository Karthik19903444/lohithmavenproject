package com.crm.SDET.PurchaseOrder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ppp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.get("https://www.skillrary.com/");
      driver.findElement(By.xpath("//a[text()='Sign In']")).click();
      driver.findElement(By.id("email")).sendKeys("lohith.kk");
      driver.findElement(By.name("password")).sendKeys("dgdg");
      driver.findElement(By.xpath("//div[contains(@class,'border')]")).click();
      
	}

}
