package com.lxisoft.metro.model;
import java.util.*;

public class Metro{
private Admin admin;
private Train train;
private Passenger passenger;


private TreeMap<String,Passenger> passengers= new TreeMap<String,Passenger>();	
private HashSet<Train> trainSet=new HashSet<Train>();
	
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
	
	public void setTrain(Train train){
		this.train=train;	
	}
	
	public Train  getTrain(){
		return train;
	}
	
	
	public void setPassenger(Passenger passenger){
		this.passenger=passenger;	
	}
	
	public Passenger  getPassenger(){
		return passenger;
	}
		
	public void setPassengers(TreeMap<String,Passenger> passengers){
		this.passengers=passengers;
	}
	public TreeMap<String,Passenger> getPassengers(){
		return passengers;
	}
		
}