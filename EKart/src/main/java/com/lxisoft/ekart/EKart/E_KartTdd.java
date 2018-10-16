package com.lxisoft.ekart.EKart;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.lxisoft.ekart.EKart.connection.DataConnection;
import com.lxisoft.ekart.EKart.controller.CustomerController;
import com.lxisoft.ekart.EKart.controller.InventoryController;

public class E_KartTdd {

	String email,pass;
	Scanner scan=new Scanner(System.in);
	DataConnection jdbc=new DataConnection();
	InventoryController inventory=new InventoryController();
	Statement stmt;
	Connection con;
	public static void main(String args[])
	{
		E_KartTdd ekart=new E_KartTdd();
		CustomerController customer=new CustomerController();
		InventoryController inventory =new InventoryController();
		System.out.println("******Welcome To EKart*******");
		System.out.println("Enjoy your Shopping");
		
		Scanner input=new Scanner(System.in);
	
		char ch;
		do
		{
			System.out.println("Enter your choice......[1.Sign-Up]   [2.Login]   [3.StoreKeeper Login] ");
			int choice=input.nextInt();
			switch(choice)
			{
				case 1:
				{
					customer.signup();
					break;
				}
				case 2:
				{
					customer.login();
					break;
				}
				case 3:
				{
					ekart.storeLogin();
					break;
				}
			}
			System.out.println("Do you wanna continue(Y/N)");
			ch=input.next().charAt(0);
		}while(ch=='Y'||ch=='y');
	
	}
	public void storeLogin()
	{
		System.out.println("*****LOGIN******\n");
		System.out.println("Email: ");
		email=scan.nextLine();
		System.out.println("Password");
		pass=scan.nextLine();
		String email1,pass1;
		boolean value=false;
		try{
			con=jdbc.getConnection();
			stmt=jdbc.getStatement(con);
			String query="select * from storelogin";
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				email1=rs.getString(1);
				pass1=rs.getString(2);
				if(email.equals(email1))
				{
					if(pass.equals(pass1))
					{
						
						value=true;
					}
					else
					{
						System.out.println("Incorrect password");
					}
				}
				
						
			}
			if(value==true)
			{
				inventory.storeKeeper();
				//System.out.println("login success......");
			}
			else
			{
				System.out.println("Incorrect email\nplss.......re-enter the email and password");
				storeLogin();
			}
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}