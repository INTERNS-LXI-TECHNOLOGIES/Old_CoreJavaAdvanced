package com.lxisoft.metro.controller;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import com.lxisoft.metro.model.*;
import java.io.*;
import java.util.*;
import com.lxisoft.metro.comparator.SortByDestination;
public class TrainController{

ArrayList<Train> trainList =new ArrayList<Train>();
File trainFile=new File("./com/lxisoft/metro/TrainDetails.txt");	
FileWriter fw;
Scanner input=new Scanner(System.in);
	public void trainDetails(Metro metro){
		try{
			FileReader fr=new FileReader(trainFile);
			BufferedReader br=new BufferedReader(fr);
			System.out.println("No."+"\t*Train Name*\t*Train Id*\t*Arraival Time*\t*Departure Time*\t*Start point*\t*Destination Point*  ");
			String line;int i=1;
			while((line=br.readLine())!=null)
			{	
				String data[]=line.split(";");
				
				Train train=new Train(data[0],data[1],data[2],data[3],data[4],data[5]);
				trainList.add(train);
		
			}
			metro.setTrain(trainList);
			Collections.sort(trainList);
			for(Train train:trainList){
			System.out.println("\n"+i+"\t"+train.getTrainName()+"\t"+train.getTrainId()+"\t\t"+train.getArraivalTime()+"\t\t"+train.getDepartureTime()+"       \t\t"+train.getStartPoint()+"     \t\t"+train.getDestinationPoint());
			i++;
			
		}
		sortDestination(metro);
		trainList.clear();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	public void sortDestination(Metro metro){

		SortByDestination sorting=new SortByDestination();
		Collections.sort(metro.getTrain(),sorting);
		int i=1;
		System.out.println("No."+"\t*Train Name*\t*Train Id*\t*Arraival Time*\t*Departure Time*\t*Start point*\t*Destination Point*  ");
		for(Train train:metro.getTrain()){
			System.out.println("\n"+i+"\t"+train.getTrainName()+"\t"+train.getTrainId()+"\t\t"+train.getArraivalTime()+"\t\t"+train.getDepartureTime()+"       \t\t"+train.getStartPoint()+"     \t\t"+train.getDestinationPoint());
			i++;
		}
	}
	public void addTrainDetails(Metro metro){
		System.out.println("Enter number of trains");
		String no=input.next();
		int n=Integer.parseInt(no);
		for(int i=0;i<n;i++){
			String tname,tid,atime,dtime,spoint,dpoint;
			System.out.println("Enter train Name");
			tname=input.next();
			System.out.println("Enter train id");
			tid=input.next();
			System.out.println("Enter train arrival time");
			atime=input.next();
			System.out.println("Enter train departure time");
			dtime=input.next();
			System.out.println("Enter train start point");
			spoint=input.next();
			System.out.println("Enter train destination point");
			dpoint =input.next();
			addDetailsToFile(tname,tid,atime,dtime,spoint,dpoint);
		}	
		
	}
	public void addDetailsToFile(String tname,String tid,String atime,String dtime,String spoint,String dpoint){
		try{
				fw=new FileWriter(trainFile,true);
				fw.write(tname+";");
				fw.write(tid+";");
				fw.write(atime+";");
				fw.write(dtime+";");
				fw.write(spoint+";");
				fw.write(dpoint+"\n");
				fw.close();
		}
		catch(Exception e){

			e.printStackTrace();
		}
	

	}
	public void searchDetails(){

		System.out.println("Enter the search key");

	}
}