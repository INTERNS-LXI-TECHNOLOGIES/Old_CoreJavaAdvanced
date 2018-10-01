package com.lxisoft.sumi.controller;
import com.lxisoft.sumi.model.*;
import java.io.*;
import java.util.*;
public class CustomerController
{
	public Customer model=new Customer();
	public CustomerController()
	{
		model=new Customer();
		
		System.out.println("Enter Your Name:");
		Scanner input=new Scanner(System.in);
		model.setName(input.nextLine());
	}
}