package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
//write data into excel sheet
public class WriteDataIntoExcelSheet {
	@Test
	public void writeData() throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("./data/testData.xlsx");
		Workbook w=WorkbookFactory.create(file);
		Sheet s=w.getSheet("Sheet1");
		Row r=s.getRow(1);
		Cell c=r.createCell(7);
		c.setCellValue("testyantra");
		
		FileOutputStream f2 = new FileOutputStream("./data/testData.xlsx");
		w.write(f2);
		w.close();
	}

}
