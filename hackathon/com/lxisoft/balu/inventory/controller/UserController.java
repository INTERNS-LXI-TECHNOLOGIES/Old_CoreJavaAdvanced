package com.lxisoft.balu.inventory.controller;


public class UserController{
	public void control(){
		Scanner scanner = new Scannner(System.in);
		int choice = scanner.nextInt();
		if(choice == 1){
			CustomerController customerController = new CustomerController();
		}else
		{
			ManagerController managerController = new ManagerController();
		}
	}
	
}