package com.lxisoft.ekart.warehouse;
import java.util.HashMap;
import com.lxisoft.ekart.product.Product;
public class Warehouse
{
	private HashMap<Product,Integer> stock;

	public Warehouse() 
	{
		stock= new HashMap<Product,Integer>();
	}
	public HashMap<Product,Integer> getStock()
	{
		return stock;
	}
}