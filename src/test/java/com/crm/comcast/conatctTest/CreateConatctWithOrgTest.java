package com.crm.comcast.conatctTest;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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
public class CreateConatctWithOrgTest{
	public WebDriver driver;
	@Test(groups={"smokeTest"})
	public void createConatctWithOrgTest() throws Throwable {
		
        /* create object to libraries*/
		JavaUtlity jLib = new JavaUtlity();
		WebDriverUtility wLib = new WebDriverUtility();
        FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/* get ramDomData */
		int randomNum = jLib.getRandomNumber();
		
		/* read common data from Properties File*/

		 String BROWER = fLib.getPropertyKeyValue("browser");
		 String URL = fLib.getPropertyKeyValue("url");
		 String USERNAME = fLib.getPropertyKeyValue("username");
		 String PASSWORD = fLib.getPropertyKeyValue("password");
		 
		 /* read test data from Excel File*/

		    String orgName = eLib.getDataFromExcel("contact", 1, 1) + randomNum;
		    String conactName = eLib.getDataFromExcel("contact", 1, 1) + randomNum;

         
         /* launch the Browser */ 
         
         if(BROWER.equals("chrome")) {
              driver = new ChromeDriver();
         }else if(BROWER.equals("firefox")){
        	  driver = new FirefoxDriver();
         }else if(BROWER.equals("ie")){
       	  driver = new InternetExplorerDriver();
        }else {
            driver = new ChromeDriver();
        }
         
         driver.manage().window().maximize();
         wLib.waitForPageToLoad(driver);
         driver.get(URL);

        wLib.waitForPageToLoad(driver)              ;
        /* step 2 :  login */ 
        Login lp = new Login(driver);
        lp.loginToApp(USERNAME, PASSWORD);
        
        
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
        
        /* step 8 : verify */ 
        ContactsInfoPage cip = new ContactsInfoPage(driver);
        String  actContactinfo = cip.getContactSucMsg().getText();
        if(actContactinfo.contains(conactName)) {
       	 System.out.println(conactName + "==> is created==>PASS");
        }else {
       	 System.out.println(conactName + "==> is not created==>Fail");

        }
        
   /* step 9 : logout */ 
    hp.signOut();
    driver.quit();
        

	}
}
	
	

	