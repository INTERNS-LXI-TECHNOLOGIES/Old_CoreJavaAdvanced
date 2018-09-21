package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*;
import java.util.*;
public class CustomerControllerSum
{
	public CustomerControllerSum()
	{
		CustomerSum customer=new CustomerSum();
		Scanner input=new Scanner(System.in);
		System.out.println("Name:");
		customer.setName(input.nextLine());
		System.out.println("State");
		customer.setState(input.nextLine());
		System.out.println("District");
		customer.setDistrict(input.nextLine());
	}
}