package controller;

import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import connection.*;

public class ShopController {
	
	CustomerController customerController ;
	InventoryController inventoryController = new InventoryController();
	private Scanner in=null;
	Database jdbc = new Database();
	PreparedStatement prestmt=null;
	Connection con;
	Statement stmt ;
	Properties p ;
	
	char c;
	
	public ShopController() throws IOException
	{
		try
		{
		p= new Properties();
		 Date date = new Date();
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);	 
		 System.out.println(date.toString());	
		p.setProperty("shopName","E-Kart");
		p.setProperty("Addrss","V building\n ABCD\n India");
		p.setProperty("ContactNumber","+91-9536649459");
		p.setProperty("E-mail","ekart@abc.com");
		p.setProperty("password","12345");
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
		inventoryController.productSale();
		break;
		case 2:customerLogin();
			inventoryController.productSale();
		break;
		case 3:storekeeperLogin();
		break;
		default:home();	
		}
	}
	

	
	public void customerLogin() {
		
	    in= new Scanner(System.in);
	    String username,password,username1,password1;
		System.out.println("*****LOGIN******\n");
		System.out.println("Username: ");
		username = in.nextLine();
		System.out.println("Password");
		password=in.nextLine();
		boolean value=false;
		try{
			con=jdbc.getConnection();
			stmt=jdbc.getStatement(con);
			String query="select * from customerdetails";
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				username1=rs.getString(1);
				//System.out.println(username1);
				password1=rs.getString(2);
				if(username.equals(username1))
				{
					if(password.equals(password1))
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
				//inventory.productSale();
			}
			else
			{
				System.out.println("Incorrect email\nplss.......re-enter the email and password");
				customerLogin();
			}
		}catch(Exception e){System.out.println(e);
		}
	}
		
		public void storekeeperLogin() {
			
		    in= new Scanner(System.in);
		    String email1,password1;
			System.out.println("*****LOGIN******\n");
			System.out.println("Email: ");
			email1 = in.nextLine();
			System.out.println("Password");
			password1=in.nextLine();
			//boolean value=false;
			
			FileReader reader;
			try {
				reader = new FileReader("configuration");		
			p.load(reader);
			//String pass=p.getProperty("password");
			//String mail=p.getProperty("email");

			//System.out.println(p.getProperty("password"));
						if(password1==p.getProperty("password"))
						{
							
							System.out.println("login success......");
							inventoryController.inventoryManager();
						}
						else
						{
							System.out.println("Incorrect password");
						}
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					
		}
		

		}
}
