package com.lxisoft.ekart.customer;
import com.lxisoft.ekart.dao.DAO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Map;
import com.lxisoft.ekart.product.Product;

public class CustomerController
{
	private Customer customer;

	public CustomerController(Customer customer)
	{
		this.customer=customer;
	}
	public Customer getCustomer()
	{
		return customer;
	} 
	public void setCustomer(Customer customer)
	{
		this.customer=customer;
	}
	public void customerLogin()
	{
		do
		{
			if(validateCustomer(fetchCustomer()))
			{
				System.out.println("Welcome "+customer.getFName()+" "+customer.getLName());
				break;
			}
			else
			{
				System.out.println("Sorry you are not signed up or you entered a wrong username or password");
			}
		}while(true);
	}
	public Customer fetchCustomer()
	{
		System.out.println("************ Please Login ************");
		Scanner in=new Scanner(System.in);
		System.out.print("Username : ");
		Customer attemptingCustomer=new Customer();
		attemptingCustomer.setUsername(in.nextLine());
		System.out.print("Password : ");
		attemptingCustomer.setPassword(in.nextLine());
		return attemptingCustomer;
	}
	public boolean validateCustomer(Customer attemptingCustomer)
	{
		Connection con=DAO.getConnection();
		Statement stmt=DAO.getStatement(con);
		String query="select * from customers where username="+"\""+attemptingCustomer.getUsername()+"\"";
		try
		{
			customer=createCustomer(DAO.getResultSet(query,stmt));
			if(!customer.getPassword().equals(attemptingCustomer.getPassword()))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(SQLException se)
		{
			return false;
		}
	}
	public Customer createCustomer(ResultSet result)
	{
		try
		{
			result.next();
			customer.setFName(result.getString("fname"));
			customer.setLName(result.getString("lname"));
			customer.setUsername(result.getString("username"));
			customer.setPassword(result.getString("password"));
			customer.setAddress(result.getString("address"));
			customer.setPostCode(result.getInt("postcode"));
			customer.setContactNum(result.getLong("contact"));
			customer.setEmail(result.getString("email"));
			return customer;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			return null;
		}
	}
	public int getSelection()
	{
		System.out.print("Select product : ");
  		Scanner in=new Scanner(System.in);
		return in.nextInt();
	}
	public int getRequirement()
	{
		System.out.print("Enter required quantity : ");
  		Scanner in=new Scanner(System.in);
		return in.nextInt();
	}
	public boolean continueShopping()
	{
		System.out.print("Continue shopping? (Y/N) : ");
		Scanner in=new Scanner(System.in);
		if(in.nextLine().equals("y"))
		{
			return true;
		}
		return false;
	}
	public void addToCart(Product product,Integer quantity)
	{
		customer.getCart().put(product,quantity);
	}
	public String makePayment()
	{
		printCart();
		System.out.println("Total amount Rs."+calculatePayment());
		System.out.println("1.Pay on Delivery");
		System.out.println("2.Credit/debit Card");
		System.out.print("Select payment method : ");
		Scanner in=new Scanner(System.in);
		if(in.nextInt()==1)
		{
			return payOnDelivery();
		}
		else
		{
			return cardBanking();
		}
	}
	public String payOnDelivery()
	{
		System.out.println("You selected pay on delivery");
		double totalPayment=calculatePayment();
		System.out.println("Please pay Rs."+totalPayment+" on delivery");
		return "pay on delivery";
	}
	public String cardBanking()
	{
		System.out.println("You selected card payment");
		double totalPayment=calculatePayment();
		System.out.println("Plaese pay Rs."+totalPayment);
		System.out.print("Card Number : ");
		Scanner in=new Scanner(System.in);
		String cardNumber=in.nextLine();
		System.out.print("Pin : ");
		in.nextLine();
		return cardNumber;
	}
	public double calculatePayment()
	{
		double total=0;
		for(Map.Entry entry:customer.getCart().entrySet())
		{
			double unitPrice=((Product)entry.getKey()).getPrice();
			int quantity=(Integer)entry.getValue();
			double cost=unitPrice*quantity;
			total+=cost;
		}
		return total;
	}
	public void printCart()
	{
		for(Map.Entry entry:customer.getCart().entrySet())
		{
			double unitPrice=((Product)entry.getKey()).getPrice();
			int quantity=(Integer)entry.getValue();
			double cost=unitPrice*quantity;
			System.out.println(entry.getKey()+"\t*"+entry.getValue()+"\tRs."+cost);
		}
	}
}