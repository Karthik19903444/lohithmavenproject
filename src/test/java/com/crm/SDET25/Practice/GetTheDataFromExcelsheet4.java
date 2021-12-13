package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetTheDataFromExcelsheet4 {
	@Test
	public void getData() throws EncryptedDocumentException, IOException{
		//check the cell value,if it is there fetch next cell value
		FileInputStream f = new FileInputStream("./data/testData.xlsx");
		Workbook w = WorkbookFactory.create(f);
		Sheet s = w.getSheet("Sheet1");
		int rowNo = s.getLastRowNum();//1
		String expectedData = "admin";
		String actualData = s.getRow(1).getCell(2).toString();
		if(actualData.equals(expectedData)) {
			s.getRow(1).getCell(3).toString();
		}
		
		
		
		
	}

}
