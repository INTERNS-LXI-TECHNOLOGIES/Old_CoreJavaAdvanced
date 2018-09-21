package com.lxisoft.ansal.shop;
import com.lxisoft.ansal.inventory.InventoryAnz;
import com.lxisoft.ansal.inventory.InventoryControllerAnz;
import com.lxisoft.ansal.customer.CustomerAnz;
import com.lxisoft.ansal.inventory.ProductAnz;
import java.util.*;

public class ShopAnz
{
	String shopName ;
	InventoryAnz inventory ;
	double totalSales ;
	List<CustomerAnz> customers ;
	InventoryControllerAnz inventoryController;
	SaleControllerAnz  saleController ;

	public ShopAnz()
	{
		shopName="StoreFront";
		customers=new ArrayList<CustomerAnz>();
		totalSales=0;
		//@Create InventoryAnz in Shopp
		inventory=new InventoryAnz();
		inventoryController=new InventoryControllerAnz(inventory);
		saleController=new SaleControllerAnz();
		//@Conduct sale 
		startSale();
	}
	public void startSale()
	{
		System.out.print("Number of customers : ");
		Scanner in=new Scanner(System.in);
		int numOfCustomers=in.nextInt();
		while(numOfCustomers>0)
		{
			CustomerAnz buyer=readCustomerDetails();
			customers.add(buyer);
			numOfCustomers--;		
			inventoryController.printStock();
			System.out.print("Select product and quantity : ");
			int selection=in.nextInt();
			int quantity=in.nextInt();
			ProductAnz product=inventoryController.getProduct(selection,quantity);
			double cost=product.getPrice()*quantity;
			if(buyer.getCashInHand()>=cost)
			{
				saleController.sell(product,quantity);
				inventoryController.changeStock(product,quantity);
				buyer.setCashInHand(buyer.getCashInHand()-cost);
				totalSales+=cost;
			}
			else
			{
				System.out.println("Sorry you are out of money");
			}
		}
	}
	public CustomerAnz readCustomerDetails()
	{
		CustomerAnz buyer=new CustomerAnz();
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Name of customer : ");
		buyer.setName(in.nextLine());
		System.out.print("Enter affordable amount : ");
		buyer.setCashInHand(in.nextInt());
		return buyer;
	}
}