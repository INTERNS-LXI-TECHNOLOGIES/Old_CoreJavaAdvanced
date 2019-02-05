package com.lxisoft.metro.model;
import java.util.*;

public class Compartment{
	
	private String type;
	
	private Seat seat;
	
	//private TreeSet<Seat> seatSet;
	
	private ArrayList<Seat> seatList;
	
	public Compartment(String type){
		this.type=type;	
	}
	
	public String  getCompartmentType(){
		return type;
	}
	
	public void setSeat(Seat seat){
		this.seat=seat;	
	}
	
	public Seat getSeat(){
		return seat;
	}
	
	/*public void setSeats(TreeSet<Seat> seatSet){
		
		this.seatSet=seatSet;	
	}
	
	public TreeSet<Seat> getSeats(){
		return seatSet;
	}*/
	
	public void setSeats(ArrayList<Seat> seatList){
		
		this.seatList=seatList;	
	}
	
	public ArrayList<Seat> getSeats(){
		return seatList;
	}
	public String toString(){ 
		return  type+" ";  
	} 
	
}