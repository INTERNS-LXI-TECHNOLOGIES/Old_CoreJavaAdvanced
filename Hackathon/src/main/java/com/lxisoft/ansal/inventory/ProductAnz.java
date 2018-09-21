package com.lxisoft.ansal.inventory;
import com.lxisoft.ansal.part.PartAnz;


// @TODO Add proper java doc comments

public class ProductAnz implements PartAnz 
{


  private String description;

  private boolean display;

  private long id;

  private double price;

  private double maximumStockLevel;


  private String name;

  private double reOrderLevel;

  private String reference;

  private String searchKey;

  //private List<ProductAnz> parts = new ArrayList<ProductAnz>();
  public ProductAnz(int id,String name,String description,double price)
  {
	this.name=name;
	this.description=description;
	display=true;
  this.price=price;
	this.id=id;
	maximumStockLevel=5;
	reOrderLevel=2.0;
	reference=description+" "+name+" "+id;
	searchKey=description+" "+name+" "+id;
  }
  public double getPrice()
  {
	  return price;
  }
  public String getName()
  {
    return name;
  }
  public boolean isProductAvailableinStock()
  {
    return display;
  }
  public String toString()
  {
    return name;
  }
}
