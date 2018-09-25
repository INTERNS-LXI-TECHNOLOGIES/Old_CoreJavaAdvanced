package com.lxisoft.balu.inventory.controller;

import com.lxisoft.balu.inventory.controller.*;

public class CheckController{
	public void check(int choice){
		if(choice ==1 ){
			CustomerController customerController = new CustomerController();
			customerController.customerLogin();
		}else
		{
			CustomerController customerController = new CustomerController();
			customerController.customerRegistration();
		}
		
	}
	
}