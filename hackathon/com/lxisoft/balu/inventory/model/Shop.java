package com.lxisoft.balu.inventory.model;

import com.lxisoft.balu.inventory.controller.*;
import com.lxisoft.balu.inventory.model.*; 
import java.util.*;


public class Shop {

//String shopName ;
//Inventory inventory ;
//int totalSales ;
List<Customer> customers ;


InventoryController inventorycontroller;
//SaleController  SaleController ;


public void addCustomer(Customer customer){
	
 customers = new ArrayList<Customer>();
 customers.add(customer);

//Create Shop
//@Create Customers in Shop
//@Create Inventory in Shopp
//@Conduct sale 
}

public List<Customer> getCustomers(){
	return customers;
}





}
