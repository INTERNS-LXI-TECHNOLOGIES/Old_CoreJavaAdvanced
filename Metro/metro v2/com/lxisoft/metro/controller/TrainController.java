package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

import com.lxisoft.metro.view.*;


public class TrainController{
	
	Scanner scan=new Scanner(System.in);
	File TrainDetails= new File("./com/lxisoft/metro/file/TrainDetails.txt");
	
	public void addTrainDetails(Metro metro,MetroView metroView){
		String trainName,trainId,startPoint,destination,arraivalTime,departureTime,choice;
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
		addTrainDetailsToFile(trainName,trainId,arraivalTime,departureTime,startPoint,destination);
		choice= scan.next();		
		}while(choice.equals("Y")||choice.equals("y"));
	}

	public void addTrainDetailsToFile(String trainName,String trainId,String arraivalTime,String departureTime,String startPoint,String destination){
		FileWriter fw=null;
		BufferedWriter bw=null;
		try{
		fw = new FileWriter(TrainDetails,true);
		bw = new BufferedWriter(fw);
		bw.write(trainName+","+trainId+","+arraivalTime+","+departureTime+",");
		bw.write(startPoint+","+destination);
		bw.newLine();
	}catch(IOException e){
			System.out.println("Error");	
		}finally{
			try{
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();}
		catch(IOException e){
				e.printStackTrace();}
	}
	}
	public void loadTrainDetailsFile(Metro metro){
		String line;
	try{	
		FileReader fr=new FileReader(TrainDetails);
		BufferedReader br=new BufferedReader(fr);	
		while((line=br.readLine())!=null){
		String[] data = line.split(",");
		metro.setTrain(new Train(data[0].toUpperCase(),data[1],data[2],data[3],data[4].toUpperCase(),data[5].toUpperCase()));
		metro.getTrains().add(metro.getTrain());}
	
		}catch(IOException e){
			
			System.out.println("Error");}			
	}
	public void printTrainSet(Metro metro){
		
		
		System.out.println("Train name 		Train num	ArraivalTime 		DepartureTime  		StartPoint 		Destination");
		Iterator<Train> iter=metro.getTrains().iterator();
		while(iter.hasNext()){
			Train t=iter.next();
			System.out.println(t.getTrainName()+"\t\t"+t.getTrainId()+"\t \t "+t.getArraivalTime()+"\t\t\t "+t.getDepartureTime()+"\t \t\t "+t.getStartPoint()+"\t\t"+t.getDestination());  
		}
	}
	public void searchingTrains(Metro metro,MetroView metroView){
		String search,choice;		
		do{
		metroView.enterSearchKey();
		search=scan.next().toUpperCase();
		Train train1=Train.tn(search);
		Iterator<Train> iter=metro.getTrains().iterator();
		while(iter.hasNext()){
		searchingTrainSet(iter.next(),train1);
		}
		metroView.enterOption(); choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));
	}
	public void searchingTrainSet(Train train,Train train1){
		if(train.equals(train1)){
			System.out.println(train);
		}
	}
}