package com.lxisoft.balu.inventory.view;

import java.io.*;
import java.util.*;
import com.lxisoft.balu.inventory.model.*;

public class CustomerView{
	public void view(List<Product> list,List<Customer> customers){
		    System.out.println("\t\t\t LIST OF PRODUCTS IN THE SHOP ");
		    
			System.out.println("Hai........"+customers.get(0));
			
			System.out.println(list);
			
			System.out.println("ENTER THE NAME OF THE PRODUCT AND THE QUANTITY TO BE PURCHASED");
	}
  public void customerInfo(){
	        System.out.println("Enter your Details in the order as follows:"+"\n"+"1.Name"+"\n"+"2.Cash in your hand");
  }
  public void wish(){
	  System.out.println("WHETHER YOU WISH TO CONTINUE OR NOT ... please enter y/n");
  }
}