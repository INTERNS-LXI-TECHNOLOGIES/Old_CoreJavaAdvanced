package com.lxisoft.metro.controller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import com.lxisoft.metro.model.Train;
import com.lxisoft.metro.model.Compartment;
import com.lxisoft.metro.model.Seat;
import com.lxisoft.metro.model.Metro;

public class TrainController{

	File trainFile=new File("./com/lxisoft/metro/TrainDetails.txt");
	File tempFile=new File("./com/lxisoft/metro/tempFile.txt");
	HashSet<Train> hashSet=new HashSet<Train>();
	Scanner input=new Scanner(System.in);

	public void trainDetails(Metro metro){
		ArrayList<Compartment> comp;
		try{
			FileReader fr=new FileReader(trainFile);
			BufferedReader br=new BufferedReader(fr);
			
			String line;
			while((line=br.readLine())!=null)
			{	
				String data[]=line.split(";");
				comp=createCompartment();
				Train train=new Train(data[0],data[1],data[2],data[3],data[4],data[5],comp);
				hashSet.add(train);
			}
			metro.setTrain(hashSet);
			br.close();
			fr.close();
		}

		catch(Exception e){
			e.printStackTrace();
		}
	
	}

	public void viewTrains(){
		int sno=1;
		System.out.println("No."+" *Train Name*    \t\t*Train Id*\t*Arraival Time*\t*Departure Time*\t*Start point*\t*Destination Point*  ");
		//Iterator<Train> ite=hashSet.iterator();
		
		for(Train train:hashSet){
			
			System.out.println("\n"+sno+" "+train.getTrainName()+"     \t\t"+train.getTrainId()+"\t\t"+train.getDepartureTime()+"\t\t"+train.getArraivalTime()+"       \t\t"+train.getStartPoint()+"     \t\t"+train.getDestinationPoint());
			sno++;
		}
	}
	public void addTrainDetails(Metro metro){
		System.out.println("Enter number of trains");
		String no=input.next();
		int n=Integer.parseInt(no);
		for(int i=0;i<n;i++){
			String tname,tid,atime,dtime,spoint,dpoint;
			System.out.println("Enter train Name");
			tname=input.next().toUpperCase();
			System.out.println("Enter train id");
			tid=input.next();
			System.out.println("Enter train departure time");
			dtime=input.next().toUpperCase();
			System.out.println("Enter train arrival time");
			atime=input.next().toUpperCase();
			System.out.println("Enter train start point");
			spoint=input.next().toUpperCase();
			System.out.println("Enter train destination point");
			dpoint =input.next().toUpperCase();
			addDetailsToFile(tname,tid,atime,dtime,spoint,dpoint);
		}	
		trainDetails(metro);
	}

	public ArrayList<Compartment> createCompartment(){
		ArrayList<Compartment> compartments=new ArrayList<Compartment>();
		ArrayList<Seat> seats;
		seats=createSeat();
		Compartment c1=new Compartment("AC COMPARTMENT",seats);
		compartments.add(c1);
		seats=createSeat();
		Compartment c2=new Compartment("SLEEPER CLASS",seats);
		compartments.add(c2);
		seats=createSeat();
		Compartment c3=new Compartment("FIRST CLASS",seats);
		compartments.add(c3);
		seats=createSeat();
		Compartment c4=new Compartment("SECOND CLASS",seats);
		compartments.add(c4);
		seats=createSeat();
		Compartment c5=new Compartment("GENERAL COMPARTMENT",seats);
		compartments.add(c5);
		return compartments;
	
	}
	public ArrayList<Seat> createSeat(){
		ArrayList<Seat> seats=new ArrayList<Seat>();
		for(int i=1;i<=10;i++){

			Seat seat=new Seat(i);
			seats.add(seat);
		}
		return seats;
	}
	public void addDetailsToFile(String tname,String tid,String atime,String dtime,String spoint,String dpoint){
		try{
				FileWriter fw=new FileWriter(trainFile,true);
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
	public Train searching(){

		System.out.println("\nEnter Train Name");
		String tname1=input.next().toUpperCase();
		Train train3=new Train(tname1);
		Iterator<Train> ite=hashSet.iterator();
		Train currentTrain=null;
		while(ite.hasNext()){

			Train train2;
			train2=ite.next();
			if(train2.equals(train3)){

				System.out.println("\n"+" "+train2.getTrainName()+"     \t\t"+train2.getTrainId()+"\t\t"+train2.getDepartureTime()+"\t\t"+train2.getArraivalTime()+"       \t\t"+train2.getStartPoint()+"     \t\t"+train2.getDestinationPoint());		
				currentTrain=train2;
			
			}

		}
		return currentTrain;
	}
	
	public void deleteTrain() throws IOException{
		
			FileReader fr=new FileReader(trainFile);
			FileWriter fw=new FileWriter(tempFile);
			BufferedReader br=new BufferedReader(fr);
			BufferedWriter bw=new BufferedWriter(fw);

			System.out.println("Enter the key");
			String key=input.next().toUpperCase();
			String currentLine;
			while((currentLine=br.readLine())!=null){
				if(null!=currentLine && !currentLine.contains(key)){
                bw.write(currentLine + System.getProperty("line.separator"));
            	}
        	}
	        bw.close();
	        br.close();
	        fw.close();
	        fr.close();
	        boolean successful = tempFile.renameTo(trainFile);

	   		System.out.println(successful);
			
		
		
	}

}