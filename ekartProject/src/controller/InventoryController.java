package controller;

import connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import model.*;

public class InventoryController {
	private Scanner input=new Scanner(System.in);
	private PreparedStatement prestmt;
	Database jdbc= new Database();
	Product product = new Product();
	Connection con;
	Statement stmt; 
	private int pId;
	char ch;
	
	
	public void inventoryManager(){
		char ch;
		do{
			System.out.println("[1.Add product] [2.View Product] [2.Search Product]");
			int select=input.nextInt();
			switch(select)
			{
				case 1:
				addProduct();
				break;
				
				case 2:
					displayStock();
					break;
				
				case 3:
					searchProduct();
					break;
					
			}
			System.out.println("Do you want to Continue shopping(Y/N)");
			ch=input.next().charAt(0);
		}
		while(ch=='Y'||ch=='y');
	}
	
	
	public void addProduct()
	{
		try{ 
			con=jdbc.getConnection();
			String query="insert into inventory"+"(id,name,price,category,maxStock)"+" values(?,?,?,?,?)";
			prestmt=con.prepareStatement(query); 
			System.out.println("Add products:");
			System.out.println("[Product ID] [Product Name] [Price] [Category] [MaximumStock] ");
			
			product.setId(input.nextInt());
			product.setName(input.nextLine());
			product.setPrice(input.nextInt());
			product.setCategory(input.nextLine());
			product.setMaxStocke(input.nextInt());
						
			prestmt.setInt(1,product.getId()); 
			prestmt.setString(2,product.getName());  
			prestmt.setInt(3,product.getPrice());
			prestmt.setString(4,product.getCategory());
			prestmt.setInt(5,product.getMaxStocke());
			      
			prestmt.executeUpdate();  
			System.out.println("Product"+product.getName()+"\tsuccessfully added to the store\n ");
			prestmt.close();
			con.close();
			productSale();
		}catch(Exception e){ System.out.println(e);} 
	}	
	
	public void displayStock() {
		try{
			con=jdbc.getConnection();
			stmt=jdbc.getStatement(con);
			String query="select * from inventory";
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("Available Products are:");
			while(rs.next())
			{
				
				System.out.println("Product Id: "+rs.getInt(1));
				System.out.println("Product: "+rs.getString(2));
				System.out.println("Price: "+rs.getInt(3));
				System.out.println("Category: "+rs.getString(4));
				System.out.println("Available Stock:"+rs.getInt(5)+"\n");
				
			}
			buyProduct();
			con.close();
			stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();}
			}
	
	
	
	public void productSale()
	{
		char ch;
		do{
			System.out.println("[1.View Product] [2.Search Product]");
			int select=input.nextInt();
			switch(select)
			{
				case 1:
					displayStock();
					break;
				
				case 2:
					searchProduct();
					break;
					
			}
			System.out.println("Do you want to Continue shopping(Y/N)");
			ch=input.next().charAt(0);
		}
		while(ch=='Y'||ch=='y');
	}


	private void buyProduct() {
		System.out.println("Available products: ");
		System.out.println("Enter product Id :");
		int id=input.nextInt();
		try{
			String query1="select * from inventory";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			System.out.println(":\n");
			int i=1;
			while (rs.next())
			{
				if(id==rs.getInt(1))
				{
					int id1=rs.getInt(1);
					String name=rs.getString(2);
					int price=rs.getInt(3);
					String category=rs.getString(4);
					String query3="insert into productsell(id,name,price,category) values(?,?,?,?)";
					stmt=con.createStatement();
					String query2="update inventory set maxstock=maxstock-1 where id=?";
					prestmt=con.prepareStatement(query2);
					System.out.println("You purchased product is:");
					System.out.println(rs.getString(2));
					System.out.println("Price: "+rs.getInt(3));
					prestmt.setInt(1,id1);
					prestmt.executeUpdate();
					prestmt=con.prepareStatement(query3);
					prestmt.setInt(1,id1);
					prestmt.setString(2,name);
					prestmt.setInt(3,price);
					prestmt.setString(4,category);
					prestmt.executeUpdate();
					prestmt.close();
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


	public void searchProduct() {
		try
		{
		con=jdbc.getConnection();
		System.out.println("Enter the category for search: ");
		String userSearch=input.nextLine();
		String query="select * from inventory where category like '%"+userSearch+"%'";
		stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		System.out.println("The " +userSearch+" Products available\n");
		int i=1;
		if(rs.next())
		{
			do
			{
			System.out.println("Product: "+i+"\n");
			System.out.println(rs.getInt(1)+"   "+rs.getString(2));
			System.out.println("Price: "+rs.getInt(3));
			System.out.println("Stocks Available: "+rs.getInt(5));
			i++;
			}while(rs.next());
		
		}
		buyProduct();
		stmt.close();
		con.close();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
		
	}

}

	

