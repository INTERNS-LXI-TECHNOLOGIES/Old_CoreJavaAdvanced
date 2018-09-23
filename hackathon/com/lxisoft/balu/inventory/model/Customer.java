package com.lxisoft.balu.inventory.model;


public class Customer {


private String name ;
private int cashInHand ;

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



}
