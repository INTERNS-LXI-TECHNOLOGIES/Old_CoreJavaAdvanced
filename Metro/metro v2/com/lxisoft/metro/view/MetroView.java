package com.lxisoft.metro.view;
import com.lxisoft.metro.model.*;
import java.util.*;

public class MetroView{
	
	public void printHomeView(Date date){
		System.out.println("---------------------------");
		System.out.println(">>>>>>>>>>>METRO<<<<<<<<<<<<");
		System.out.println("---------------------------");
		System.out.println(date);
		System.out.println("1.Ticket Reservation 2.Train details 3.Search 4.Admin");
		
	}
	public void enterUserName(){
		System.out.println("******ADMIN LOGIN******");
		System.out.println("UserName");
	}
	
	public void enterPassWord(){
		System.out.println("Password::");
		
	}
	public void defaultCase(){
		System.out.println("Invalied Input..... Try Again");
	}
	public void loginSucceed(){
		System.out.println("Login Successfull......");
		System.out.println("1.Add Train details 2.Passenger Details");
	}
	public void loginFailed(){
		
		System.out.println("Login Failed......Try Again.........");
	}
	
	public void enterTrainName(){
		System.out.println("Train Name::");
	}
	public void enterTrainNum(){
		System.out.println("Train Number::");
	}
	public void enterArraivalTime(){
		System.out.println("Arraival Time::");
	}
	public void enterDepartureTime(){
		System.out.println("Departure Time::");
	}
	public void enterStartPoint(){
		System.out.println("Starting point::");
	}
	public void enterDestination(){
		System.out.println("Destination::");
	}
	public void enterOption(){
		System.out.println("Do you want to continue? (Y/N) ");
	}
	public void printTrainDetails(Train trains){
		System.out.println("Train:"+trains);
	}
	
	public void selectOrder(){
	System.out.println("1.Trains... 2.Search Train....");}
	
	public void enterCompartment(){
		System.out.println("Enter your choice");
	}
	public void enterSearchKey(){
		System.out.println("Enter the search key");
	}
	public void enterCompartmentNum(){
		System.out.println("Compartment ::");
	}
	public void enterPassengerName(){
		System.out.println("Name::");
	}
	public void enterMobileNumber(){
		System.out.println("Mobile Number::");
	}
	public void enterAge(){
		System.out.println("Age::");
	}
	public void enterDestinationForSearch(){
		System.out.println("Destination:");	
	}
	public void enterStartPointForSearch(){
		System.out.println("Start Point:");
	}
	
	public void printTicketReservation(){
		System.out.println("TICKET RESERVATION");
	}
	public void selectTicketReservation(Train t2){
		System.out.println(t2.getTrainName()+"\t"+t2.getTrainId()+"\t"+t2.getArraivalTime()+"\t"+t2.getDepartureTime()+"\t"+t2.getStartPoint()+"\t"+t2.getDestination());
	System.out.println("Want to Reserve ticket....Press 1");
	}
	public void printCompartment(){
		System.out.println("Compartments");
	}
	public void selectCompartment(){
		System.out.println("Select Compartment");
	}
	public void printSeats(){
		System.out.println("Available Seats Are::");
	}
	public void selectSeat(){
		System.out.println("Select Your seat");
	}
	
	public void printTicket(Date date,String passName,String pAge,String mNumber,String tName,String compartType,int seatNo,int fair){
		System.out.println("***************Train Ticket*****************");
		System.out.println("| Date: "+date);
		System.out.println("| Name : "+passName+"		");
		System.out.println("|"+"						");
		System.out.println("| Age :	"+pAge+" Mobile Number:"+mNumber);
		System.out.println("|"+"						");
		System.out.println("| Train Name : "+tName+"				");
		System.out.println("|"+"						"); 
		System.out.println("| Compartment :	"+compartType+"		");
		System.out.println("|"+"			");
		System.out.println("|"+" Seat No :	"+seatNo+"	"+"Fair: "+fair);
		System.out.println("|"+"						");
		System.out.println("********************************************");
	}
	
}