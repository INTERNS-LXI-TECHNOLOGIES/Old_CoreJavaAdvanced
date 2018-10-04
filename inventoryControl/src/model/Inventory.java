package model;
import java.util.HashMap;

public class Inventory {

private HashMap<Product,Integer> stock;
	
	public Inventory()
	{
		stock = new HashMap<Product,Integer>();
	}
	
	public HashMap<Product,Integer> getStock()
	{
		return stock;
	}
}
