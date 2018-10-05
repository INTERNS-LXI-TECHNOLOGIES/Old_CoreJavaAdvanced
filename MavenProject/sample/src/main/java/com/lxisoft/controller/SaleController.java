package com.lxisoft.controller;
import com.lxisoft.model.*; 
import java.io.*;
import java.util.*;
public class SaleController {
HashMap<Integer,Product> stocksell=new HashMap<Integer,Product>();
int i=1;
int quantity1;
double totalAmount=0;
public void sell(Product productShopped, int quantity)
{
	stocksell.put(i,productShopped);
	quantity1=quantity;
	i++;
	
}

public void totalAmount(double amount)
{
	totalAmount+=amount;
	System.out.println("Total Amount: "+totalAmount);
}
public void displaySellProduct()
{
	
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