package model;



public class Product {

	private int id;
	private String name;
	private int price;
	private String category;
	//private List<String> searchTags; 

	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category=category;
	}
	
}
