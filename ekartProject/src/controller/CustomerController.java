package controller;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.*;

import model.*;

public class CustomerController {

	Customer customer = new Customer();
	private Scanner input=null;
	private PreparedStatement stmt=null;
	Connection con=null;
	boolean validate;

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
			String query1="insert into customerdata"+"(name,phoneNumber,email,postcode)"+" values(?,?,?,?)";
			stmt=con.prepareStatement(query1); 
			input = new Scanner(System.in);
			
						
			System.out.println("Name:");
			String name  = input.nextLine();
			System.out.println("Contact Number:");
			String phNumber= input.nextLine();
			phoneNumberValidation(phNumber);
			
			System.out.println("E-mail:");
			String email= input.nextLine();
			emailValidation(email);
			
			System.out.println("Postcode:");
			String postcode=input.nextLine();
			postCodeValidation(postcode);
			
			stmt.setString(1,name);//1 specifies the first parameter in the query  
			stmt.setString(2,customer.getPhonenumber()); 
			stmt.setString(3,email);
			stmt.setString(4,postcode);
			stmt.executeUpdate(); 
			stmt.close();
			con.close();
		}
		catch(Exception e){System.out.println(e);}
		System.out.println("Start Purchasing.......");
	}		

	
	public void emailValidation(String email){
		String email_Regex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"; 
		validate=Pattern.matches(email_Regex,email);
		if (validate==true){
			customer.setEmail(email);
		}
		else{
			System.out.println("Re-enter the Email:");
			customer.setEmail(input.nextLine());
		}
	}
	
	public void phoneNumberValidation(String phNumber){
	String phone_Regex = "[789][0-9]{9}";
	validate=Pattern.matches(phone_Regex, phNumber);
	if(validate==true){
		customer.setPhoneNumber(phNumber);
	}
	else{
		System.out.println("Re-enter the Contact Number:");
		customer.setPhoneNumber(input.nextLine());	}
	}
	
	public void postCodeValidation(String postcode){
		String postcode_Regex="[0-9]{6}";
		validate=Pattern.matches(postcode_Regex, postcode);
		if(validate==true){
			customer.setPostcode(postcode);	
		}
		else{
			System.out.println("Can not find the location, Re-enter the postcode:");
			customer.setPostcode(input.nextLine());}
	}
	
}