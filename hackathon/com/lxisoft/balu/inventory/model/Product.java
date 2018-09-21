package com.lxisoft.balu.inventory.model;


// @TODO Add proper java doc comments

public class Product extends Part {


  private string name = null ;


  private String description = null;

  private boolean display = null;

  private long id = null;



  private double maximumStockLevel = null;


 // private String name = null;

  private double reOrderLevel = null;

  private String reference = null;

  private String searchkey = null;

  //private List<Product> parts = new ArrayList<Product>();
  
  public String getName(){
	  return name;
  }
  
  public String getDescription(){
	  return description;
  }
  
  public String getSearchkey(){
	  return searchKey;
  }

  public String getReference(){
	  return reference;
  }
}
