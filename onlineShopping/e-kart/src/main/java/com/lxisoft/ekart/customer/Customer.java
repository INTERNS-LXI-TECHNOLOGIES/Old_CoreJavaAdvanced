package com.lxisoft.ekart.customer;
import java.util.HashMap;
import com.lxisoft.ekart.product.Product;

public class Customer
{
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private HashMap<Product,Integer> cart;
	
	public Customer()
	{
		cart = new HashMap<Product,Integer>();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhonenumber()
	{
		return phoneNumber;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setEmail(String email) throws IllegalStateException
	{
		if (email.contains("@")&& email.contains("."))
		{
			this.email=email;
		}
		else
		{
			throw new IllegalStateException("Invalid email please re-enter");
		}
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void addToCart(Product product,Integer quantity)
	{
		cart.put(product,quantity);
	}
	
	public HashMap<Product,Integer> getCart()
	{
		return cart;
	}
}