package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InventoryController {
	private Scanner input=null;
	private PreparedStatement prestmt=null;
	Connection con=null;
	public void signIn(){
	System.out.println("Add products to the Store");
	addProduct();	
	}
	public void addProduct()
	{
		try{ 
			
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","root");
			String query="insert into addProduct"+"(id,name,price,category)"+" values(?,?,?,?)";
			prestmt=con.prepareStatement(query); 
			input = new Scanner(System.in);
			System.out.println("[Product ID] [Product Name] [Price] [Category] ");
			int id  = input.nextInt();
			
			String name = input.nextLine();
		
			int price = input.nextInt();
		
			String category = input.nextLine();
			
			prestmt.setInt(1,id);//1 specifies the first parameter in the query  
			prestmt.setString(2,name);  
			prestmt.setInt(3,price);
			prestmt.setString(4,category);  
			      
			prestmt.executeUpdate();  
			System.out.println("Add product"+name+"\tsuccessfully to the store\n ");  
			prestmt.close();
			con.close();
		}catch(Exception e){ System.out.println(e);}  	
	}	
	
	public void displayStock(){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","root");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from addProduct");  
			while(rs.next())  
			System.out.println("Product ID:"+rs.getInt(1)+" \nProduct Name "+rs.getString(2)+"\n Price: "+rs.getInt(3)+"\nCategory: "+rs.getString(4));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  
	}

