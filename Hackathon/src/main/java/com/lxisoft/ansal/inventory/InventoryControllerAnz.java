package com.lxisoft.ansal.inventory;
import java.util.*;
public class InventoryControllerAnz
{
	InventoryAnz inventoryModel;
	List<ProductAnz> inventory;
	
	public InventoryControllerAnz(InventoryAnz inventoryModel)
	{
		this.inventoryModel=inventoryModel;
		addProducts();
	}
	public void addProducts()
	{
		int count=0;
		ProductAnz product=createProduct(count++,"Rice","Eatables",20);
		addStockToInventory(product,3);
		product=createProduct(count++,"TV","Electronics",1500);
		addStockToInventory(product,3);
		product=createProduct(count++,"Hammer","Tools",300);
		addStockToInventory(product,3);
	}
	public ProductAnz createProduct(int id,String name,String description,double price)
	{
		return new ProductAnz(id,name,description,price);
	}
	public void addStockToInventory( ProductAnz productToAdd, int quantityToadd)
	{
		inventoryModel.getStock().put(productToAdd,quantityToadd);
	}
	public void removeStockFromInventory( ProductAnz productToRemove, int quantityToRemove)
	{
		int availableQuantity=(int)(inventoryModel.getStock().get(productToRemove));
		availableQuantity-=quantityToRemove;
		inventoryModel.getStock().put(productToRemove,availableQuantity);
	}
	public void printStock()
	{
		HashMap<ProductAnz,Integer> stock=inventoryModel.getStock();
		int count=0;
		for(Map.Entry entry:stock.entrySet())
		{  
			System.out.println(++count+". "+entry.getKey()+"   *"+entry.getValue());  
		}  
	}
	public ProductAnz getProduct(int selection,int quantity)
	{
		HashMap<ProductAnz,Integer> stock=inventoryModel.getStock();
		inventory=new ArrayList<ProductAnz>(stock.keySet());
		ProductAnz product= inventory.get(selection-1);
		if(isAvailable(product,quantity))
		{
			return product;
		}
		else 
		{
			return null;
		}
	}
	public boolean isAvailable(ProductAnz product, int quantity)
	{
		int availableQuantity=(int)(inventoryModel.getStock().get(product));
		if(quantity<=availableQuantity)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
