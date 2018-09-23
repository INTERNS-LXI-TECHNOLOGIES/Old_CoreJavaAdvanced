package com.lxisoft.balu.inventory.model;


// @TODO Add proper java doc comments

public class Product extends Part {


  private String name;


  //private String description = null;

 // private boolean display = null;

  private long id;
  
  private int price;



  private int maximumStockLevel;
  
  private int quantityInStock;


 // private String name = null;

 // private double reOrderLevel = null;

 // private String reference = null;

 // private String searchkey = null;

  //private List<Product> parts = new ArrayList<Product>();

  
 public Product(String name,int id,int price){
	  this.name = name;
	  this.id = id;
	  this.price = price;
  }
  
  public void setQuantityInStock(int quantityInStock){
	  this.quantityInStock =quantityInStock;
  }
  
  public String getName(){
	  return name;
  }
  
  public int getPrice(){
	  return price;
  }
 /** public String getDescription(){
	  return description;
  }
  
   public String getSearchkey(){
	  return searchKey;
  }*/
  public int getQuantityInStock(){
	  return quantityInStock;
  }

  public long  getId(){
	  return id;
  }
  
  public void isProductAvailableinStock(){
	  
  }
  
  public String toString(){
	  return this.name;
  }
}
