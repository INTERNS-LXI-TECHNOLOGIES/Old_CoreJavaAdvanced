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
import com.lxisoft.metro.comparator.*;


public class TrainController{
	
	Scanner scan=new Scanner(System.in);
	File TrainDetails= new File("./com/lxisoft/metro/file/TrainDetails.txt");
	
	public void addTrainDetails(Metro metro,MetroView metroView){
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
		addTrainDetailsToFile(metro.getTrain());
		//metro.getTrainList().add(metro.getTrain());
		choice= scan.next();
		key = Integer.parseInt(choice);			
		}while(key==1);
		

	}

	public void addTrainDetailsToFile(Train train){
		FileWriter fw=null;
		BufferedWriter bw=null;
		try{
		fw = new FileWriter(TrainDetails,true);
		bw = new BufferedWriter(fw);
		bw.write(train.getTrainName()+","+train.getTrainId()+","+train.getArraivalTime()+","+train.getDepartureTime()+",");
		bw.write(train.getStartPoint()+","+train.getDestination());
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
		metro.setTrain(new Train(data[0],data[1],data[2],data[3],data[4],data[5]));
		metro.getTrainList().add(metro.getTrain());}
		}catch(IOException e){
			System.out.println("Error");}			
	}
	
	public void sortTrainsByName(Metro metro){
		Collections.sort(metro.getTrainList()); 
		System.out.println("\nSorted by train Name"); 
		printTrainList(metro);
	}
	public void printTrainList(Metro metro){
		System.out.println("*****");
		int listSize=metro.getTrainList().size();
		for (int i=0; i<listSize; i++) {
            System.out.println(metro.getTrainList().get(i)); 
		}
	}
	public void sortTrainsByArraivalTime(Metro metro){
		SortByTime sortByTime= new SortByTime();
		Collections.sort(metro.getTrainList(),sortByTime);
		System.out.println("\nSorted by Train Time"); 
		printTrainList(metro);
	}
	
	public void sortByDestination(Metro metro){
		SortByDestination sortByDestination=new SortByDestination();
		System.out.println("\nSorted by Train Destination"); 
		Collections.sort(metro.getTrainList(),sortByDestination);
		printTrainList(metro);
	}
	
	
}