package controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import model.Customer;

public class ShopController {
	
	CustomerController customerController ;
	InventoryController inventoryController = new InventoryController();
	private Scanner in=null;
	private PreparedStatement stmt=null;
	Connection con=null;
	String username,password;
	char c;
	public ShopController() throws IOException
	{
		try
		{
		// TODO Auto-generated constructor stub
		Properties p = new Properties();
		 Date date = new Date();
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);	 
		 System.out.println(date.toString());	
		p.setProperty("shopName","E-Kart");
		p.setProperty("Addrss","V building\n ABCD\n India");
		p.setProperty("ContactNumber","+91-9536649459");
		p.setProperty("E-mail","ekart@abc.com");
		p.store(new FileWriter("configuration"),"Details");
		FileReader reader=new FileReader("configuration");
		p.load(reader);
		System.out.println(p.getProperty("shopName"));
		System.out.println(p.getProperty("ContactNumber"));
		System.out.println(p.getProperty("E-mail"));
		customerController = new CustomerController();
		home();			 
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	public void home(){
		System.out.println("****WELCOME****\n ");
		System.out.println("[1.SIGN UP]  [2.LOGIN] [3.SIGN IN AS STOREKEEPER]");
		in= new Scanner(System.in);		
		int key=in.nextInt();
		
		switch(key)
		{
		
		case 1:customerController.signUp();
			buyProduct();
		break;
		case 2:customerLogin();
			buyProduct();
		break;
		case 3:inventoryController.inventoryManagerSignIn();
		inventoryController.displayStock();
		break;
		default:home();	
		}
	}
	
	public void customerLogin(){
		try {
		in = new Scanner(System.in);
		System.out.println("Username:");
		username=in.nextLine();
		
		System.out.println("Password:");
		password= in.nextLine();

		Class.forName("com.mysql.jdbc.Driver");	
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
		//PreparedStatement prestmt=con.prepareStatement();
		String query="select * from signUp "+"where username=? and password=?";
		stmt=con.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs=stmt.executeQuery(); 
				//while(rs.next()) 
			if(rs.next()){
				
			System.out.println("Login  successfully..... Continue purchasing.....");
			buyProduct();
		}
			else{
				System.out.println("Login Failesd.... Invalid username or password");
		}
		}catch(Exception e){System.out.println(e);
		}
		}

	public void buyProduct(){
		inventoryController.displayStock();
		in= new Scanner(System.in);
		inventoryController.productSale();
		System.out.println("Want to continue purchasing Y/N");
		c=in.next().charAt(0);
		if(c=='Y'){
			inventoryController.displayStock();
			inventoryController.productSale();		
		}
		else{
			home();
		}
	}
	
}
