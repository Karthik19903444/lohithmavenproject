package com.crm.comcast.genericutility;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
/*cross Browser*/
//@Parameters("BROWSER")
//@BeforeClass//(groups = {"smokeTest","regressionTest"})
//public void configBC(String BROWSER) throws Throwable {
//	System.out.println("=============Launch the Browser=======");
//	//String BROWSER = flib.getPropertyKeyValue("browser");
//	if(BROWSER.equals("chrome")) {
//	    driver = new ChromeDriver();
//	}else if(BROWSER.equals("firefox")) {
//		driver = new FirefoxDriver();
//	}else if(BROWSER.equals("ie")) {
//		driver = new InternetExplorerDriver();
//	}else {
//		 driver = new ChromeDriver();
//	}

//import com.crm.comcast.objectrepositoryUtility.Login;

/*normal browser*/
////@Parameters("BROWSER")
//@BeforeClass//(groups = {"smokeTest","regressionTest"})
//public void configBC() throws Throwable {
//	System.out.println("=============Launch the Browser=======");
//	String BROWSER = flib.getPropertyKeyValue("browser");
//	if(BROWSER.equals("chrome")) {
//	    driver = new ChromeDriver();
//	}else if(BROWSER.equals("firefox")) {
//		driver = new FirefoxDriver();
//	}else if(BROWSER.equals("ie")) {
//		driver = new InternetExplorerDriver();
//	}else {
//		 driver = new ChromeDriver();
//	}


//
