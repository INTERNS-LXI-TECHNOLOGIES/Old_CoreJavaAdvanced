package com.lxisoft.eKart.shop;

import java.io.*;

import java.util.*;

public class ShopController{
	
	public ShopController(){
		int choice;
		
		ShopView shopView = new ShopView();
		
		/**Scanner scanner = new Scanner(System.in);
		
		choice = scanner.nextInt();*/
		
		CustomerController customerController = new CustomerController();
		
		customerController.selectProduct();
		
		/**switch(choice){
			case 1:
			
			break;
			
			case 3:
			
			break;
			
			case 4:
			
			break;
			
			case 5:
			
			break;
			
			default: System.out.println("--------- YOUR ENTERED A WRONG CHOICE--------");
			
		}*/
		
	}
	
	
}