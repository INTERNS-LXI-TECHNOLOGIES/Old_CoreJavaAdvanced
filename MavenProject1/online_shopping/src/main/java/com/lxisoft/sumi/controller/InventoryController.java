package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*;
import java.util.*;
import java.io.*;
import java.sql.*;
public class InventoryController
{
	String url="jdbc:mysql://localhost:3306/online_shopping";
	String uname="root";
	String pass="root";
	Connection conn=null;
	Connection con=null;
	PreparedStatement stmt=null;
	Statement state=null;
	//private Map<Integer,Product> stock=new HashMap<Integer,Product>();
	private Product productToAdd;
	private Product productToRemove;
	private Product productShopped;
	int i=1;
	Sale sale=new Sale();
	public static int cashInHand;
	public static int balance;
	int quantityToAdd;
	int quantityToRemove;
	int count=1;
	String date1;
	SaleController salectrl=new SaleController();
	Scanner scanner=new Scanner(System.in);
	public void entry()
	{
		
		int ch;
		do
		{
			System.out.println("[1.Add Product]\t[2.Display Prduct]\t[3.Sell Product]");
			Scanner input=new Scanner(System.in);
			int option=input.nextInt();
			switch(option)
			{
				case 1:
				{
					try
					{
						//Date date=new Date();
						//date1=date.toString();
						System.out.println("Enter quanity");
						Scanner ad=new Scanner(System.in);
						quantityToAdd=ad.nextInt();
						int id;
						String name;
						int price,maximumStockLevel;
						String searchkey;
						for(int j=0;j<quantityToAdd;j++)
						{
							System.out.println("Add products");
							System.out.println("[ID:][NAME][PRICE][MaxStock][SearchKey]");
							
							id=ad.nextInt();
							
							name=ad.nextLine();
							price=ad.nextInt();
							maximumStockLevel=ad.nextInt();
							searchkey=ad.nextLine();
							//productToAdd=new Product(id,name,price,maximumStockLevel,searchkey);
							//addStockToInventory(productToAdd,quantityToAdd) ;
							conn = DriverManager.getConnection(url,uname,pass);
							String query="insert into product "
											+ " (Id,name,price,maxStock,category)" + " values (?, ?, ?,?,?)";
							Class.forName("com.mysql.jdbc.Driver");
							stmt=conn.prepareStatement(query);
							stmt.setInt(1,id);
							stmt.setString(2,name);
							stmt.setInt(3,price);
							stmt.setInt(4,maximumStockLevel);
							stmt.setString(5,searchkey);
							stmt.executeUpdate();
							stmt.close();
							conn.close();
							
						}
					}
					catch(Exception e)
					{
						System.out.println("Error");
					}
				}
					
				break;
				case 2:
					display();
					break;
				case 3:
					salectrl.sell();
			}
			System.out.println("Store keeper......Do you wanna Continue ..(Y/N)");
			ch=scanner.next().charAt(0);
		}
		while(ch=='Y');
	}
	public void display()
	{
		try
		{
			conn = DriverManager.getConnection(url,uname,pass);
			String query1="select * from product";
			Class.forName("com.mysql.jdbc.Driver");
			state = conn.createStatement();
			ResultSet rs = state.executeQuery(query1);
			System.out.println("Products Available:\n");
			int i=1;
			while (rs.next())
			{
				System.out.println("Product: "+i+"\n");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				
				System.out.println("Price: "+rs.getString(3));
				System.out.println("Stocks Available:"+rs.getString(4)+"\n");
				i++;
			}
			conn.close();
			state.close();
		}
		catch (Exception e)
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
					display();
					break;
			}
			System.out.println("Do you wanna Continue the shopping(Y/N)");
			ch=scanner.next().charAt(0);
		}
		while(ch=='Y');
	}
	public void buyProduct()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Available products: ");
		display();
		System.out.println("Enter purchasing product Id ");
		int id=input.nextInt();
		try{
			conn = DriverManager.getConnection(url,uname,pass);
			String query1="select * from product";
			Class.forName("com.mysql.jdbc.Driver");
			state = conn.createStatement();
			ResultSet rs = state.executeQuery(query1);
			System.out.println(":\n");
			int i=1;
			while (rs.next())
			{
				if(id==rs.getInt(1))
				{
					int sid=rs.getInt(1);
					String sname=rs.getString(2);
					int sprice=rs.getInt(3);
					String ccategory=rs.getString(5);
					String query3="insert into product_sell(id,name,price,category) values(?,?,?,?)";
					state=conn.createStatement();
					String query2="update product set maxStock=maxStock-1 where Id=?";
					stmt=conn.prepareStatement(query2);
					System.out.println("You purchased product is:");
					System.out.println(rs.getString(2));
					System.out.println("Price: "+rs.getInt(3));
					stmt.setInt(1,id);
					stmt.executeUpdate();
					stmt=conn.prepareStatement(query3);
					stmt.setInt(1,sid);
					stmt.setString(2,sname);
					stmt.setInt(3,sprice);
					stmt.setString(4,ccategory);
					stmt.executeUpdate();
					stmt.close();
				}
			}
			conn.close();
			state.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}