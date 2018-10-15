package com.lxisoft.ekart.EKart.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.lxisoft.ekart.EKart.connection.*;

import com.lxisoft.ekart.EKart.model.Customer;

public class CustomerController {

	DataConnection jdbc=new DataConnection();
	InventoryController inventory=new InventoryController();
	Customer model=new Customer();
	Scanner scan=new Scanner(System.in);
	String pin,phno,email,pass;
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	public void signup(){
		try{
			
			con=jdbc.getConnection();
			String query="insert into customer"+"(fname,address,pin,phno,email,pass)"+"values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			System.out.println("Enter your details");
			System.out.println("Full Name:");
			model.setName(scan.nextLine());
			System.out.println("Address");
			model.setAddress(scan.nextLine());
			System.out.println("Pincode");
			validatePincode();
			System.out.println("PhoneNumber");
			validatePhone();
			System.out.println("Email");
			validateEmail();
			System.out.println("Password");
			pass=scan.nextLine();
			model.setPassword(pass);
			System.out.println("Confirm Password");
			
			checkPassword();
			pstmt.setString(1, model.getName());
			pstmt.setString(2, model.getAddress());
			pstmt.setString(3, model.getPincode());
			pstmt.setString(4, model.getPhno());
			pstmt.setString(5, model.getEmail());
			pstmt.setString(6, model.getPassword());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			login();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void checkPassword() {
		String conpass=scan.nextLine();
		if(pass.equals(conpass))
		{
			System.out.println("Signup success");
		}
		else{
			System.out.println("password mismatched..\nReenter confirm password");
			checkPassword();
		}
		
	}
	public void login() {
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
			String query="select * from customer";
			stmt=con.createStatement();
		//	pstmt.setString(1,email);
		//	pstmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				email1=rs.getString(5);
				pass1=rs.getString(6);
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
				System.out.println("login success......");
				inventory.productSale();
			}
			else
			{
				System.out.println("Incorrect email\nplss.......re-enter the email and password");
				login();
			}
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void validateEmail() {
		String MAIL_REGEX="\\b[\\w.%-]+@[A-Za-z]+\\.[A-Za-z]{2,3}";
		email=scan.nextLine();
		boolean validmail=Pattern.matches(MAIL_REGEX, email);
		if(validmail==true)
		{
			model.setEmail(email);
		}
		else
		{
			System.out.println("Email format is incorrect.....\n Re-Enter the emailr");
			validateEmail();
			
		}
		
	}
	private void validatePhone() {
		
		String PH_REGEX="[6789][0-9]{9}";
		phno=scan.nextLine();
		boolean validph=Pattern.matches(PH_REGEX,phno);
		if(validph==true)
		{
			model.setPhno(phno);
		}
		else
		{
			System.out.println("Phone Number format is incorrect.....\n Re-Enter the number");
			validatePhone();
			
		}
		
	}
	public void validatePincode(){
		String PIN_REGEX="[0-9]{6}";
		pin=scan.nextLine();
		boolean validpin=Pattern.matches(PIN_REGEX,pin);
		if(validpin==true)
		{
			model.setPincode(pin);
		}
		else
		{
			System.out.println("pincode format is incorrect.....\n Re-Enter the pincode");
			validatePincode();
			
		}
	}
}
