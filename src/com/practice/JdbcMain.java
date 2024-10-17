package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMain {

	public static void main(String[] args) {

		try {
			//load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//create connection
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:Xstore","shrikant","shrikant");  
			
			//create Statement
		    Statement stmt =con.createStatement();
		    ResultSet rs= stmt.executeQuery("select * from employee");
		    while(rs.next()) {
		    	
		    	int empId= rs.getInt(1);
		    	String empName =rs.getString(2);
		    	int empSalry= rs.getInt(3);
		    	String empAddress= rs.getString(4);
		    	System.out.println(empId);
		    	System.out.println(empName);
		    	System.out.println(empSalry);
		    	System.out.println(empAddress);
		    	System.out.println("-------------------");
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
