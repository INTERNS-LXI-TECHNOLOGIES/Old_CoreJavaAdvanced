package com.lxisoft.ansal.inventory;
import java.util.*;
import java.sql.*;
public class InventoryControllerAnz
{
	InventoryAnz inventoryModel;
	List<ProductAnz> inventory;
	
	public InventoryControllerAnz(InventoryAnz inventoryModel)
	{
		this.inventoryModel=inventoryModel;
		addProducts(getAllProducts());
	}
	public ResultSet getAllProducts()
	{
		Connection con=getConnection();
		Statement stmt=getStatement(con);
		String query="select * from product";
		return getResultSet(query,stmt);
	}
	public void addProducts(ResultSet result)
	{
		try
		{
			while(result.next())
			{
				int id=result.getInt("id");
				String name=result.getString("name");
				String description=result.getString("category");
				double price=result.getInt("unitprice");
				int available=result.getInt("stock");
				ProductAnz product= new ProductAnz(id,name,description,price);
				inventoryModel.addProductAndStock(product,available);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();	
		}
	}
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront","root","root");
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
			return null;
	}
	public Statement getStatement(Connection con)
	{
		try
		{
			if(con!=null)
				return con.createStatement();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
			return null;
	}
	public ResultSet getResultSet(String query,Statement stmt)
	{
		try
		{
			if(stmt!=null)
				return stmt.executeQuery(query);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
			return null;
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
			System.out.println("\n"+(++count)+". "+entry.getKey()+"\n\tStock: "+entry.getValue()+"\n\tUnit price:Rs."+((ProductAnz)entry.getKey()).getPrice());  
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
