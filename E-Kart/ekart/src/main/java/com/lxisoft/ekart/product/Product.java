package com.lxisoft.ekart.product;
import java.util.List;
import java.util.ArrayList;
public class Product
{
	private String name;
	private double price;
	private String category;
	private List<String> searchTags; 

	public Product(String name,String category,double price)
	{
		setName(name);
		setCategory(category);
		setPrice(price);
		addSearchTag(name);
		addSearchTag(category);
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category=category;
	}
	public void addSearchTag(String tag)
	{
		if(searchTags==null)
		{
			searchTags=new ArrayList<String>();
		}
		searchTags.add(tag);
	}
	public List<String> getSearchTags()
	{
		return searchTags;
	}
	public int hashCode()
	{
		return category.hashCode();
	}
	public String toString()
	{
		return name;
	}
	public boolean equals(Object o)
	{
		return name.equals(((Product)o).name);
	}
}