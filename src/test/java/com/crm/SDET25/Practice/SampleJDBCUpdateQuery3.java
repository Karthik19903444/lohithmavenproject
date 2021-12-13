package com.crm.SDET25.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdateQuery3 {
	@Test
	public void sampeJDBCUpdate() throws Throwable
	{Connection conn=null;
	
	
	try{
		
		//step1
		Driver driverRef = new Driver();
		
		//step2 
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
		
		//step3
		Statement stat = conn.createStatement();
		
		//step4
		int result = stat.executeUpdate("insert into studentinfo uses('nidhi',15,'mangalore');");
		
		if (result==1) {
			System.out.println("data created");			
		}
		else {
			System.out.println("data creation failed");	
			
		}
	}
	
	
	catch (Exception e)
	{ 
		
	}
	
	
	finally {
		
		//step5 close the database
		conn.close();
		System.out.println("connection is closed");	
		
		
	}
		
		
	}

}
