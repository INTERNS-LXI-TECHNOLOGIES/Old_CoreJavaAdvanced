package controller;

import java.io.*;
import java.util.*;

public class ShopController {
	
	CustomerController customerController ;
	InventoryController inventoryController = new InventoryController();
	Scanner in;
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
		System.out.println("****WELCOME****\n START PURCHASING...........\n");
		inventoryController.displayStock();
		System.out.println("[1.SIGN UP]  [2.LOGIN] [3.SIGN IN AS STOREKEEPER]");
		in= new Scanner(System.in);		
		int key=in.nextInt();
		
		switch(key)
		{
		
		case 1:customerController.signUp();
		inventoryController.displayStock();
		break;
		//case 2:customerController.login();
	//	break;
		case 3:inventoryController.signIn();
		break;
	//	default: //co.collegeHome();	
		}
	}
	
}
