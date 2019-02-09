package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.Train;
import com.lxisoft.metro.model.Compartment;
import com.lxisoft.metro.model.Seat;
import com.lxisoft.metro.model.Metro;
import com.lxisoft.metro.fileOperations.FileOperation;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.HashSet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.lxisoft.metro.view.MetroView;


public class TrainController{
	
	Scanner scan=new Scanner(System.in);
	File trainDetails= new File("./com/lxisoft/metro/file/TrainDetails.txt");
	File tempFile=new File("./com/lxisoft/metro/file/TempFile.txt");
	FileOperation file=new FileOperation();
	Train train;
	
	public void addTrainDetails(Metro metro,MetroView metroView,FileOperation file){
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
		addTrainDetailsToFile(trainName,trainId,arraivalTime,departureTime,startPoint,destination,file);
		choice= scan.next();		
		}while(choice.equals("Y")||choice.equals("y"));
	}
	public void addTrainDetailsToFile(String trainName,String trainId,String arraivalTime,String departureTime,String startPoint,String destination,FileOperation file){
		try{
	file.setFileWriter(new FileWriter(trainDetails,true));
	file.setBufferedWriter(new BufferedWriter(file.getFileWriter()));
	file.getBufferedWriter().write(trainName+","+trainId+","+arraivalTime+","+departureTime+","+startPoint+","+destination);
	file.getBufferedWriter().newLine();
	}catch(IOException e){
			System.out.println("Error");	
		}finally{
			try{
				if (file.getBufferedWriter() != null)
					file.getBufferedWriter().close();
				if (file.getFileWriter() != null)
					file.getFileWriter().close();}
			catch(IOException e){
				e.printStackTrace();}
	}
	}
	public void loadTrainDetailsFile(Metro metro,FileOperation file){
		String line;
		ArrayList<Compartment> compart;
		HashSet<Train> trains=new HashSet<Train>();
	try{
		file.setFileReader(new FileReader(trainDetails));
		file.setBufferedReader(new BufferedReader(file.getFileReader()));	
		while((line=file.getBufferedReader().readLine())!=null){
		String[] data = line.split(",");
		compart=initCompartment();
		train=new Train(data[0].toUpperCase(),data[1],data[2],data[3],data[4].toUpperCase(),data[5].toUpperCase(),compart);
		trains.add(train);
		}
		metro.setTrains(trains);
		file.getFileReader().close();
		file.getBufferedReader().close();
		}catch(IOException e){
			
			System.out.println("Error");}			
	}
	public void printTrainSet(Metro metro){
		
	System.out.println("[<Train name>]	[<Train num>]	[<ArraivalTime>]	[<DepartureTime>]	[<StartPoint>]	 [<Destination>]");
		Iterator<Train> iter=metro.getTrains().iterator();
		while(iter.hasNext()){
			Train t=iter.next();
			System.out.println(t.getTrainName()+"\t\t"+t.getTrainId()+"\t\t "+t.getArraivalTime()+"\t\t\t "+t.getDepartureTime()+"\t\t\t "+t.getStartPoint()+"\t\t"+t.getDestination());  
		}
	}
	public void searchingTrains(Metro metro,MetroView metroView){
		String search,choice;		
		do{
		metroView.enterSearchKey();
		search=scan.next().toUpperCase();
		Train train1=new Train(search);
		Iterator<Train> iter=metro.getTrains().iterator();
		while(iter.hasNext()){
			Train t=iter.next();
		if(t.equals(train1)){
			System.out.println(t.getTrainName()+"\t"+t.getTrainId()+"\t"+t.getArraivalTime()+"\t"+t.getDepartureTime()+"\t"+t.getStartPoint()+"\t"+t.getDestination());  
		}
		}
		metroView.enterOption(); choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));
	}

	
	public void deleteTrain(MetroView metroView) throws IOException{
		String currentLine,search;
		metroView.enterSearchKey();
		search=scan.next();
		file.setFileReader(new FileReader(trainDetails));
		file.setBufferedReader(new BufferedReader(file.getFileReader()));		
				file.setBufferedWriter(new BufferedWriter(new FileWriter(tempFile)));			
				while((currentLine=file.getBufferedReader().readLine())!=null){
					if(!currentLine.contains(search)){
						 System.out.println(currentLine);
					 file.getBufferedWriter().write(currentLine + System.getProperty("line.separator"));}
				}
				file.getFileReader().close();
				file.getBufferedReader().close();
			file.getBufferedWriter().close();
			if(trainDetails.delete()){
			System.out.println("Success");
			}else{
			System.out.println("file exist");}		
		boolean successful = tempFile.renameTo(trainDetails);
        System.out.println(successful);	
	}
	
	public ArrayList<Compartment> initCompartment(){
	ArrayList<Compartment> compartments=new ArrayList<Compartment>();
		ArrayList<Seat> seats;
		seats=createSeat();
		Compartment comp1=new Compartment("AC COMPARTMENT",seats);
		compartments.add(comp1);
		seats=createSeat();
		Compartment comp2=new Compartment("SLEEPER CLASS",seats);
		compartments.add(comp2);
		seats=createSeat();
		Compartment comp3=new Compartment("FIRST CLASS",seats);
		compartments.add(comp3);
		seats=createSeat();
		Compartment comp4=new Compartment("SECOND CLASS",seats);
		compartments.add(comp4);
		seats=createSeat();
		Compartment comp5=new Compartment("GENERAL COMPARTMENT",seats);
		compartments.add(comp5);
		return compartments;

	}
	public ArrayList<Seat> createSeat(){
		ArrayList<Seat> seats=new ArrayList<Seat>();
		Seat seat=null;
		for(int i=1;i<=10;i++){

			seat=new Seat(i);
			seats.add(seat);
		}
		return seats;
	}

}