package com.crm.SDET25.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	@Test
	public void sampleJDBCExecuterQuery() throws Throwable
	{
		//step1: Regester the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2: get connection with database - provide db name
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb","root", "root");
		
		//step3: issue create statement
		Statement stat = conn.createStatement();
		
		//state4 execute a query = provide table name
		ResultSet result = stat.executeQuery("select * from studentinfo;");
		
		
		while(result.next())
			
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			
		}
		
		
		conn.close();
		
		
	}
	

}
