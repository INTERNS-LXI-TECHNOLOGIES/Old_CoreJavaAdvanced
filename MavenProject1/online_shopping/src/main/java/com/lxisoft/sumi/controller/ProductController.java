package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class ProductController
{
	String url="jdbc:mysql://localhost:3306/online_shopping";
	String uname="root";
	String pass="root";
	Connection conn=null;
	PreparedStatement stmt=null;
	Statement state=null;
	Scanner input=null;
	public void searchProduct()
	{
		try
		{
			input=new Scanner(System.in);
			System.out.println("Enter the category for search: ");
			String userCategory=input.nextLine();
			conn = DriverManager.getConnection(url,uname,pass);
			Class.forName("com.mysql.jdbc.Driver");
			String query="select * from product where category=?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1,userCategory);
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("The " +userCategory+" Products available\n");
			int i=1;
			while(rs.next())
			{
				System.out.println("Product: "+i+"\n");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				i++;
				
			
			}
			stmt.close();
			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}