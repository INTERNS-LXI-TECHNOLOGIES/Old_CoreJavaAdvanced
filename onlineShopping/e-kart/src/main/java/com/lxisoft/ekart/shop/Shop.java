package com.lxisoft.ekart.shop;
import com.lxisoft.ekart.customer.Customer;
import com.lxisoft.ekart.inventory.Inventory;

public class Shop
{
	private Customer customer;
	private Inventory inventory;
	
	public Shop()
	{
		customer = new Customer();
		inventory = new Inventory();
	}
	
	public void setCustomer(Customer customer)
    {
		this.customer = customer;
	}	
	
	public Customer getCustomer()
	{
		return customer;
	}
	
	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory;
	}
	
	public Inventory getInventory()
	{
		return inventory;
	}
}