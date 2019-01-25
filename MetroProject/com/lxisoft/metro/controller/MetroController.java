package com.lxisoft.metro.controller;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.*;
import java.util.*;

import com.lxisoft.metro.model.Metro;
import com.lxisoft.metro.model.Admin;
import com.lxisoft.metro.model.Train;
public class MetroController{

	Metro metro=new Metro();
	TrainController traincntrl=new TrainController();
	File file=new File("./com/lxisoft/metro/AdminDetails.txt");
	
	FileWriter fw;
	Scanner input=new Scanner (System.in);

	

	public void homePage(){
		String con;
		do{
		System.out.println("1.Admin Login.......2.Train Details........3.searchDetails........4.search By Start and Destination");
		String ch=input.next();
		int choice=Integer.parseInt(ch);
		switch(choice)
		{
			case 1:adminLogin();
					break;
			case 2:traincntrl.trainDetails(metro);
					break;
			case 3:traincntrl.searchDetails();
					break;
			case 4:traincntrl.sortDestination(metro);
					break;
		}
			System.out.println("Do u wanna continue(Y/N)");
			con=input.next();
		}while(con.equals("Y")||con.equals("y"));
	}

	public void adminLogin(){


		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			Admin admin;
			int flag=0;
			String line;

			while((line=br.readLine())!=null){
					String data[]=line.split(";");
					admin=new Admin(data[0],data[1]);
					metro.setAdmin(admin);
				}
			do{
				System.out.println("*****ADMIN LOGIN*****");
				String uname,pwd;
			
				System.out.println("User Name: ");
				uname=input.next();
				System.out.println("Password: ");
				pwd=input.next();
				

				if((uname.equals(metro.getAdmin().getUserName()))&&(pwd.equals(metro.getAdmin().getPassword()))){
					System.out.println("login success");
					flag=1;
				}
				else {
					System.out.println("login failure...please Re-enter username and Password");
					flag=0;
				}

				
			}while(flag==0);
		}
		catch(Exception e){

			e.printStackTrace();
		}
		String con;
		do{
			System.out.println("1.Add Train Details...2.Delete Train Details....");
			String ch=input.next();
			int choice=Integer.parseInt(ch);
			
			switch(choice){

				case 1:traincntrl.addTrainDetails(metro);
					break;
				case 2:deleteTrainDetails();
					break;
			}
			System.out.println("Do u wanna continue(Y/N)");
			con=input.next();
		}while(con.equals("Y")||con.equals("y"));
	}

	
	public void deleteTrainDetails(){

	}
}