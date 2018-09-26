package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*;
import java.util.*;
import java.io.*;
public class InventoryController{
	private Map<Integer,Product> stock=new HashMap<Integer,Product>();
	private Product productToAdd;
	private Product productToRemove;
	int i=1;
	Sale sale=new Sale();
	public static int cashInHand;
	public static int balance;
	int quantityToAdd;
	int quantityToRemove;
	public void entry()
	{
		int ch;
		do
		{
		System.out.println("[1.AddProduct]\t[2.displayPrduct]");
		Scanner input=new Scanner(System.in);
		int option=input.nextInt();
		switch(option)
		{
			case 1:
			{
				System.out.println("Enter quanity");
				Scanner ad=new Scanner(System.in);
				quantityToAdd=ad.nextInt();
				long id;
				String name;
				int price,maximumStockLevel;
				String searchkey;
				for(int j=0;j<quantityToAdd;j++)
				{
				System.out.println("Add products");
				id=ad.nextInt();
				name=ad.nextLine();
				price=ad.nextInt();
				maximumStockLevel=ad.nextInt();
				searchkey=ad.nextLine();
				productToAdd=new Product(id,name,price,maximumStockLevel,searchkey);
				addStockToInventory(productToAdd,quantityToAdd) ;
				}
			}
		
		/**for(Map.Entry<Integer,Product> entry:stock.entrySet()){    
        Product p=entry.getValue(); 
		int key=entry.getKey();  		
        System.out.println(key+" Products:\n");  
        System.out.println(p.id+" "+p.name+"\nPrice: "+p.price+"\nStocks Available "+p.maximumStockLevel+" \n"); 
	    
	}*/
		
			break;
			case 2:
			display();
			break;
			case 3:exit();
	
		}
		System.out.println("do u wanna continue(0/1)");
		ch=input.nextInt();
		}while(ch==1);
		
	}
//	public void entry()
	//{
		
		//System.out.println("");
		//List<Product> addProduct=new ArrayList<Product>();

		
		
		
    //} 
	public void addStockToInventory(Product productToAdd,int quantityToAdd)
	{
		
		stock.put(i,productToAdd);
				i++;
		
		
	}
		
	public void removeStockFromInventory( Product productToRemove,int quantityToRemove)
	{
		
	}
	public void exit()
	{
		
	}
	public void display()
	{
		for(Map.Entry<Integer,Product> entry:stock.entrySet()){    
			Product p=entry.getValue(); 
		int key=entry.getKey();  		
        System.out.println(key+" Products:\n");  
        System.out.println(p.id+" "+p.name+"\nPrice: "+p.price+"\nStocks Available "+p.maximumStockLevel+" \n"); 
	    
	}
	}
	public void productSale()
	{
		Scanner input=new Scanner(System.in);
		            System.out.println("Cash In Hand");
					cashInHand=input.nextInt();
					System.out.println("Available Products:\n");
					display();
					System.out.println("Enter the product key value for purchase that product");
					int id=input.nextInt();
					for(Map.Entry<Integer,Product> entry:stock.entrySet()){    
						Product p=entry.getValue(); 
					int key=entry.getKey(); 
					if((key==id))
					{	
					if((cashInHand>=p.price))
					{
					System.out.println("You purchased the products");
					//System.out.println(key+" Products:\n");
					p.maximumStockLevel--;
					System.out.println(p.id+" "+p.name+"\nPrice: "+p.price+" \n"+p.maximumStockLevel+" \n"); 
					balance=cashInHand-(int) p.price;
					System.out.println("Balance available:"+balance);
					
					}
					}
					}
		//System.out.println(custom.cashInHand);
		
    }
	}
	
			

