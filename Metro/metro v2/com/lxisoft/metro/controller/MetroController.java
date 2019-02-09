package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.Passenger;
import com.lxisoft.metro.model.Metro;
import com.lxisoft.metro.model.Train;
import com.lxisoft.metro.model.Admin;
import com.lxisoft.metro.model.Ticket;
import com.lxisoft.metro.view.MetroView;
import com.lxisoft.metro.comparator.SortByDestination;
import com.lxisoft.metro.fileOperations.FileOperation;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.Date;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Calendar;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

public class MetroController{
	Metro metro;
	MetroView metroView;
	TrainController trainControl;
	Passenger passenger;
	Admin admin;
	FileOperation file;
	Scanner scan;
	Date date=new Date();
	File adminDetails= new File("./com/lxisoft/metro/file/AdminDetails.txt");
	File passengerDetails=new File("./com/lxisoft/metro/file/PassengerDetails");
	
	public MetroController(){
		file=new FileOperation();
		scan= new Scanner(System.in);
		metro = new Metro();
		metroView = new MetroView();
		trainControl = new TrainController();
	}
	
	public void homePage(){	
	dateFormating();
	trainControl.loadTrainDetailsFile(metro,file);
	String choice;
	do{
	    metroView.printHomeView(date);
		String option = scan.next();
		int key = Integer.parseInt(option);			
		switch(key){
		case 1: ticketReservation();	
		break;
		case 2:printTrains();
		break;
		case 3:trainControl.searchingTrains(metro,metroView);
		break;
		case 4:adminLogin();
		trainControl.loadTrainDetailsFile(metro,file);
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
		Console con = System.console(); 
		metroView.enterUserName();userName=scan.next();
		metroView.enterPassWord();
		char[] ch=con.readPassword();     
		passWord=String.valueOf(ch);//converting char array into string
		try{	
				file.setFileReader(new FileReader(adminDetails));
				file.setBufferedReader(new BufferedReader(file.getFileReader()));	
				while((line=file.getBufferedReader().readLine())!=null){
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
					case 1: trainControl.addTrainDetails(metro,metroView,file);					
					break;
					case 2:printPassengerDeatils();
					break;
					case 3:trainControl.deleteTrain(metroView);
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
	
	public void ticketReservation(){
		String choice;
		metroView.printTicketReservation();
			do{
				Train t=searchByStartAndDestination();
				metroView.selectTicketReservation(t);
				String choice1=scan.next();
				int ch=Integer.parseInt(choice1);
				if(ch==1){
				int i=1;
				metroView.printCompartment();
					for(int c=0;c<t.getCompartments().size();c++){
						System.out.println(i+" "+t.getCompartments().get(c).getCompartmentType());
						i++;}
				metroView.selectCompartment();
				String sele=scan.next();
				int select=Integer.parseInt(sele);
					for(int sel=1;sel<=t.getCompartments().size();sel++){
						if(select==sel){
							int s=sel;s--;
							metroView.printSeats();
							System.out.println(t.getCompartments().get(s).getSeats());
							metroView.selectSeat();
							String senum=scan.next();
							int seat=Integer.parseInt(senum);
							addPassengerDetails();
								for(int sl=1;sl<=t.getCompartments().get(s).getSeats().size();sl++){
									if(seat==sl){
									int rs=0;
									rs=seat;rs--;
									System.out.println("you reserved the ticket\n");
									createTicket(passenger.getName(),passenger.getAge(),passenger.getMobileNumber(),t.getTrainName(),t.getCompartments().get(s).getCompartmentType(),t.getCompartments().get(s).getSeats().get(rs).getSeatNum());			
									t.getCompartments().get(s).getSeats().remove(rs);
								break;}
								}
							}
						}
					}
		metroView.enterOption(); choice = scan.next();
		}while(choice.equals("Y")||choice.equals("y"));	
	}
	public Train searchByStartAndDestination(){
		ArrayList<Train> trainList = new ArrayList<Train>(metro.getTrains());
		metroView.enterStartPointForSearch();
		String spoint=scan.next().toUpperCase();
		metroView.enterDestinationForSearch();
		String dpoint=scan.next().toUpperCase();
		Train t2=new Train(spoint,dpoint);
		int index=Collections.binarySearch(trainList,t2,new SortByDestination());
		if(index>=0){
			t2=trainList.get(index);
		}
		return t2;
	}
	public void addPassengerDetails(){
		String name,mobileNumber,choice;
		TreeMap<String,Passenger> pass=new TreeMap<String,Passenger>();
		metroView.enterPassengerName();
		passenger=new Passenger(scan.next().toUpperCase());
		metroView.enterMobileNumber();
		passenger.setMobileNumber(scan.next());
		metroView.enterAge();
		passenger.setAge(scan.next());
		pass.put(passenger.getName(),passenger);
		metro.setPassengers(pass);		
	}
	public void passengerDetailsToFile(String passName,String pAge,String mNumber,String tName,String compartType,int seatNo,int fair){
		try{
			file.setFileWriter(new FileWriter(passengerDetails,true));
			file.setBufferedWriter(new BufferedWriter(file.getFileWriter()));
			file.getBufferedWriter().write(date+";"+passName+";"+pAge+";"+mNumber+";"+tName+";"+compartType+";"+seatNo+";"+fair+" ");
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
	public void createTicket(String passName,String pAge,String mNumber,String tName,String compartType,int seatNo){
		int fair;
		if(tName.contains("PASS")){
			fair=45;
		}else if(tName.contains("EXP")){
			fair=60;
		}else{
			fair=55;
		}
		
		Ticket ticket=new Ticket(date,passName,pAge,tName,compartType,seatNo,fair);
		ArrayList<Ticket> ticketList=new ArrayList<Ticket>();
		ticketList.add(ticket);
		metro.setTicket(ticketList);
		metroView.printTicket(date,passName,pAge,mNumber,tName,compartType,seatNo,ticket.getFair());
		passengerDetailsToFile(passName,pAge,mNumber,tName,compartType,seatNo,ticket.getFair());
	}
	
	public void printPassengerDeatils(){
		String line;
		try{
		file.setFileReader(new FileReader(passengerDetails));
		file.setBufferedReader(new BufferedReader(file.getFileReader()));
		
		System.out.println("PASSENGERS");		
		while((line=file.getBufferedReader().readLine())!=null){
		String[] data = line.split(";");
		
		System.out.println("Date:"+data[0]+"Name: "+data[1]+ " Age:"+data[2]+" MobileNumber:"+data[3]+" Train:"+data[4]+" Compartment:"+data[5]+" Seat:"+data[6]+" Fair"+data[7]+"\n");
		}
		file.getFileReader().close();
		file.getBufferedReader().close();
		}catch(IOException e){
			
			System.out.println("Error");}	
		}
}