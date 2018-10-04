package model;

	public class Product //implements PartDee 
	{

	  //private string name = null ;
	  private String description;

	  private boolean display=true;

	  private int id;

	  public double maximumStockLevel=10;

	  private String name;

	  public double reOrderLevel=5;

	  private String reference;

	  private String searchKey;
	  
	  private double price;

	  //private List<ProductDee> parts = new ArrayList<ProductDee>();
	   public Product(int id,String name,String description,double price)
	   {
		   this.name=name;
		   this.id=id;
		   this.price=price;
		   this.description=description;
		   reference=description+" "+name+" "+id;
		   searchKey=description+" "+name+" "+id;
		   
	   }

	  
	  public String getName(){
	    return name;
	  }
	  
	  public int getId(){
		  return id;
	  }
	  
	  public String getDescription(){
		  return description;
	  }
	  public void setReference(String reference){
		  this.reference = reference;
	  }
	  
	  public String getReference(){
		  return reference;
	  }
	  
	  public void setSearchKey(String searchKey){
		  this.searchKey = searchKey;
	  }
	  public String getSearchKey(){
		  return searchKey;
	  }

	  public double getPrice(){
		  return price;
	  }
	  
	  public boolean isProductAvailableinStock(){
	    return display;
	  }
	  public String toString(){
	    return name;
	  }

	}
