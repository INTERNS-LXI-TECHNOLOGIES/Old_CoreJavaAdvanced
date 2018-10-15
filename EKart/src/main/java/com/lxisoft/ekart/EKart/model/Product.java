package com.lxisoft.ekart.EKart.model;

public class Product {
	
	private int pId;
	private String pName;
	private int price;
	private int maxStock;
	private String category;
	public Product(int id, String name, int price2, int maximumStockLevel, String searchkey) {
		setpId(id);
		setpName(name);
		setPrice(price2);
		setMaxStock(maximumStockLevel);
		setCategory(searchkey);
		
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
