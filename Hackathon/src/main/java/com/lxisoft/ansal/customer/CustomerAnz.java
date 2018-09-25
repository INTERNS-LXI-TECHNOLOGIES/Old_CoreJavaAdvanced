package com.lxisoft.ansal.customer;
import java.util.List;
import java.util.ArrayList;
public class CustomerAnz 
{
	private String name ;
	private double cashInHand ;
	private List<Double> transactions;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setCashInHand(double cashInHand)
	{
		this.cashInHand=cashInHand;
	}
	public double getCashInHand()
	{
		return cashInHand;
	}
	public String toString()
	{
		return name;
	}
	public void addTransaction(double transaction)
	{
		if(transactions==null)
		{
			transactions=new ArrayList<Double>();
		}
		transactions.add(transaction);
	}
	public List<Double> getTransactions()
	{
		return transactions;
	}

}
