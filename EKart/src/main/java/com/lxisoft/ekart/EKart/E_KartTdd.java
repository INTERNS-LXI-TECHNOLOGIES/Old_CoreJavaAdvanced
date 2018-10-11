package com.lxisoft.ekart.EKart;
import java.util.Scanner;

import com.lxisoft.ekart.EKart.controller.CustomerController;

public class E_KartTdd {

	public static void main(String args[])
	{
		CustomerController customer=new CustomerController();
		System.out.println("******Welcome To EKart*******");
		System.out.println("Enjoy your Shopping");
		System.out.println("Enter your choice......[1.Sign-Up]   [2.Login]   [3.StoreKeeper Login]");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		char ch;
		do
		{
			switch(choice)
			{
				case 1:
				{
					customer.signup();
				}
				case 2:
				{
					customer.login();
				}
			}
			System.out.println("Do you wanna continue(Y/N)");
			ch=input.next().charAt(0);
		}while(ch=='Y'||ch=='y');
	
	}
}