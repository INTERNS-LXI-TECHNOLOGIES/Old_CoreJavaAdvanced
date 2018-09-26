package com.lxisoft.balu.inventory.view;

import java.io.*;
import java.util.*;
import com.lxisoft.balu.inventory.model.*;

public class CustomerView{
	public void view(List<Product> list,List<Customer> customers){
			System.out.println("\n\n\n\t\t\tHai........"+customers.get(0));
		    
		    System.out.println("\n\n\t\t\t LIST OF PRODUCTS IN THE SHOP ");
		    
			for(int i =0;i<list.size();i++){

			    System.out.println("\n\t\t\t"+(i+1)+":"+list.get(i)+"\n");
				
			}
			
			System.out.println("ENTER THE NAME OF THE PRODUCT AND THE QUANTITY TO BE PURCHASED");
	}
  public void customerReg(){
	        System.out.println("\t\t\t**********Enter your Details in the order as follows***********"+"\n"+"1.Id"+"\n"+"2.Name"+"\n"+"2.Cash in hand");
  }
  public void customerWish(){
	  System.out.println("\n\n\t\t\tWHETHER YOU WISH TO CONTINUE OR NOT ... please enter y/n");
  }
  public void customerLogin(){
  	  System.out.println("\n\nPLEASE ENTER YOUR ID\n");
  }
  public void customerEntry(){
  	System.out.println("\n\nPRESS 1 IF YOU ARE A REGISTERED USER OR ELSE PRESS 2\n");
  }
  public void customerExit(List<Customer> customers){
           List<Product> list = customers.get(0).getPurchasedProduct();
           System.out.println("\n\n\t\t\t THE LIST OF PRODUCTS YOU HAVE PURCHASED NOW");
            for(int i=0;i<list.size();i++){
                 System.out.println("\n\t\t\t\t"+list.get(i).getName());
            }
  }

}