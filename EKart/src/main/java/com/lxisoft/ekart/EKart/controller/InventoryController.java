package com.lxisoft.ekart.EKart.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.lxisoft.ekart.EKart.connection.DataConnection;
import com.lxisoft.ekart.EKart.model.Product;

public class InventoryController {
	
	Product product;
	DataConnection jdbc=new DataConnection();
	SalesController sale=new SalesController();
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	public void storeKeeper()
	{
		
		Scanner input=new Scanner(System.in);
		char ch;
		do
		{
			System.out.println("Enter your choice...[1.Add Product]   [2.View Product]   [3.Selled Products]");
			int choice=input.nextInt();
			switch(choice)
			{
				case 1:
				{
					addProduct();
					break;
				}
				case 2:
				{
					viewProduct();
					break;
				}
				case 3:
				{
					sale.selledProduct();
				}
			}
			System.out.println("Do you wanna continue(Y/N)");
			ch=input.next().charAt(0);
		}while(ch=='Y'||ch=='y');
		
	}

	
	private void addProduct() {

		System.out.println("Enter quanity");
		Scanner ad=new Scanner(System.in);
		int quantityToAdd=ad.nextInt();
		int id;
		String name;
		int price,maximumStockLevel;
		String searchkey;
		try{
		con=jdbc.getConnection();
		String query="insert into products "
				+ " (id,name,price,maxstock,search)" + " values (?, ?, ?,?,?)";
		for(int j=0;j<quantityToAdd;j++)
		{
			System.out.println("Add products");
			System.out.println("[ID:][NAME][PRICE][MaxStock][SearchKey]");
			
			id=ad.nextInt();
			
			name=ad.nextLine();
			price=ad.nextInt();
			maximumStockLevel=ad.nextInt();
			searchkey=ad.nextLine();
			product=new Product(id,name,price,maximumStockLevel,searchkey);
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3,price);
			pstmt.setInt(4,maximumStockLevel);
			pstmt.setString(5,searchkey);
			pstmt.executeUpdate();
			
		}
		pstmt.close();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void viewProduct() {
		try{
			con=jdbc.getConnection();
			stmt=jdbc.getStatement(con);
			String query="select * from products";
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("Available Products are:");
			while(rs.next())
			{
				
				System.out.println("Product Id: "+rs.getInt(1));
				System.out.println("Product: "+rs.getString(2));
				System.out.println("Price: "+rs.getInt(3));
				System.out.println("Maximum Stocks Available:"+rs.getInt(4));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			}
		
		
	}
		public void productSale()
		{
			char ch;
			do{
				System.out.println("[1.Buy Product] [2.View Product]");
				Scanner scanner=new Scanner(System.in);
				int select=scanner.nextInt();
				switch(select)
				{
					case 1:
		
						buyProduct();
						break;
					
					case 2:
						viewProduct();
						break;
				}
				System.out.println("Do you wanna Continue the shopping(Y/N)");
				ch=scanner.next().charAt(0);
			}
			while(ch=='Y'||ch=='y');
		}


		private void buyProduct() {
			Scanner input=new Scanner(System.in);
			System.out.println("Available products: ");
			viewProduct();
			System.out.println("Enter purchasing product Id ");
			int id=input.nextInt();
			try{
				String query1="select * from products";
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query1);
				System.out.println(":\n");
				int i=1;
				while (rs.next())
				{
					if(id==rs.getInt(1))
					{
						int sid=rs.getInt(1);
						String sname=rs.getString(2);
						int sprice=rs.getInt(3);
						String search=rs.getString(5);
						String query3="insert into product_sell(id,name,price,search) values(?,?,?,?)";
						stmt=con.createStatement();
						String query2="update products set maxstock=maxstock-1 where id=?";
						pstmt=con.prepareStatement(query2);
						System.out.println("You purchased product is:");
						System.out.println(rs.getString(2));
						System.out.println("Price: "+rs.getInt(3));
						pstmt.setInt(1,id);
						pstmt.executeUpdate();
						pstmt=con.prepareStatement(query3);
						pstmt.setInt(1,sid);
						pstmt.setString(2,sname);
						pstmt.setInt(3,sprice);
						pstmt.setString(4,search);
						pstmt.executeUpdate();
						pstmt.close();
					}
				}
				con.close();
				stmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			
		}

}
