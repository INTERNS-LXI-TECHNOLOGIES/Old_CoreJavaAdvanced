package com.lxisoft.ansal.shop;
import com.lxisoft.ansal.inventory.ProductAnz;
public class SaleControllerAnz
{
	public void sell(ProductAnz productShopped, int quantity)
	{
		System.out.println("Item sold :"+productShopped+"\n"+"Quantity : "+quantity);
		double cost=totalAmount(productShopped,quantity);
		System.out.println("Total cost : "+cost);
	}
	public double totalAmount(ProductAnz productShopped,int quantity)
	{
		return productShopped.getPrice()*quantity;
	}
}
