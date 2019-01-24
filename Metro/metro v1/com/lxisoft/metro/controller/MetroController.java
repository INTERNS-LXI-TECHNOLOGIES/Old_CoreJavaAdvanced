package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.*;
import com.lxisoft.metro.view.*;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;


import java.io.IOException;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

public class MetroController{
	Metro metro;
	MetroView metroView;
	TrainController trainControl;
	Passenger passenger;
	Scanner scan= new Scanner(System.in);
	Date date=new Date();
	File adminDetails= new File("./com/lxisoft/metro/file/AdminDetails.txt");

	public MetroController(){
		metro = new Metro();
		metroView = new MetroView();
		trainControl = new TrainController();
	}
	
	public void homePage(){	
	dateFormating();
	metroView.printHomeView(date);
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
		switch(key){
		case 1: adminLogin();	
		break;
		case 2:trainControl.loadTrainDetailsFile(metro);
			   printTrains();
		break;
		case 3:addPassengerDetails();
				searchForPassenger();
		//printPassengerDeatils();
		break;
		default: metroView.defaultCase();}
	}
	private void dateFormating(){
	String strDate;
	date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
    strDate = dateFormat.format(date);

	}
	
	public void adminLogin(){
		String userName,passWord,line;
		Admin admin;
		int count=0;
		metroView.enterUserName();userName=scan.next();
		metroView.enterPassWord();passWord=scan.next();
		try{
			
				FileReader fr=new FileReader(adminDetails);
				BufferedReader br=new BufferedReader(fr);	
				while((line=br.readLine())!=null){
					String[] data = line.split(";");
					String userName1=data[0];
					String passWord1=data[1];
					admin=new Admin(userName1,passWord1);
					metro.setAdmin(admin);
				}
				do{		
				if(userName.equals(metro.getAdmin().getUserName()) && passWord.equals(metro.getAdmin().getPassWord())){
					metroView.loginSucceed();
					String choice = scan.next();
					int key = Integer.parseInt(choice);			
					switch(key){
					case 1: trainControl.addTrainDetails(metro,metroView);
							//printTrains();					
					break;
					//case 3:
					//break;
					default: metroView.defaultCase();}
					count++;
				}else {
					metroView.loginFailed();
					adminLogin();
					}
				}while(false);
			}catch(IOException e){
			System.out.println("Error");}		
	}
	
	
	public void printTrains(){
		int x;
		do{
		metroView.selectSortOrder();
		String option = scan.next();
		int key = Integer.parseInt(option);			
		switch(key){
			case 1: trainControl.sortTrainsByName(metro);;					
			break;
			case 2:trainControl.sortTrainsByArraivalTime(metro);
			break;
			case 3:trainControl.sortByDestination(metro);
			break;
			case 4:trainControl.iteratorMethod(metro);
			break;
			default:metroView.defaultCase();
		}
		metroView.enterOption();String choice = scan.next();
		x = Integer.parseInt(choice);}while(x==1);	
	}
	
	public void addPassengerDetails(){
		String name,mobileNumber;int x;
		do{
		metroView.enterPassengerName();
		metro.setPassenger(new Passenger(scan.next()));
		metroView.enterMobileNumber();
		metro.getPassenger().setMobileNumber(scan.next());
		metro.getPassengers().put(metro.getPassenger().getName(),metro.getPassenger());
		metroView.enterOption();String choice = scan.next();
		
		x = Integer.parseInt(choice);}while(x==1);	
		
	}
	public void printPassengerDeatils(){
		System.out.println(metro.getPassengers());
		searchForPassenger();
		
	}
	public void searchForPassenger(){
		String search;int x;
		do{
		metroView.enterSearchKey();
		search=scan.next();
		System.out.println(metro.getPassengers().get(search));
		//System.out.println(metro.getPassengers().get();
		metroView.enterOption();String choice = scan.next();
		x = Integer.parseInt(choice);}while(x==1);	

		
	}
}