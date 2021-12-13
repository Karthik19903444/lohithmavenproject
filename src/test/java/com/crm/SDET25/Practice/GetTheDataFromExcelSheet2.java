package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetTheDataFromExcelSheet2 {
	@Test
	public void getData() throws EncryptedDocumentException, IOException
	{
		//getting different types of data from excel sheet
      FileInputStream f = new FileInputStream("./data/testData.xlsx");
      Workbook w = WorkbookFactory.create(f);
      String url = w.getSheet("Sheet1").getRow(1).getCell(0).toString();
      String browser = w.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
      String username = w.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
      String password = w.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
      String phone = w.getSheet("Sheet1").getRow(1).getCell(4).toString();
      
      
      System.out.println(url);
      System.out.println(browser);
      System.out.println(username);
      System.out.println(password);
      System.out.println(phone);
      
		
		
	}

}
