package com.lxisoft.ansal.shop;
import com.lxisoft.ansal.inventory.Inventory;
import com.lxisoft.ansal.inventory.InventoryController;
import com.lxisoft.ansal.customer.Customer;
import java.util.*;

public class Shop implements SaleController,InventoryController
{
	String shopName ;
	Inventory inventory ;
	int totalSales ;
	List<Customer> customers ;
	InventoryController inventoryController;
	SaleController  saleController ;

	public Shop()
	{
		shopName="StoreFront";
		customers=new ArrayList<Customer>();
		totalSales=0;
		//@Create Inventory in Shopp
		inventory=new Inventory();
		inventoryController=new InventoryController(Inventory);
		saleController=new SaleController();
		//@Conduct sale 
		startSale();
	}
	public void startSale()
	{
		System.out.print("Number of customers : ");
		Scanner in=new Scanner(System.in);
		numOfCustomers=in.readLine();
		while(numOfCustomers>=0)
		{
			Customer buyer=readCustomerDetails();
			customers.add(buyer);
			numOfCustomers--;		
			inventoryController.printStock();
			System.out.print("Select product and quantity : ");
			Scanner in=new Scanner(System.in);
			inventoryController.getProduct(buyer,in.nextInt(),in.nextInt());
		}
	}
	public Customer readCustomerDetails()
	{
		Customer buyer=new Customer();
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Name of customer : ");
		buyer.setName(in.nextLine());
		System.out.print("Enter affordable amount : ");
		buyer.setCashInHand(in.nextInt());
		return buyer;
	}
}