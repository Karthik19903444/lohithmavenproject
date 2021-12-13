package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetTheDataFromExcelSheet {
	@Test
	public void getExcelData() throws EncryptedDocumentException, IOException {

	FileInputStream file= new FileInputStream("./data/testData.xlsx");
	Workbook w=WorkbookFactory.create(file);
	Sheet s=w.getSheet("Sheet1");
	Row r=s.getRow(1);
	Cell c=r.getCell(0);
	String url=c.getStringCellValue();
	System.out.println(url);
	
	
	
	
	}
	
	
}
