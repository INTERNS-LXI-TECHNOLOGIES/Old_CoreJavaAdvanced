package com.lxisoft.ansal.inventory;
import com.lxisoft.amsal.part.Part;


// @TODO Add proper java doc comments

class Product implements Part 
{


  private String description = null;

  private boolean display = null;

  private long id = null;

  private double price;

  private doub1e maximumStockLevel = null;


  private String name = null;

  private double reOrderLevel = null;

  private String reference = null;

  private String searchkey = null;

  //private List<Product> parts = new ArrayList<Product>();
  public Product(int id,String name,String description,double price)
  {
	this.name=name;
	this.description=description;
	display=true;
  this.price=price;
	this.id=id;
	maximumStockLevel=5;
	reOrderLevel=2.0;
	reference=description+" "+name;
	searchkey=description+" "+name;
  }
  public double getPrice()
  {
	  return price;
  }

}
