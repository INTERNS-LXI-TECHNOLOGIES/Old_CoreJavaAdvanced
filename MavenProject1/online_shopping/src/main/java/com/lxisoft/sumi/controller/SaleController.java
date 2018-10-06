package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*; 
import java.io.*;
import java.util.*;
import java.sql.*;

public class SaleController {
int quantity1;
int totalAmount=0;
String url="jdbc:mysql://localhost:3306/online_shopping";
String uname="root";
String pass="root";
Connection conn=null;
PreparedStatement stmt=null;
Statement state=null;
public void sell()
{
	try
	{
		conn = DriverManager.getConnection(url,uname,pass);
		System.out.println("Total products selled: \n");
		String query1="select * from product_sell";
		Class.forName("com.mysql.jdbc.Driver");
		state = conn.createStatement();
		ResultSet rs = state.executeQuery(query1);
		int i=1;
		while (rs.next())
		{
			System.out.println("Product :"+i);
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println("\n");
			i++;
			int amount=rs.getInt(3);
			totalAmount+=amount;
			
		}
		totalAmount(totalAmount);
		conn.close();
		state.close();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
}

public void totalAmount(int amount)
{
	System.out.println("Total Amount:"+amount);
}
}