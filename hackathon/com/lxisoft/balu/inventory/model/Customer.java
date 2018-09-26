package com.lxisoft.balu.inventory.model;

import java.util.*;

import com.lxisoft.balu.inventory.controller.SaleController;

import com.lxisoft.balu.inventory.model.Product;

public class Customer extends SaleController {


private String name ;
private int cashInHand ;
private List<Product> productPurchased = new ArrayList<Product>();

public Customer(String name){
	this.name = name;
}
public void setCashInHand(int cashInHand){
	this.cashInHand = cashInHand;
}
public int getCashInHand(){
	return cashInHand;
}
public String getName(){
	return name;
}

public String toString(){
	return name;
}

public void addPurchasedProduct(Product product){
	productPurchased.add(product);
}

public List<Product> getPurchasedProduct(){
	return productPurchased;
}



}
