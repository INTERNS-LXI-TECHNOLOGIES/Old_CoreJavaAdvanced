package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import model.*;

public class CustomerController {

	Customer customer = new Customer();
	private Scanner input=null;
	private PreparedStatement stmt=null;
	Connection con=null;

	public void signUp()
	{
		try{ 
			
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
			String query="insert into signup"+"(username,password)"+" values(?,?)";
			stmt=con.prepareStatement(query); 
			input = new Scanner(System.in);
			System.out.println("UserName:");
			String username  = input.nextLine();
			System.out.println("Password:");
			String password = input.nextLine();
			
			stmt.setString(1,username);//1 specifies the first parameter in the query  
			stmt.setString(2,password);  
			   
			stmt.executeUpdate();  
			System.out.println("SignUp successfully Completed...\n Enter the Details......");  
			stmt.close();
			con.close();
			addCustomerDetails();
		}catch(Exception e){ System.out.println(e);}  	
	}	
	public void addCustomerDetails(){
		try{
			Class.forName("com.mysql.jdbc.Driver");  	

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
		String query="insert into customerdata"+"(name,phoneNumber,email,postcode)"+" values(?,?,?,?)";
		stmt=con.prepareStatement(query); 
		input = new Scanner(System.in);
		System.out.println("Name:");
		String name  = input.nextLine();
		System.out.println("Contact Number:");
		String phoneNumber= input.nextLine();
		System.out.println("E-mail:");
		String email= input.nextLine();
		System.out.println("Postcode:");
		String postcode=input.nextLine();
		
		stmt.setString(1,name);//1 specifies the first parameter in the query  
		stmt.setString(2,phoneNumber); 
		stmt.setString(3,email);
		stmt.setString(4,postcode);
		}
		catch(Exception e){System.out.println(e);}
		System.out.println("Start Parchasing.......");
	}
}
