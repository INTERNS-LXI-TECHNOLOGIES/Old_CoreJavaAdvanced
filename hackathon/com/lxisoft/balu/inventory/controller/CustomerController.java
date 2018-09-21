package com.lxisoft.balu.inventory.controller;

public class customerController{
	public void purchase(){
		List<Product> list = obj.getList();
		CustomerView customerView = new CustomerView();\
		customerView.view(list);
	}
	
}