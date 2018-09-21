package com.lxisoft.ekart.inventory;
import java.util.HashMap;
import com.lxisoft.ekart.product.Product;

public class Inventory
{
	private HashMap<Product,Integer> stock;
	
	public Inventory()
	{
		stock = new HashMap<Product,Integer>();
	}
	
	public void addStock(Product product,Integer quantity)
	{
		stock.put(product,quantity);
	}
	
	public HashMap<Product,Integer> getStock()
	{
		return stock;
	}
}