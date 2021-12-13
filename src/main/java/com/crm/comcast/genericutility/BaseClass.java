package com.crm.comcast.genericutility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.seleniumhq.jetty9.util.log.JavaUtilLog;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectrepositoryUtility.HomePage;
import com.crm.comcast.objectrepositoryUtility.Login;



public class BaseClass {
	public WebDriver driver;
	  
	/* create object to libraries*/
	public FileUtility flib = new FileUtility();
	public JavaUtlity jLib = new JavaUtlity();
	public WebDriverUtility wLib = new WebDriverUtility();
    public ExcelUtility eLib = new ExcelUtility();
    
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("========================connect to DB========================");
                 
	}
		
	//@Parameters("BROWSER")
	@BeforeClass//(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("=============Launch the Browser=======");
		String BROWSER = flib.getPropertyKeyValue("browser");
		if(BROWSER.equals("chrome")) {
		    driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			 driver = new ChromeDriver();
		}

		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		/*common Data*/
		 String BROWSER = flib.getPropertyKeyValue("browser");
		 String URL = flib.getPropertyKeyValue("url");
		 String USERNAME = flib.getPropertyKeyValue("username");
		 String PASSWORD = flib.getPropertyKeyValue("password");
		/* Navigate to app*/
		   driver.get(URL);
	        /* step 1 : login */
		   Login loginPage = new Login(driver);
	        loginPage.loginToApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
	      /*step 6 : logout*/
		HomePage homePage = new HomePage(driver);
        homePage.signOut();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("========================close DB========================");
	}
}

