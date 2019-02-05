package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.*;
import com.lxisoft.metro.fileOperations.*;
import java.io.File;
import java.io.*;
import java.util.*;

import com.lxisoft.metro.view.*;


public class TrainController{
	
	Scanner scan=new Scanner(System.in);
	File trainDetails= new File("./com/lxisoft/metro/file/TrainDetails.txt");
	File tempFile=new File("./com/lxisoft/metro/file/TempFile.txt");
	FileOperation file=new FileOperation();
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
	try{
		
		file.setFileReader(new FileReader(trainDetails));
		file.setBufferedReader(new BufferedReader(file.getFileReader()));	
		while((line=file.getBufferedReader().readLine())!=null){
		String[] data = line.split(",");
		metro.setTrain(new Train(data[0].toUpperCase(),data[1],data[2],data[3],data[4].toUpperCase(),data[5].toUpperCase()));
		metro.getTrains().add(metro.getTrain());
		initCompartment(metro);}
	
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
		Train train1=Train.tn(search);
		Iterator<Train> iter=metro.getTrains().iterator();
		while(iter.hasNext()){
		searchingTrainSet(iter.next(),train1,metro);
		}
		metroView.enterOption(); choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));
	}
	public void searchingTrainSet(Train train,Train train1,Metro metro){
		if(train.equals(train1)){
			System.out.println(train);
		}
		
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
	
	public void initCompartment(Metro metro){
		ArrayList<Compartment> compart=new ArrayList<Compartment>();
		metro.getTrain().setCompartment(new Compartment("AC COMPARTMENT"));
		initSeat(metro);
		compart.add(metro.getTrain().getCompartment());		
		metro.getTrain().setCompartment(new Compartment("SLEEPER CLASS"));
		initSeat(metro);
		compart.add(metro.getTrain().getCompartment());				
		metro.getTrain().setCompartment(new Compartment("FIRST CLASS"));
		initSeat(metro);
		compart.add(metro.getTrain().getCompartment());				
		metro.getTrain().setCompartment(new Compartment("SECOND CLASS"));
		initSeat(metro);
		compart.add(metro.getTrain().getCompartment());			
		metro.getTrain().setCompartment(new Compartment("GENERAL COMPARTMENT"));
		initSeat(metro);
		compart.add(metro.getTrain().getCompartment());				
		metro.getTrain().setCompartments(compart);

		}
		public void selectCompartment(Metro metro,MetroView metroView){
			String choice;
			do{	
		metroView.enterCompartment();
		String option = scan.next();
		int key = Integer.parseInt(option);			
		switch(key){
			case 1:metro.getTrain().getCompartments().get(0);
			System.out.println(metro.getTrain().getCompartments().get(0).getSeats());
			break;
			case 2:metro.getTrain().getCompartments().get(1);
			System.out.println(metro.getTrain().getCompartments().get(0).getSeats());
			break;
			case 3:metro.getTrain().getCompartments().get(2);
			System.out.println(metro.getTrain().getCompartments().get(0).getSeats());
			break;
			case 4:metro.getTrain().getCompartments().get(3);
			System.out.println(metro.getTrain().getCompartments().get(0).getSeats());
			
			break;
			case 5:metro.getTrain().getCompartments().get(4);
			System.out.println(metro.getTrain().getCompartments().get(0).getSeats());
			break;
			default:metroView.defaultCase();
		}
		metroView.enterOption();choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));	
		}
	public void printCompartment(Metro metro,MetroView metroView){
		int i=1;
		for(Compartment com:metro.getTrain().getCompartments())
		{	System.out.println(i+" "+com);
	i++;}
	selectCompartment(metro,metroView);
	}
	public void initSeat(Metro metro){
		int i;
		metro.getTrain().getCompartment().setSeats(new ArrayList<Seat>());
		
		for(i=1;i<=10;i++){
		metro.getTrain().getCompartment().setSeat(new Seat(i));
		metro.getTrain().getCompartment().getSeats().add(metro.getTrain().getCompartment().getSeat());}
		
	}
}