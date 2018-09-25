package com.lxisoft.ansal.shop;
import com.lxisoft.ansal.inventory.ProductAnz;
import com.lxisoft.ansal.customer.CustomerAnz;
public class SaleControllerAnz
{
	public double sell(CustomerAnz buyer,ProductAnz productShopped, int quantity)
	{
		System.out.println("Item sold :"+productShopped+"\n"+"Quantity : "+quantity);
		double cost=totalAmount(productShopped,quantity);
		buyer.setCashInHand(buyer.getCashInHand()-cost);
		System.out.println("Total cost : Rs."+cost);
		buyer.addTransaction(cost);
		System.out.println("Cash Remaining : Rs."+buyer.getCashInHand());
		return cost;
	}
	public double totalAmount(ProductAnz productShopped,int quantity)
	{
		return productShopped.getPrice()*quantity;
	}
}
