package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*; 
import java.io.*;
import java.util.*;

public class SaleController {
HashMap<Integer,Product> stocksell=new HashMap<Integer,Product>();
List<String> dateList=new ArrayList<String>();
int i=1;
int quantity1;
double totalAmount=0;
public void sell(Product productShopped, int quantity,String date1)
{
	stocksell.put(i,productShopped);
	quantity1=quantity;
	dateList.add(date1);
	i++;
	
	
}

public void totalAmount(double amount)
{
	totalAmount+=amount;
	System.out.println("Total Amount: "+totalAmount);
}
public void displaySellProduct()
{
	for(String str:dateList)
	{
		System.out.println("Stock selled in :  "+str);
	}
	System.out.println("stock sell:  "+quantity1);
	for(Map.Entry<Integer,Product> entry:stocksell.entrySet()){    
		Product p=entry.getValue(); 
		int key=entry.getKey();  		
        System.out.println(key+" Sell Products:\n"); 
        System.out.println(p.id+"  "+p.name+"\nPrice: "+p.price+" \n"); 
		totalAmount(p.price);
		
	}
}
}