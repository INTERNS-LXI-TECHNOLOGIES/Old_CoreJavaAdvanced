package com.lxisoft.sumi.model;

public class Product extends Part{


	public long id;
	public double maximumStockLevel;
	public String searchkey;
	public Product(long id,String name,double price,double maximumStockLevel,String searchkey)
	{
	
		this.id=id;
		this.name=name;
		this.price=price;
		this.maximumStockLevel=maximumStockLevel;
		this.searchkey=searchkey;
	}



}
