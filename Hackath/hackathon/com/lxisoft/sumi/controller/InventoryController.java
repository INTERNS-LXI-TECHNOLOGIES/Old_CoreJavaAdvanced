package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*;
import java.util.*;
import java.io.*;
public class InventoryController
{
	private Map<Integer,Product> stock=new HashMap<Integer,Product>();
	private Product productToAdd;
	private Product productToRemove;
	private Product productShopped;
	int i=1;
	Sale sale=new Sale();
	public static int cashInHand;
	public static int balance;
	int quantityToAdd;
	int quantityToRemove;
	int count=1;
	SaleController salectrl=new SaleController();
	public void entry()
	{
		int ch;
		do
		{
			System.out.println("[1.Add Product]\t[2.Display Prduct]\t[3.Sell Product]");
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
					double price,maximumStockLevel;
					String searchkey;
					for(int j=0;j<quantityToAdd;j++)
					{
						System.out.println("Add products");
						System.out.println("[ID:][NAME][PRICE][MaxStock][SearchKey]");
						
						id=ad.nextLong();
						
						name=ad.nextLine();
						price=ad.nextDouble();
						maximumStockLevel=ad.nextDouble();
						searchkey=ad.nextLine();
						productToAdd=new Product(id,name,price,maximumStockLevel,searchkey);
						addStockToInventory(productToAdd,quantityToAdd) ;
					}
				}
				break;
				case 2:
					display();
					break;
				case 3:
					salectrl.displaySellProduct();
	
			}
			System.out.println("Store keeper! do u wanna continue(0/1)");
			ch=input.nextInt();
		}while(ch==1);
		
	}

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
		for(Map.Entry<Integer,Product> entry:stock.entrySet())
		{    
			Product p=entry.getValue(); 
			int key=entry.getKey();  		
			System.out.println(key+" Products:\n");  
			System.out.println(p.id+"  "+p.name+"\nPrice: "+p.price+"\nStocks Available "+p.maximumStockLevel+" \n"); 
			
		}
	}
	public void productSale()
	{
		char ch;
		Scanner input=new Scanner(System.in);
		System.out.println("Cash In Hand");
		cashInHand=input.nextInt();
		do
		{
			System.out.println("[1.Buy Product] [2.View Product]");
			Scanner scanner=new Scanner(System.in);
			int select=scanner.nextInt();
			switch(select)
			{
				case 1:
				{
					if(cashInHand!=0)
					{
						System.out.println("Available Products:\n");
						display();
						System.out.println("Enter the product key value for purchase that product");
						int id=input.nextInt();
						for(Map.Entry<Integer,Product> entry:stock.entrySet())
						{    
							Product p=entry.getValue(); 
							int key=entry.getKey(); 
							if((key==id))
							{	
								if((cashInHand>=p.price))
								{
									
									System.out.println("You purchased the products");
									p.maximumStockLevel--;
									System.out.println(p.id+" "+p.name+"\nPrice: "+p.price+" \n"+p.maximumStockLevel+" \n"); 
									balance=cashInHand-(int) p.price;
									cashInHand=balance;
									System.out.println("Balance available: "+cashInHand);
									long id1=p.id;
									String name=p.name;
									double price=p.price;
									double maximumStockLevel=p.maximumStockLevel;
									String searchkey=p.searchkey;
									productShopped=new Product(id1,name,price,maximumStockLevel,searchkey);
									salectrl.sell(productShopped,count++);
									
								}
							}
						}
					}
					else
					{
						System.out.println("Sorry! In Sufficient Balance.............Thank You ...");
					}
				}
				break;
				case 2:
				{
					Scanner sea=new Scanner(System.in);
					System.out.println("[1.Search product] [2.Display all]");
					int in=sea.nextInt();
					
					switch(in)
					{
						case 1:
						{
							Scanner sear=new Scanner(System.in);
							System.out.println("Enter product name or category");
							String search=sear.nextLine();
							for(Map.Entry<Integer,Product> entry:stock.entrySet())
							{    
								Product p=entry.getValue(); 
								int key=entry.getKey(); 
								if((search==p.searchkey)||(search==p.name))
								{
									System.out.println(key+" Products:\n");  
									System.out.println(p.id+"  "+p.name+"\nPrice: "+p.price+"\nStocks Available "+p.maximumStockLevel+" \n"); 
								}
							}
							System.out.println("Sorry product is not available!");
						}
					
						break;
						case 2:
						display();
						break;
					}
				}	
			}
			System.out.println("Do youwanna Continue the shopping(Y/N)");
			ch=scanner.next().charAt(0);
		}
		while(ch=='Y');					
	}
}