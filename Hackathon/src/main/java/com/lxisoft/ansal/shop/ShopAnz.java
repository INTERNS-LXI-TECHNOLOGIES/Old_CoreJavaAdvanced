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
		initSale();
	}
	public void initSale()
	{
		System.out.print("Number of customers : ");
		Scanner in=new Scanner(System.in);
		int numOfCustomers=in.nextInt();
		while(numOfCustomers>0)
		{
			CustomerAnz buyer=readCustomerDetails();
			customers.add(buyer);
			startSale();
			numOfCustomers--;		
        }
    }
    public void startSale()
    {
		do
		{
			inventoryController.printStock();
     		Map.Entry<ProductAnz,Integer>selection=getSelection();
     		ProductAnz product=selection.getKey();
     		int quantity=selection.getValue();
     		Scanner in=new Scanner(System.in);
			if(product!=null)
			{
				double cost=product.getPrice()*quantity;
				CustomerAnz buyer=customers.get(customers.size()-1);
				if(buyer.getCashInHand()>=cost)
				{
					totalSales+=saleController.sell(buyer,product,quantity);
					inventoryController.removeStockFromInventory(product,quantity);
				}
				else
					System.out.println("Sorry you are out of money");
			}
			else
				System.out.println("Sorry out of stock");
			if(continueShopping())
				continue;
			else
				break;
		}while(true);
	}
	public Map.Entry<ProductAnz,Integer> getSelection()
	{
		System.out.print("Select product and quantity : ");
  		Scanner in=new Scanner(System.in);
		int selection=in.nextInt();
		int quantity=in.nextInt();
		HashMap<ProductAnz,Integer> selected=new HashMap<ProductAnz,Integer>();
		selected.put(inventoryController.getProduct(selection,quantity),quantity);
		return selected.entrySet().iterator().next();
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
	public boolean continueShopping()
	{
		System.out.println("continue shopping? (y/n) :");
     	Scanner in=new Scanner(System.in);
		if(in.nextLine().equals("y"))
			return true;
		else
			return false;
	}
}