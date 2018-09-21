package com.lxisoft.balu.inventory.view;

import java.io.*;

public class CustomerView{
	public void view(List<Product> list){
		System.out.println("\t\t\t LIST OF PRODUCTS IN THE SHOP ");
		for(Product p : list){
			System.out.println(p);
		}
	}
}