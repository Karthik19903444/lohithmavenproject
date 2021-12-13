package com.vtiger.comcast.organizationtest;







import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtlity;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepositoryUtility.Contacts;
import com.crm.comcast.objectrepositoryUtility.ContactsInfoPage;
import com.crm.comcast.objectrepositoryUtility.CreateNewConatctPage;
import com.crm.comcast.objectrepositoryUtility.CreateOrganizationPage;
import com.crm.comcast.objectrepositoryUtility.HomePage;
import com.crm.comcast.objectrepositoryUtility.Login;
import com.crm.comcast.objectrepositoryUtility.OrganizationInfoPage;
import com.crm.comcast.objectrepositoryUtility.OrganizationPage;



/**
 * 
 * @author Lohith
 *
 */
public class CreateContactTest  extends BaseClass{
                 
                 
                 
                 
                 @Test(groups = {"smokeTest"})
                 public void  createContactTest() throws Throwable{
                		/* get ramDomData */
             		int randomNum = jLib.getRandomNumber();
                	 
                	 /* read test data from Excel File*/
         		    String lastName = eLib.getDataFromExcel("contact", 1, 2) + randomNum;
                 
                 /* step 1 : navigate to Contacts Page */ 
                 HomePage hp = new HomePage(driver);
                 hp.getContactLink().click(); 
                 /* step 2 :  navigate to CREATE  Contact Page*/ 
                 Contacts cp = new Contacts(driver);
                 cp.getCreateNewConatctIMG().click();
                 
                 /* step 3 : create a new Contact Page */
                 CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
                 cncp.createNewConatct(lastName);
//
//                 /* step 4 : verify */ 
//                 ContactsInfoPage cip = new ContactsInfoPage(driver);
//                 String  actContactinfo = cip.getContactSucMsg().getText();
//                 if(actContactinfo.contains(lastName)) {
//                	 System.out.println(actContactinfo + "==> is created==>PASS");
//                 }else {
//                	 System.out.println(actContactinfo + "==> is not created==>Fail");
//
//                 }
                 ContactsInfoPage cip = new ContactsInfoPage(driver);
                 String  actContactinfo = cip.getContactSucMsg().getText();
                 boolean status = actContactinfo.contains(lastName);
                 Assert.assertTrue(status);
                
	}
	
                 @Test(groups = {"regressionTest"})
                 public void createContact_Support_DateTest() throws Throwable{
                	 
                	 
                	 
                	 /* get ramDomData */
             		int randomNum = jLib.getRandomNumber(); 
             		
             		/* read test data from Excel File*/
         		    String lastName = eLib.getDataFromExcel("contact", 7, 2) + randomNum;
         		    String mobileNumber = eLib.getDataFromExcel("contact", 7, 3);
         		    String systemDate =jLib.getSystmeDate_YYYY_MM__DD();
                 
                 /* step 1 : navigate to Contacts Page */ 
                 HomePage hp = new HomePage(driver);
                 hp.getContactLink().click(); 
                 /* step 2 :  navigate to CREATE  Contact Page*/ 
                 Contacts cp = new Contacts(driver);
                 cp.getCreateNewConatctIMG().click();
                 
                 /* step 3 : create a new Contact Page */
                 CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
                 cncp.createNewConatct(lastName, mobileNumber,systemDate );

                 /* step 4 : verify */ 
//                 ContactsInfoPage cip = new ContactsInfoPage(driver);
//                 String  actContactinfo = cip.getContactSucMsg().getText();
//                 if(actContactinfo.contains(lastName)) {
//                	 System.out.println(actContactinfo + "==> is created==>PASS");
//                 }else {
//                	 System.out.println(actContactinfo + "==> is not created==>Fail");
//
//                 }
                 
                 
                 
                 ContactsInfoPage cip = new ContactsInfoPage(driver);
                 String  actContactinfo = cip.getContactSucMsg().getText();
                 boolean status = actContactinfo.contains(lastName);
                 Assert.assertTrue(status);
              
                 String createNewConatct   = cip.getDate().getText();
               Assert.assertEquals(systemDate.trim(),createNewConatct.trim(), "date not created");
                 
               
                 }



	@Test(groups = {"regressionTest"})
	public void createConatctWithOrgTest() throws Throwable {
		
       
		
		/* get ramDomData */
		int randomNum = jLib.getRandomNumber();
		
		
		 /* read test data from Excel File*/

		    String orgName = eLib.getDataFromExcel("contact", 1, 1) + randomNum;
		    String conactName = eLib.getDataFromExcel("contact", 1, 1) + randomNum;

       
        
        
   /* step 2 :  navigate to Org Page*/ 
        HomePage hp = new HomePage(driver);
        hp.getOrganizationLink().click();     
        
        
   /* step 3 : navigate to create Org page */  
        OrganizationPage op = new OrganizationPage(driver);
        op.getCreateOrganizationIMG().click();
        
        
   /* step 3 : create a new Org */   
        CreateOrganizationPage cop = new CreateOrganizationPage(driver);
        cop.createOrganization(orgName);
        
        
   /* step 4 : verify */ 
        OrganizationInfoPage oip = new OrganizationInfoPage(driver);
        wLib.waitForElemnetToBeClickAble(driver, oip.getOrganizationInfo());
        
         /* step 5 :  navigate to CREATE  Coantct Page*/ 
        hp.getContactLink().click();
         
        
        /* step 6 :  navigate to CREATE  Contact Page*/ 
        Contacts cp = new Contacts(driver);
        cp.getCreateNewConatctIMG().click();
        
        /* step 7 : create a new Contact Page */
        CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
        cncp.createNewConatct(conactName, orgName);
        
        // step 8 : verify 
     //   ContactsInfoPage cip = new ContactsInfoPage(driver);
//        String  actContactinfo = cip.getContactSucMsg().getText();
//        if(actContactinfo.contains(conactName)) {
//       	 System.out.println(conactName + "==> is created==>PASS");
//        }else {
//       	 System.out.println(conactName + "==> is not created==>Fail");
//       	 
        
        /*Verify contact created */
        ContactsInfoPage cip = new ContactsInfoPage(driver);
       String  actContactinfo = cip.getContactSucMsg().getText();
       boolean status = actContactinfo.contains(conactName);
       Assert.assertTrue(status);

        }
	}

