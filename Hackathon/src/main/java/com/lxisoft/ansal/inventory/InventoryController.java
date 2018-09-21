package com.lxisoft.ansal.inventory;
import java.util.*;
import com.lxisoft.ansal.customer.Customer;
public class InventoryController
{
	Inventory inventoryModel;
	List<Products> inventory;
	
	public InventoryController(Inventory inventoryModel)
	{
		this.inventoryModel=inventoryModel;
		addProducts();
	}
	public void addProducts()
	{
		int count=0;
		Product product=createProduct(count++,"Rice","Eatables",20);
		addStockToInventory(product,3);
		product=createProduct(count++,"TV","Electronics",1500);
		addStockToInventory(product,3);
		product=createProduct(count++,"Hammer","Tools",300);
		addStockToInventory(product,3);
	}
	public Product createProduct(int id,String name,String description)
	{
		return new Product(id,name,description);
	}
	public void addStockToInventory( Product productToAdd, int quantityToadd)
	{
		inventoryModel.getStock().put(productToAdd,quantityToadd);
	}
	public void removeStockFromInventory( Product productToRemove, int quantityToRemove)
	{
		
	}
	public void printStock()
	{
		HashMap<Product,Integer> stock=inventoryModel.getStock();
		count=0;
		for(Map.Entry entry:stock.entrySet())
		{  
			System.out.println(++count+". "+entry.getKey()+"   *"+entry.getValue());  
		}  
	}
	public void getProduct(Customer buyer,int selection,int quantity)
	{
		HashMap<Product,Integer> stock=inventoryModel.getStock();
		List<Product> stockList=new ArrayList<Product>(stock.keySet());
		Product product= stockList.get(selection);
		int available=(int)stock.get(product);
		cost=product.getPrice()*quantity;
		if(quantity<=available&&buyer.getCashInHand()>=cost)
		{
			available-=quantity;
		}
		else
		{
			System.out.println("Out of stock or out of money");
		}
	}
}
