package com.lxisoft.ansal.inventory;
import java.util.*;
public class Inventory
{
	private HashMap<Product,Integer> stock;
	
	public Inventory()
	{
		stock=new HashMap<Product,Inetger>();
	}
	public HashMap<Product,Integer> getStock()
	{
		return stock;
	}
}