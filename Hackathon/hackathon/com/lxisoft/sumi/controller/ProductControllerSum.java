package com.lxisoft.sumi.controller;
public class ProductControllerSum implements InventoryControllerSum
{
	private List<ProductSum> parts = new ArrayList<ProductSum>();
	
	public ProductControllerSum()
	{
		
	}
	int quntityToAdd;
	public void addStockToInventory( ProductControllerSum productToAdd, int quantityToAdd) 
	{
		this.quantityToAdd=quantityToAdd;
		productToAdd=new ProductControllerSum();
	}
} 