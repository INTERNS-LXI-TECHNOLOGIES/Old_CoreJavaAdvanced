package com.lxisoft.sumi.controller;
public interface InventoryControllerSum {


List<ProductSum> inventory ;

public void addStockToInventory( ProductSum productToAdd, int quantityToAdd) ;
public void removeStockFromInventory( ProductSum productToRemove, int quantityToRemove) ;
public InventoryControllerSum
{
	inventory=new ArrayList<ProductSum>();
}





}
