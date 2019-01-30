package com.lxisoft.metro.model;
import java.util.*;

public class Metro{
private Admin admin;
private Train train;
private Passenger passenger;
//private Platform[] platform;

private ArrayList<Train> trainList=new ArrayList<Train>();
//private HashMap<String,Passenger> passengers= new HashMap<String,Passenger>(); 
private TreeMap<String,Passenger> passengers= new TreeMap<String,Passenger>();	
	
	public void setTrainList(ArrayList<Train> trainList){
		this.trainList=trainList;
	}


	public ArrayList<Train> getTrainList(){
		return trainList;
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
/*	public void setPlatform(Platform[] platform){
		this.platform=platform;	
	}
	
	public Platform[] getPlatform(){
		return platform;
	}*/
	
	public void setPassenger(Passenger passenger){
		this.passenger=passenger;	
	}
	
	public Passenger  getPassenger(){
		return passenger;
	}
	
/*	public void setPassengers(HashMap<String,Passenger> passengers){
		this.passengers=passengers;
	}
	public HashMap<String,Passenger> getPassengers(){
		return passengers;
	}*/
		
	public void setPassengers(TreeMap<String,Passenger> passengers){
		this.passengers=passengers;
	}
	public TreeMap<String,Passenger> getPassengers(){
		return passengers;
	}
		
}