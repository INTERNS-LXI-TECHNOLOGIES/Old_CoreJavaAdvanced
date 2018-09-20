package com.lxisoft.ekart.customer;
import java.util.HashMap;
import com.lxisoft.ekart.product.Product; 
public class Customer
{
	private String fName;
	private String lName;
	private String address;
	private int postCode;
	private long contactNum;
	private String email;
	private HashMap<Product,Integer> cart;

	public Customer()
	{
		cart=new HashMap<Product,Integer>();
	}
	public void setFName(String fName)
	{
		this.fName=fName;
	}
	public String getFName()
	{
		return fName;
	}
	public void setLName(String lName)
	{
		this.lName=lName;
	}
	public String getLName()
	{
		return lName;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress()
	{
		return address;
	}
	public void setPostCode(int postCode)
	{
		this.postCode=postCode;
	}
	public int getPostCode()
	{
		return postCode;
	}
	public void setContactNum(long contactNum)
	{
		this.contactNum=contactNum;
	}
	public long getContactNum()
	{
		return contactNum;
	}
	public void setEmail(String email) throws IllegalStateException
	{
		if(email.contains("@")&&email.contains("."))
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