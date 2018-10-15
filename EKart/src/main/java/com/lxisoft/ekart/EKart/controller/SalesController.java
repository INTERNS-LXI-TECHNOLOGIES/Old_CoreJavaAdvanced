package com.lxisoft.ekart.EKart.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.lxisoft.ekart.EKart.connection.DataConnection;

public class SalesController {
	int quantity1;
	int totalAmount=0;
	DataConnection jdbc=new DataConnection();
	Connection conn=null;
	PreparedStatement stmt=null;
	Statement state=null;

public void selledProduct() {
	
	try
		{
			conn = jdbc.getConnection();
			System.out.println("Total products selled: \n");
			String query1="select * from product_sell";
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
