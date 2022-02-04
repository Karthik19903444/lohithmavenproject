package com.crm.comcast.genericutility;
//
//
//
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.seleniumhq.jetty9.server.Response.OutputType;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.annotations.Listeners;
//
//import com.crm.comcast.genericutility.BaseClass;
//
//@Listeners(com.crm.comcast.genericutility.LisImpClass.class)
//public class LisImpClass implements ITestListener {
//JavaUtlity jLib = new JavaUtlity();	
//	public void onTestfailure(ITestResult result) {
//		
//		String testName = result.getMethod().getMethodName();
//		System.out.println(testName + "---execute listner---");	    
//		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.driver);
//		File srcFile = eDriver.getScreenshotAs(OutputType.File);
//		String time=jLib.getSystmeDate(dateFormate);			
//		try
//		{
//			FileUtils.copyFile(scrFile,new File("./screenshot/"+testName+".png"));
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
