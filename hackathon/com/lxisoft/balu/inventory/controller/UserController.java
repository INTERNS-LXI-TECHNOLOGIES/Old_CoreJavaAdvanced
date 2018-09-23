package com.lxisoft.balu.inventory.controller;

import java.util.*;
import com.lxisoft.balu.inventory.controller.*;

public class UserController{
	public UserController(){
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		if(choice == 1){
			CustomerController customerController = new CustomerController();
			customerController.purchase();
		}else
		{
			ManagerController managerController = new ManagerController();
			managerController.controll();
		}
	}
	
}