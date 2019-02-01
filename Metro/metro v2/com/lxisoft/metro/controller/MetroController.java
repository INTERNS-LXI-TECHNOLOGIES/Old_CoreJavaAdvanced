package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.*;
import com.lxisoft.metro.view.*;
import com.lxisoft.metro.comparator.*;
import java.util.*;
import java.io.*;
import java.io.Console;
import java.io.File;

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
	String choice;
	do{
	    metroView.printHomeView(date);
		String option = scan.next();
		int key = Integer.parseInt(option);			
		switch(key){
		case 1: adminLogin();	
		break;
		case 2:trainControl.loadTrainDetailsFile(metro);
			   trainControl.printTrainSet(metro);
		break;
		case 3:trainControl.searchingTrains(metro,metroView);
		break;
		case 4:ticketReservation();
		break;
		default: metroView.defaultCase();
		}metroView.enterOption(); choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));	
	}
	private void dateFormating(){
	String strDate;
	date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
    strDate = dateFormat.format(date);
	}
	public void adminLogin(){
		String userName,passWord,line;int count=0;
		Admin admin;
		Console con = System.console(); 
		metroView.enterUserName();userName=scan.next();
		metroView.enterPassWord();
		char[] ch=con.readPassword();    
		passWord=String.valueOf(ch);//converting char array into string  
		try{	
				FileReader fr=new FileReader(adminDetails);
				BufferedReader br=new BufferedReader(fr);	
				while((line=br.readLine())!=null){
					String[] data = line.split(";");
					String userName1=data[0];
					String passWord1=data[1];
					admin=new Admin(userName1,passWord1);
					metro.setAdmin(admin);}
				do{		
				if(userName.equals(metro.getAdmin().getUserName()) && passWord.equals(metro.getAdmin().getPassWord())){
					metroView.loginSucceed();
					String choice = scan.next();
					int key = Integer.parseInt(choice);			
					switch(key){
					case 1: trainControl.addTrainDetails(metro,metroView);					
					break;
					case 2:addPassengerDetails();
							printPassengerDeatils();
							searchForPassenger();
					break;
					case 3:deleteTrain();
					break;
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
		String choice;
		do{
			
		metroView.selectOrder();
		String option = scan.next();
		int key = Integer.parseInt(option);			
		switch(key){
			case 1:trainControl.printTrainSet(metro);
			break;
			case 2:trainControl.searchingTrains(metro,metroView);
			break;
			default:metroView.defaultCase();
		}
		metroView.enterOption();choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));	
	}
	
	public void deleteTrain(){
		
	}
	public void ticketReservation(){
		trainControl.loadTrainDetailsFile(metro);
		trainControl.printTrainSet(metro);
		searchByStartAndDestination();	
	}
	
	public void searchByStartAndDestination(){
		ArrayList<Train> trainList = new ArrayList<Train>(metro.getTrains());
		System.out.println(trainList);
		metroView.enterStartPointForSearch();
		String spoint=scan.next().toUpperCase();
		metroView.enterDestinationForSearch();
		String dpoint=scan.next().toUpperCase();
		Train t2=new Train(spoint,dpoint);
		int index=Collections.binarySearch(trainList,t2,new SortByDestination());
		if(index>=0){
			t2=trainList.get(index);
			System.out.println(t2);
		}
	
	}
	
	public void addPassengerDetails(){
		String name,mobileNumber,choice;
		do{
		metroView.enterPassengerName();
		metro.setPassenger(new Passenger(scan.next().toUpperCase()));
		metroView.enterMobileNumber();
		metro.getPassenger().setMobileNumber(scan.next());
		metro.getPassengers().put(metro.getPassenger().getName(),metro.getPassenger());
		metroView.enterOption(); choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));		
	}
	
	public void printPassengerDeatils(){
		System.out.println(metro.getPassengers());
	}
	
	public void searchForPassenger(){
		String search,choice;
		SortedMap<String, Passenger> submap;
		do{
		metroView.enterSearchKey();
		search=scan.next().toUpperCase();
		submap = metro.getPassengers().tailMap(search);
		System.out.println(submap.get(search));
		metroView.enterOption();choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));		
	}
}