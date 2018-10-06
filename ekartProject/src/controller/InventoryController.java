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
	private int pId;
	char ch;
	
	
	public void inventoryManagerSignIn(){
		do{
		input = new Scanner(System.in);
		System.out.println("Add products to the Store");
		addProduct();
		System.out.println("Do you want to continue. Y/N");
		ch=input.next().charAt(0);
		}
	while(ch=='Y');
	}
	
	
	public void addProduct()
	{
		try{ 		
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","root");
			String query="insert into addProduct"+"(id,name,price,category,maxStock)"+" values(?,?,?,?,?)";
			prestmt=con.prepareStatement(query); 
			input = new Scanner(System.in);
			System.out.println("[Product ID] [Product Name] [Price] [Category] [MaximumStock] ");
			
			int id  = input.nextInt();
			String name = input.nextLine();
			int price = input.nextInt();
			String category = input.nextLine();
			int maxStock = input.nextInt();
			
			prestmt.setInt(1,id);//1 specifies the first parameter in the query  
			prestmt.setString(2,name);  
			prestmt.setInt(3,price);
			prestmt.setString(4,category);
			prestmt.setInt(5,maxStock);
			      
			prestmt.executeUpdate();  
			System.out.println("Product"+name+"\tsuccessfully added to the store\n ");
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
			System.out.println("Product ID:"+rs.getInt(1)+" \nProduct Name: "+rs.getString(2)+"\nPrice: "+rs.getInt(3)+"\nCategory: "+rs.getString(4)+"\nStock:"+rs.getInt(5)+"");  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  
	
	
	public void productSale(){
		System.out.println("Select your Product Id:");
		input = new Scanner(System.in);
		 pId = input.nextInt();
		 System.out.println("Quantity:");
		int quantity = input.nextInt();
		 long cost;
		 try{
		 	Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","root");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from addProduct");  
			while(rs.next()) 
			{
				if(pId==rs.getInt(1)){
					stmt=con.createStatement();
					for(int i=0;i<=quantity;i++){
					String query="update addproduct set maxStock=(maxStock-1) where id=? ";
					prestmt=con.prepareStatement(query);	
					}
					System.out.println("you purchased product:"+rs.getString(2)+"");
					System.out.println("Price:"+rs.getInt(3));
					cost=(rs.getInt(3)*quantity);
					System.out.println("Total Amount:"+cost+"");
					prestmt.setInt(1,pId);
					
					prestmt.executeUpdate();  		
					}
			}
			prestmt.close();
			con.close();
		 }catch(Exception e){ System.out.println(e);}
	
	
	}

}