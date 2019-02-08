package com.lxisoft.metro.model;
import java.util.*;

public class Compartment{
	
	private String type;
	
	private ArrayList<Seat> seats;
	
	public Compartment(String type,ArrayList<Seat> seats){
		this.type=type;
		this.seats=seats;		
	}
	
	public String  getCompartmentType(){
		return type;
	}
	public ArrayList<Seat> getSeats(){
		return seats;
	}
	public String toString(){ 
		return  type+" "+seats;  
	} 
	
}