package com.lxisoft.sumi.model;


// @TODO Add proper java doc comments

public class Product extends Part{


	//private string name = null ;


	// private String description = null;

	// private TrueOrFalse display = null;

	public long id;
	public int maximumStockLevel;
	//private String name = null;

	// private Double reOrderLevel = null;

	//private String reference = null;

	public String searchkey;
	public Product(long id,String name,int price,int maximumStockLevel,String searchkey)
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.maximumStockLevel=maximumStockLevel;
		this.searchkey=searchkey;
	}



}
