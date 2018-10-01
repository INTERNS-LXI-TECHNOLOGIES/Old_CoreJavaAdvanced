package com.lxisoft.sumi;
import com.lxisoft.sumi.controller.*;
import com.lxisoft.sumi.model.*;
import java.io.*;
import java.util.*;
class Shop {

	String shopName ;
	public static InventoryController inventory=new InventoryController();
	int totalSales;
	public static SaleController  sale;

	public static CustomerController customer;
	Properties p=new Properties();
	public Shop()
	{
		try
		{
			FileReader fr=new FileReader("configuration");
			p.load(fr);
			System.out.println(p.getProperty("ShopName")+"\nAddress: "+p.getProperty("Street")+"\n\t "+p.getProperty("District")+"\n\t "+p.getProperty("State")+"\n\t "+p.getProperty("Country"));
		}
	catch(IOException e)
	{
		System.out.println("Error");
	}		
	}



public static void main(String args[]){

	Shop shop=new Shop();

	int ch;
		do
		{
		System.out.println("[1.Customer]\t[2.Store Keeper]");
		Scanner input=new Scanner(System.in);
		int option=input.nextInt();
		switch(option)
		{
			case 1:
					customer=new CustomerController();
					inventory.productSale();
					break;
				case 2:
					inventory.entry();
			break;
			
		}
		System.out.println("do u wanna continue(0/1)");
		ch=input.nextInt();
		}while(ch==1);






}




}
