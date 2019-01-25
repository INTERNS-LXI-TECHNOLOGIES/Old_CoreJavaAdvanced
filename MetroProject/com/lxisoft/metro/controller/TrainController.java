package com.lxisoft.metro.controller;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import com.lxisoft.metro.model.*;
import java.io.*;
import java.util.*;
import com.lxisoft.metro.comparator.SortByDestination;
import com.lxisoft.metro.comparator.SortByDest;
public class TrainController{

ArrayList<Train> trainList =new ArrayList<Train>();
File trainFile=new File("./com/lxisoft/metro/TrainDetails.txt");	
ArrayList<String> nameList=new ArrayList<String>();
ArrayList<String> destList=new ArrayList<String>();
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
				nameList.add(data[0]);
				destList.add(data[5]);
		
			}
			metro.setTrain(trainList);
			Collections.sort(trainList);
			for(Train train:trainList){
			System.out.println("\n"+i+"\t"+train.getTrainName()+"\t"+train.getTrainId()+"\t\t"+train.getArraivalTime()+"\t\t"+train.getDepartureTime()+"       \t\t"+train.getStartPoint()+"     \t\t"+train.getDestinationPoint());
			i++;
			
		}
		}

		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	public void sortDestination(Metro metro){

		String sPoint,dPoint;
			System.out.println("Enter the Starting Point");
			sPoint=input.next();
			System.out.println("Enter the Destination Point");
			dPoint=input.next();
			//ArrayList<Train> newList=new ArrayList<Train>();
			Train train1=new Train(sPoint,dPoint);
			int index=Collections.binarySearch(metro.getTrain(),train1,new SortByDestination());
			if(index>=0){
	
					train1=metro.getTrain().get(index);
				int i=1;
		System.out.println("No."+"\t*Train Name*\t*Train Id*\t*Arraival Time*\t*Departure Time*\t*Start point*\t*Destination Point*  ");
			System.out.println("\n"+i+"\t"+train1.getTrainName()+"\t"+train1.getTrainId()+"\t\t"+train1.getArraivalTime()+"\t\t"+train1.getDepartureTime()+"       \t\t"+train1.getStartPoint()+"     \t\t"+train1.getDestinationPoint());
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

		System.out.println("Enter Search key");
		String searchKey=input.next();
		System.out.println("No."+"\t*Train Name*\t*Train Id*\t*Arraival Time*\t*Departure Time*\t*Start point*\t*Destination Point*  ");
		for(int i=0;i<trainList.size();i++)
		{
			if(searchKey.equals(nameList.get(i))){

				Collections.sort(trainList);
				Train train=Train.tn(searchKey);
				int index2=Collections.binarySearch(trainList,train);
				if(index2>=0){
					for(int ind=0;ind<index2;ind++){
					train=trainList.get(ind);                                                                
					System.out.println("\n"+i+"\t"+train.getTrainName()+"\t"+train.getTrainId()+"\t\t"+train.getArraivalTime()+"\t\t"+train.getDepartureTime()+"       \t\t"+train.getStartPoint()+"     \t\t"+train.getDestinationPoint());
				}
				}
			}
			else if(searchKey.equals(destList.get(i))){
				ArrayList<Train> list=new ArrayList<Train>();
				Train train=Train.dp(searchKey);
				int index;
			do{
				index=Collections.binarySearch(trainList,train,new SortByDest());
				if(index>=0){

					train=trainList.get(index);
					list.add(train);
					System.out.println(list);
					
				}
			}while(index==0);
				for(Train trai:list){
					System.out.println("\n"+i+"\t"+trai.getTrainName()+"\t"+trai.getTrainId()+"\t\t"+trai.getArraivalTime()+"\t\t"+trai.getDepartureTime()+"       \t\t"+trai.getStartPoint()+"     \t\t"+trai.getDestinationPoint());
				}

			}
		}
			





	}
}