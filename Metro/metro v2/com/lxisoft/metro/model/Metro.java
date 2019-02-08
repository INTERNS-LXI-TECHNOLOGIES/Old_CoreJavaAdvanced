package com.lxisoft.metro.model;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.ArrayList;

public class Metro{
private Admin admin;
//private Train train;
//private Passenger passenger;


private TreeMap<String,Passenger> passengers;//= new TreeMap<String,Passenger>();	
private HashSet<Train> trainSet;//=new HashSet<Train>();
private ArrayList<Ticket> ticketList;
	
	public void setTrains(HashSet<Train> trainSet){
		this.trainSet=trainSet;	
	}
	
	public HashSet<Train> getTrains(){
		return trainSet;
	}
	
	public void setAdmin(Admin admin){
		this.admin=admin;	
	}
	
	public Admin  getAdmin(){
		return admin;
	}
	
	public void setPassengers(TreeMap<String,Passenger> passengers){
		this.passengers=passengers;
	}
	public TreeMap<String,Passenger> getPassengers(){
		return passengers;
	}
	
	public void setTicket(ArrayList<Ticket> ticketList){

		this.ticketList=ticketList;
	}
	public ArrayList<Ticket> getTicket(){

		return ticketList;
	}
	
		
}