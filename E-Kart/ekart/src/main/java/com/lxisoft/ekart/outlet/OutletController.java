package com.lxisoft.ekart.outlet;
import com.lxisoft.ekart.warehouse.Warehouse;
import com.lxisoft.ekart.customer.Customer;
public class OutletController
{
	private Outlet outlet;

	public OutletController(Warehouse warehouse,Customer customer)
	{
		System.out.println("\n\n*******************************************");
		System.out.println("Welcome To StoreFront");
		outlet=new Outlet();
		outlet.setWarehouse(warehouse);
		outlet.setCustomer(customer);
	}
	public Outlet getOutlet()
	{
		return outlet;
	}
	public void receivePayment(String method)
	{
		if(!method.equals("success"))
		{
			System.out.println("Payment received from card number :"+method);
		}
		System.out.println("Thank you for shopping.....");
	}
}