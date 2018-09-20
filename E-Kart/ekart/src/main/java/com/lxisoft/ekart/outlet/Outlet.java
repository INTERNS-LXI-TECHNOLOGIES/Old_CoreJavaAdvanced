package com.lxisoft.ekart.outlet;
import com.lxisoft.ekart.warehouse.Warehouse;
import com.lxisoft.ekart.customer.Customer;
public class Outlet
{
	private Warehouse warehouse;
	private Customer customer;

	public Outlet()
	{
		warehouse=new Warehouse();
		customer=new Customer();
	}
	public Warehouse getWarehouse()
	{
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse)
	{
		this.warehouse=warehouse;
	}
	public void setCustomer(Customer customer)
	{
		this.customer=customer;
	}
	public Customer getCustomer()
	{
		return customer;
	}
}