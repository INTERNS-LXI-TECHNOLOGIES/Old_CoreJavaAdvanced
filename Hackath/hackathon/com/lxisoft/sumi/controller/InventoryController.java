package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*;
import java.util.*;
import java.io.*;
public class InventoryController{
	private Map<Integer,Product> stock;
	private Product product1;
	private Product product2;
	private Product product3;
	private Product product4;
	private Product productToAdd;
	private Product productToRemove;
	int i=5;
	Sale sale=new Sale();
	public InventoryController()
	{
		stock=new HashMap<Integer,Product>();
		product1=new Product(101,"TV",22000,10,"Electronics");
		product2=new Product(102,"Fridge",82000,20,"Electronics");
		product3=new Product(103,"Saree",2000,60,"Ladies Wear");
		product4=new Product(104,"Shirt",1000,40,"Mens Wear");
		stock.put(1,product1);
		stock.put(2,product2);
		stock.put(3,product3);
		stock.put(4,product4);
		for(Map.Entry<Integer,Product> entry:stock.entrySet()){    
        Product p=entry.getValue(); 
		int key=entry.getKey();  		
        System.out.println(key+" Products:\n");  
        System.out.println(p.id+" "+p.name+"\nPrice: "+p.price+"\nStocks Available "+p.maximumStockLevel+" \n"); 
	    
	}
	}
	public void entry()
	{
		
		//System.out.println("");
		//List<Product> addProduct=new ArrayList<Product>();
		int quantityToAdd;
		int quantityToRemove;
		
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
	public void productSale(Customer model)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the product key value for purchase that product");
		int id=input.nextInt();
		for(Map.Entry<Integer,Product> entry:stock.entrySet()){    
			Product p=entry.getValue(); 
		int key=entry.getKey(); 
        if((key==id))
		{	
		if((model.getCashInHand()>=p.price))
		{
		System.out.println("You purchased the products");
        //System.out.println(key+" Products:\n");
		p.maximumStockLevel--;
        System.out.println(p.id+" "+p.name+"\nPrice: "+p.price+" \n"+p.maximumStockLevel+" \n"); 
	    }
		}
		else
		{
		
		}
    }
	}
	
			

}
