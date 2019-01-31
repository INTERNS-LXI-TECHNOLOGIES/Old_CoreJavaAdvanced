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
		/*metroView.enterTrainType();
		type=scan.next();*/
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
		//metro.getTrainList().add(metro.getTrain());
		choice= scan.next();
		key = Integer.parseInt(choice);			
		}while(key==1);
		

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
	
	/*public void sortTrainsByName(Metro metro){
		Collections.sort(metro.getTrains()); 
		System.out.println("\nSorted by train Name"); 
		printTrainList(metro);
	}*/
	
	public void printTrainSet(Metro metro){
		
		
		System.out.println("Train name 		Train num	ArraivalTime 		DepartureTime  		StartPoint 		Destination");
		Iterator<Train> iter=metro.getTrains().iterator();
		while(iter.hasNext()){
			Train t=iter.next();
			System.out.println(t.getTrainName()+"\t\t"+t.getTrainId()+"\t \t "+t.getArraivalTime()+"\t\t\t "+t.getDepartureTime()+"\t \t\t "+t.getStartPoint()+"\t\t"+t.getDestination());  
		}
	}
	
	
	public void searchingTrains(Metro metro,MetroView metroView){
	/*	System.out.println("********************");
		int listSize=metro.getTrainList().size();
		int i;
		/*for(Train t:metro.getTrainList()){
			System.out.println(i+" "+t.getTrainName()+"\t"+t.getTrainId()+"\t"+t.getArraivalTime()+"\t"+t.getDepartureTime()+"\t"+t.getStartPoint()+"\t"+t.getDestination());  
		}
		for(i=0;i<listSize;i++){
			System.out.println((i+1)+" "+metro.getTrainList().get(i).getTrainName()+"\t"+metro.getTrainList().get(i).getTrainId()+"\t"+metro.getTrainList().get(i).getArraivalTime()+"\t"+metro.getTrainList().get(i).getDepartureTime()+"\t"+metro.getTrainList().get(i).getStartPoint()+"\t"+metro.getTrainList().get(i).getDestination());  
		}*/
		String search;int x;		
		do{
		metroView.enterSearchKey();
		search=scan.next().toUpperCase();
		Train train1=Train.tn(search);
		Iterator<Train> iter=metro.getTrains().iterator();
		while(iter.hasNext()){
		searchingTrainSet(iter.next(),train1);
		}
		metroView.enterOption();String choice = scan.next();
		x = Integer.parseInt(choice);
		}while(x==1);
	}
	public void searchingTrainSet(Train train,Train train1){
		if(train.equals(train1)){
			System.out.println(train);
		}
	}
/*	public void searchForTrains(Metro metro,MetroView metroView){
		Train searchTrain;
		String search;int x;		
		do{
		metroView.enterSearchKey();
		search=scan.next().toUpperCase();	
		searchTrain=Train.tn(search);
		Collections.sort(metro.getTrains());
		int index=	Collections.binarySearch(metro.getTrains(), searchTrain);
		System.out.println(metro.getTrainList().get(index));
		metroView.enterOption();String choice = scan.next();
		x = Integer.parseInt(choice);}while(x==1);	
	}	
		
		for (int i=0; i<listSize; i++) {
            System.out.println(metro.getTrainList().get(i)); 
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
	
	public void iteratorMethod(Metro metro){ 
	Iterator<Train> i3 = metro.getTrainList().iterator();
	while (i3.hasNext()) {
	Train train = i3.next(); 
	System.out.println(train.getTrainName());
	}
	}
	
	public void searchByStartAndDestination(Metro metro,MetroView metroView){
		metroView.enterStartPointForSearch();
		String spoint=scan.next().toUpperCase();
		metroView.enterDestinationForSearch();
		String dpoint=scan.next().toUpperCase();
		Train train2=new Train(spoint,dpoint);
		int index=Collections.binarySearch(metro.getTrainList(),train2,new SortByDestination());
		if(index>=0){
			train2=metro.getTrainList().get(index);
			System.out.println(train2);
		}
	
		}*/
	
}