package com.lxisoft.ekart.warehouse;
import com.lxisoft.ekart.product.Product;
import com.lxisoft.ekart.dao.DAO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
public class WarehouseController
{
	private Warehouse warehouse;

	public WarehouseController(Warehouse warehouse)
	{
		this.warehouse=warehouse;
	}
	public ResultSet getAllProducts()
	{
		Connection con=DAO.getConnection();
		Statement stmt=DAO.getStatement(con);
		String query="select * from product";
		try
		{
			return DAO.getResultSet(query,stmt);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			return null;
		}
	}
	public void addProducts(ResultSet result)
	{
		try
		{
			while(result.next())
			{
				String name=result.getString("name");
				String category=result.getString("category");
				double price=result.getInt("unitprice");
				int available=result.getInt("stock");
				Product product= new Product(name,category,price);
				addStock(product,available);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();	
		}
	}
	
	public void addStock( Product productToAdd, int quantityToadd)
	{
		warehouse.getStock().put(productToAdd,quantityToadd);
	}
	public void removeStock( Product productToRemove, int quantityToRemove)
	{
		int availableQuantity=(int)(warehouse.getStock().get(productToRemove));
		availableQuantity-=quantityToRemove;
		if(availableQuantity==0)
		{
			warehouse.getStock().remove(productToRemove);
		}
		else
		{
			warehouse.getStock().put(productToRemove,availableQuantity);
		}
	}
	public void printStock()
	{
		HashMap<Product,Integer> stock=warehouse.getStock();
		int count=0;
		for(Map.Entry entry:stock.entrySet())
		{  
			System.out.println("\n"+(++count)+". "+entry.getKey()+"\n\tStock: "+entry.getValue()+"\n\tUnit price:Rs."+((Product)entry.getKey()).getPrice());  
		}  
	}
	public Product getProduct(int selection,int quantity)
	{
		HashMap<Product,Integer> stock=warehouse.getStock();
		List<Product> productList=new ArrayList<Product>(stock.keySet());
		Product product= productList.get(selection-1);
		if(isAvailable(product,quantity))
		{
			return product;
		}
		else 
		{
			System.out.println("Sorry, the quantity you selected is not currently available.");
			return null;
		}
	}
	public boolean isAvailable(Product product, int quantity)
	{
		int availableQuantity=(int)(warehouse.getStock().get(product));
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