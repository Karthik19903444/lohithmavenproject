package com.crm.SDET25.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdateQuery {
	@Test
	public void sampeJDBCUpdate() throws Throwable
	{
		//step1
		Driver driverRef = new Driver();
		
		//step2 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
		
		//step3
		Statement stat = conn.createStatement();
		
		//step4
		int result = stat.executeUpdate("insert into studentinfo values('sweta',15,'odisa');");
		
		if (result==1) {
			System.out.println("data created");			
		}
		else {
			System.out.println("data creation failed");	
			
		}
		
		
		//step5
		conn.close();
		
		
		
		
	}

}
