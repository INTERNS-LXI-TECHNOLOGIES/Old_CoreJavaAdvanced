package com.lxisoft.deepthi.controller;
import com.lxisoft.deepthi.model.*;
import java.util.Date;
import java.text.DateFormat;


public class SaleControllerDee 
{

public void sell(ProductDee productShopped, int quantity)
	{	Date date= new Date();
		//DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println(date+"\n\nItem sold :"+productShopped+"\n"+"Quantity : "+quantity);
		double cost=totalAmount(productShopped,quantity);
		System.out.println("Total cost : "+cost);
	}
	public double totalAmount(ProductDee productShopped,int quantity)
	{
		return productShopped.getPrice()*quantity;
	}







}