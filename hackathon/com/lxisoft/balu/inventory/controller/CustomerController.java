package com.lxisoft.balu.inventory.controller;
import java.util.*;
import com.lxisoft.balu.inventory.model.*;
import com.lxisoft.balu.inventory.controller.*;
import com.lxisoft.balu.inventory.view.*;

public class CustomerController{
	public void purchase(){
		char choice;
		Scanner scanner = new Scanner(System.in);
		CustomerView customerView = new CustomerView();
		customerView.customerInfo();
		String customerName = System.console().readLine();
		int cashInHand = scanner.nextInt();
		Customer customer = new Customer(customerName);
		customer.setCashInHand(cashInHand);
		Shop shop = new Shop();
		shop.addCustomer(customer);
		List<Customer> customers = shop.getCustomers();
		ManagerController managerController = new ManagerController();
		List<Product> list = managerController.getList();
		customerView.view(list,customers);
		do{
		String ProductName = System.console().readLine();
		int quantity = scanner.nextInt();
		doPurchase(ProductName,quantity,list,customers);
		customerView.wish();
		choice = scanner.next(".").charAt(0);
		}while(choice == 'y');
	}
	
	public void doPurchase(String ProductName,int quantity,List<Product> list,List<Customer> customers){
		  for(int i =0;i<list.size();i++){
			  if(ProductName.equals(list.get(i).getName())){
				  int currentQuantity = list.get(i).getQuantityInStock();
				  //System.out.println(currentQuantity);
				  int finalQuantity = currentQuantity - quantity;
				   //System.out.println(finalQuantity);
				   int currentCash = customers.get(0).getCashInHand();
				   int finalCash =  currentCash-(quantity * list.get(i).getPrice());
				   if(finalCash<0){
					   System.out.println("YOUR BALANCE IS LOW ....you cannot purcahse the item");
					    customers.clear();
					   break;
				   }
				  if(finalQuantity<0){
					  System.out.println("THE ITEM IS OUT OF STOCK ....you cannot purcahse the item");
					  break;
				  }
				  customers.get(0).setCashInHand(finalCash);
				  list.get(i).setQuantityInStock(finalQuantity);
			  }
		  }
	}
	
}