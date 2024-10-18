package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementExample {

	public static void main(String[] args) {

		try {
			//load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//create connection
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:Xstore","shrikant","shrikant");  
			//create query
			String query= "insert into employee (empid,empname,empsal,empaddress) "
					+ "values (?,?,?,?)";
			//get PreparedStatement
		   PreparedStatement pstmt = con.prepareStatement(query);		  
		   
		   //Here we are using buffered reader we can also use scanner for taking input
		   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		   System.out.println("enter employee id");
		   int empId =Integer.parseInt(br.readLine());

		   System.out.println("enter employee name");
		   String empName=br.readLine();

		   System.out.println("enter employee salry");
		   int empSalry =Integer.parseInt(br.readLine());

		   System.out.println("enter employee address");
		   String empAddress=br.readLine();
		   
		 //set values to query
		   
			  pstmt.setInt(1, empId);
			  pstmt.setString(2,empName);
			  pstmt.setInt(3, empSalry);
			  pstmt.setString(4,empAddress);
		      int n=pstmt.executeUpdate();
		   System.out.println("data inserted");
		   con.close();
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
