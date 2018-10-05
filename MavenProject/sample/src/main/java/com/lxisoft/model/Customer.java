package com.lxisoft.model;
public class Customer {
	private String name ;
	private int cashInHand ;
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setCashInHand(int cashInHand)
	{
		this.cashInHand=cashInHand;
	}
	public int getCashInHand()
	{
		return cashInHand;
	}
	
}
