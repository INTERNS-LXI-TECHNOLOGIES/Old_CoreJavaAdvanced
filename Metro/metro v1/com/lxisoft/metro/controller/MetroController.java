package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.*;
import com.lxisoft.metro.view.*;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.BufferedReader;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

public class MetroController{
	Metro metro;
	MetroView metroView;
	TrainController trainControl;
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
		default: System.out.println("Invalied Input... Please Try Again......");
		
			}
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
					addTrainDetails();
					count++;
				}else {
					metroView.loginFailed();
					}
				}while(false);
			}catch(IOException e){
			System.out.println("Error");}
	}
	
	public void addTrainDetails(){
		String trainName,trainId,startPoint,destination,arraivalTime,departureTime,choice;
		int key;
		do{
		metroView.enterTrainName();
		trainName=scan.next();
		metroView.enterTrainNum();
		trainId=scan.next();
		metroView.enterArraivalTime();
		arraivalTime=scan.next();
		metroView.enterDepartureTime();
		departureTime=scan.next();
		metroView.enterStartPoint();
		startPoint=scan.next();
		metroView.enterDestination();
		destination=scan.next();
		metroView.enterOption();
		metro.setTrain(new Train(trainName,trainId,arraivalTime,departureTime,startPoint,destination));
		metro.getTrainList().add(metro.getTrain());
		choice= scan.next();
		key = Integer.parseInt(choice);			
		}while(key==1);
		for(Train trains:metro.getTrainList()){
		System.out.println("Train::"+trains);}
	}
	
}