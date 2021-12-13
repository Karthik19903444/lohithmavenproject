package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetTheDataFromExcelSheet3 {
	@Test	
	public void getData() throws EncryptedDocumentException, IOException
	//fetch only 1st and 2nd colum data from all the rows
	{
	FileInputStream f = new FileInputStream("./data/testData.xlsx");
	Workbook w = WorkbookFactory.create(f);
	Sheet s = w.getSheet("Sheet1");
	int rowNo = s.getLastRowNum();//1
	s.getPhysicalNumberOfRows();//2
	
	for(int i=0;i<rowNo;i++) {
		Row r = s.getRow(i);
		System.out.println(r.getCell(0).getStringCellValue());
		System.out.println(r.getCell(1).getStringCellValue());
        System.out.println(s.getPhysicalNumberOfRows());
        System.out.println(rowNo);
        
		
		
		
		
	}
	
	
	
	
	
	
	
	
	}
	

}
