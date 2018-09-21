package com.lxisoft.ansal.inventory;
import java.util.*;
public class InventoryAnz
{
	private HashMap<ProductAnz,Integer> stock;
	
	public InventoryAnz()
	{
		stock=new HashMap<ProductAnz,Integer>();
	}
	public HashMap<ProductAnz,Integer> getStock()
	{
		return stock;
	}
}