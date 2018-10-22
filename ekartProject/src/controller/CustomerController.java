package controller;

import java.sql.*;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.*;

import connection.Database;
import model.*;

public class CustomerController {

	Customer customer = new Customer();
	Database jdbc = new Database() ;
	private Scanner input=null;
	PreparedStatement prestmt=null;
	Statement stmt=null;
	Connection con;
	boolean validate;

	public void signUp()
	{
		try{ 
			con=jdbc.getConnection();
			stmt=jdbc.getStatement(con);
			String query="insert into customerdetails"+"(username,password,name,phonenumber,email,postcode)"+" values(?,?,?,?,?,?)";
			prestmt=con.prepareStatement(query); 
			input = new Scanner(System.in);
			
			System.out.println("UserName:");
			customer.setUserName(input.nextLine());
			System.out.println("Password:");
			customer.setPassWord(input.nextLine());
			System.out.println("SignUp successfully Completed...\n Enter the Details......");
			
			System.out.println("Name:");
			customer.setName(input.nextLine());			
			System.out.println("Contact Number:");		
			phoneNumberValidation();			
			System.out.println("E-mail:");
			emailValidation();			
			System.out.println("Postcode:");
			postCodeValidation();
			
			prestmt.setString(1,customer.getUserName());
			prestmt.setString(2, customer.getPassWord());
			prestmt.setString(3,customer.getName()); 
			prestmt.setString(4,customer.getPhonenumber()); 
			prestmt.setString(5,customer.getEmail());
			prestmt.setString(6,customer.getPostcode());
			prestmt.executeUpdate();  
			System.out.println("Details of "+customer.getName()+"added Successfully");  
			prestmt.close();
			con.close();
			
		}catch(Exception e){ System.out.println(e);}  	
	}	

	
	public void emailValidation(){
		String email_Regex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"; 
		String email= input.nextLine();
		validate=Pattern.matches(email_Regex,email);
		if (validate==true){
			customer.setEmail(email);
		}
		else{
			System.out.println("Re-enter the Email:");
			emailValidation();
		}
	}
		
	public void phoneNumberValidation(){
	String phone_Regex = "[789][0-9]{9}";
	String phNumber= input.nextLine();
	validate=Pattern.matches(phone_Regex, phNumber);
	if(validate==true){
		customer.setPhoneNumber(phNumber);
	}
	else{
		System.out.println("Re-enter the Contact Number:");
		phoneNumberValidation();	}
	}
		
	public void postCodeValidation(){
		String postcode_Regex="[0-9]{6}";
		String postcode=input.nextLine();
		validate=Pattern.matches(postcode_Regex, postcode);
		if(validate==true){
			customer.setPostcode(postcode);	
		}
		else{
			System.out.println("Can not find the location, Re-enter the postcode:");
			postCodeValidation();}
	}
	
}