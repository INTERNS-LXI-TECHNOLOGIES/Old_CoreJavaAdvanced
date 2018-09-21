package com.lxisoft.sumi;
import com.lxisoft.sumi.model.*;
import com.lxisoft.sumi.controller.*;
import java.io.*;
import java.util.*;
public class ShopSum {

private String shopName ;
private int totalSales ;
//private Inventory inventory ;
public CustomerSum model;
public List<CustomerControllerSum> customers ;
public ShopSum()
{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the Shop Name");
	shopName=input.nextLine();
	System.out.println("Enter the Total number of products");
	totalSales=input.nextInt();
}
//InventoryControllerSum inventorycontroller;
//SaleControllerSum  SaleController ;


public static void main(String args[])
{
	ShopSum shop=new ShopSum();
	System.out.println("Shop Name:"+shop.shopName);
	System.out.println("Total Products available:"+shop.totalSales);
	customers=new ArrayList<CustomerControllerSum>();
	add.customers.add(model.getName());
	add.customers(model.getState());
	add.customers(model.getDistrict());
//Create Shop
//@Create Customers in Shop
//@Create Inventory in Shopp
//@Conduct sale 





}





}
