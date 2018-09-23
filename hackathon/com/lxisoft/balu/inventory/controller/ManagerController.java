package com.lxisoft.balu.inventory.controller;

import java.util.*;
import com.lxisoft.balu.inventory.model.*;
import com.lxisoft.balu.inventory.view.*;

public class ManagerController extends InventoryController{
	private static final List<Product> listToAdd = new ArrayList<Product>();
	public void controll(){
	Scanner scanner = new Scanner(System.in);
	ManagerView managerView = new ManagerView();
	managerView.view();
	int id = scanner.nextInt();
	String ItemName = System.console().readLine();
	int quantityToAdd = scanner.nextInt();
	int maximumStockLevel = scanner.nextInt();
	int productPrice = scanner.nextInt();
	Product product = new Product(ItemName,id,productPrice);
	product.setQuantityInStock(quantityToAdd);
	addStockToInventory(product,quantityToAdd);
	}
	
	public void addStockToInventory( Product productToAdd, int quantityToAdd){
		listToAdd.add(productToAdd);
	}
	
	public void removeStockFromInventory( Product productToRemove, int quantityToRemove){
		
	}
	
	public List<Product> getList(){
		return listToAdd;
	}
	
}