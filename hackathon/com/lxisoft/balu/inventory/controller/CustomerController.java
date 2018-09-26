package com.lxisoft.balu.inventory.controller;
import java.util.*;
import com.lxisoft.balu.inventory.model.*;
import com.lxisoft.balu.inventory.controller.*;
import com.lxisoft.balu.inventory.view.*;

   public class CustomerController{
	public void check(){
		
		Scanner scanner = new Scanner(System.in);
		
		CustomerView customerView = new CustomerView();

		CheckController checkController = new CheckController();
		//Adding customer details.
		customerView.customerEntry();
		int entryChoice = scanner.nextInt();
        checkController.check(entryChoice);

    }

    public void getDetails(int id){
        char choice;
        JdbcController jdbcController = new JdbcController();
        CustomerView customerView = new CustomerView();
        Scanner scanner = new Scanner(System.in);
        String customerName = jdbcController.getCustomerName(id);
        int cashInHand = jdbcController.getCustomerBalance(id);
		Customer customer = new Customer(customerName);
		customer.setCashInHand(cashInHand);
		Shop shop = new Shop();
		shop.addCustomer(customer);
		List<Customer> customers = shop.getCustomers();
		ManagerController managerController = new ManagerController();
		List<Product> list = managerController.getList();
		do{
		customerView.view(list,customers);
		String ProductName = System.console().readLine();
		int quantity = scanner.nextInt();
		doPurchase(ProductName,quantity,list,customers);
		customerView.customerWish();
		choice = scanner.next(".").charAt(0);
		}while(choice == 'y');
		customerView.customerExit(customers);
		customers.clear();
	}
	
	public void doPurchase(String ProductName,int quantity,List<Product> list,List<Customer> customers){
		try{
            JdbcController jdbcController = new JdbcController();
            
			if(list.isEmpty()){
			System.out.println("\t\t\t SORRY" + " " +customers.get(0).getName()+" THERE IS NO PRODUCT IN THE SHOP");
		}else{
		  for(int i =0;i<list.size();i++){
			  if(ProductName.equals(list.get(i).getName())){
                 
				  int currentQuantity = list.get(i).getQuantityInStock();
				  //System.out.println(currentQuantity);
				  int finalQuantity = currentQuantity - quantity;
				   //System.out.println(finalQuantity);
				   int currentCash = customers.get(0).getCashInHand();
				      //System.out.println(currentCash);
				   int finalCash =  currentCash-(quantity * list.get(i).getPrice());
				      System.out.println("\n\t\t YOUR CURRENT BALANCE IS: "+finalCash);
				      boolean isProductAvailable = list.get(i).isProductAvailableinStock(finalQuantity);
				   if(finalCash<0){
					   System.out.println("PLEASE CREDIT YOUR ACCOUNT ,YOUR BALANCE IS LOW ....you cannot purcahse the item");
					    //customers.clear();
					   break;
				   }
				  if(isProductAvailable){
					  System.out.println("THE ITEM IS OUT OF STOCK ....you cannot purcahse the item");
					  break;
				  }
				  int transactionCost = currentCash - finalCash;
				  customers.get(0).setCashInHand(finalCash);
				  jdbcController.updateTransactionDetails(customers.get(0).getName(),transactionCost);
                  jdbcController.updateCustomerDetails(finalCash,customers.get(0).getName());
				  list.get(i).setQuantityInStock(finalQuantity);
				   //adding the purchased produc
			  	  customers.get(0).addPurchasedProduct(list.get(i));
			  }
		  }
		}
		}catch(Exception e){
			System.out.println("SORRY YOU CANNOT PURCHASE GOODS");
		}
	}
	

 public void customerRegistration(){
 	    Scanner scanner = new Scanner(System.in);
 	    CustomerView customerView = new CustomerView();
        customerView.customerReg();
		int id = scanner.nextInt();
		String customerName = System.console().readLine();
		int cashInHand = scanner.nextInt();
		//Storing details to the database.
   	    JdbcController jdbcController = new JdbcController();
		jdbcController.addCustomer(id,customerName,cashInHand);
		getDetails(id);
	}

  
 public void customerLogin(){
      Scanner scanner = new Scanner(System.in);
      CustomerView customerView = new CustomerView();
      customerView.customerLogin();
      int customerId = scanner.nextInt();
      getDetails(customerId);
   }
}