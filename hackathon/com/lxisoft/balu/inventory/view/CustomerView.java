package com.lxisoft.balu.inventory.view;

import java.io.*;
import java.util.*;
import com.lxisoft.balu.inventory.model.*;

public class CustomerView{
	public void view(List<Product> list,List<Customer> customers){
			System.out.println("Hai........"+customers.get(0));
		    
		    System.out.println("\t\t\t LIST OF PRODUCTS IN THE SHOP ");
		    
			for(int i =0;i<list.size();i++){

			    System.out.println((i+1)+":"+list.get(i)+"\n");
				
			}
			
			System.out.println("ENTER THE NAME OF THE PRODUCT AND THE QUANTITY TO BE PURCHASED");
	}
  public void customerReg(){
	        System.out.println("Enter your Details in the order as follows:"+"\n"+"1.Id"+"\n"+"2.Name"+"\n"+"2.Cash in hand");
  }
  public void customerWish(){
	  System.out.println("WHETHER YOU WISH TO CONTINUE OR NOT ... please enter y/n");
  }
  public void customerLogin(){
  	  System.out.println("PLEASE ENTER YOUR ID\n");
  }
  public void customerEntry(){
  	System.out.println("PRESS 1 IF YOU ARE A REGISTERED USER OR ELSE PRESS 2\n");
  }

}