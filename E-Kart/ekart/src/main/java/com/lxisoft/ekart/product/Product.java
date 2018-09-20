package com.lxisoft.ekart.product;
import java.util.List;
import java.util.ArrayList;
public class Product
{
	private String name;
	private int price;
	private String category;
	private List<String> searchTags;

	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
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
		searchTags.add(tag);
	}
	public List<String> getSearchTags()
	{
		return searchTags;
	}
}