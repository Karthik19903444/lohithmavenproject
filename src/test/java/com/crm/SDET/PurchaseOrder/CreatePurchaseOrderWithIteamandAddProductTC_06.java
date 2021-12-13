package com.crm.SDET.PurchaseOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtlity;
import com.crm.comcast.genericutility.WebDriverUtility;


public class CreatePurchaseOrderWithIteamandAddProductTC_06 {
	
	public static void main(String[] args) throws Throwable {
		
		  /*Object Creation for Lib*/
			JavaUtlity jLib = new JavaUtlity();
			WebDriverUtility wLib = new WebDriverUtility();
			FileUtility fLib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			

			/*common Data*/
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String URL = fLib.getPropertyKeyValue("url");
			String BROWSER = fLib.getPropertyKeyValue("browser");
			

			 /* read test data from Excel File*/

			    String orgName = eLib.getDataFromExcel("contact", 1, 1);
			   // String conactName = eLib.getDataFromExcel("contact", 4, 3) + randomNum;

			

	         /* launch the Browser */ 
	         WebDriver driver = null;
	         if(BROWSER.equals("chrome")) {
	              driver = new ChromeDriver();
	         }else if(BROWSER.equals("firefox")){
	        	  driver = new FirefoxDriver();
	         }else if(BROWSER.equals("ie")){
	       	  driver = new InternetExplorerDriver();
	        }else {
	            driver = new ChromeDriver();
	        }
	         

wLib.waitForPageToLoad(driver)              ;
driver.get(URL);

driver.manage().window().maximize();


         /* step 1 : login to APP */ 
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
         driver.findElement(By.id("submitButton")).click();
         
         wLib.mouseOverOnElemnet(driver,driver.findElement(By.linkText("More")));
         
         driver.findElement(By.linkText("Purchase Order")).click();
         
         driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();         
         driver.findElement(By.name("subject")).sendKeys(orgName);
         driver.findElement(By.xpath("//input[@name='vendor_id']/following-sibling::img[@alt='Select']")).click();
        
         wLib.swithToWindow(driver,"&");
         driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();         
         wLib.swithToWindow(driver, "PurchaseOrder");
         
         driver.findElement(By.name("bill_street")).sendKeys("bnvgf");
        // driver.findElement(null)
         driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
         
         wLib.swithToWindow(driver,"&");
         driver.findElement(By.xpath("//img[@title='Products']")).click();         
         wLib.swithToWindow(driver, "PurchaseOrder");
         
         
		
		    

         
         
         //Thread.sleep(300);
         
      // WebDriverUtility mouseOver = new WebDriverUtility();       
	 // WebElement ele = driver.findElement(By.linkText("More"));
	//  mouseOver.mouseOverOnElemnet(driver, ele);
	  
	  
	// driver.findElement(By.name("Purchase Order")).click();
	
	
	   
	   
	}
}
