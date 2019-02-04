package com.lxisoft.metro.model;
import java.util.*;

public class Compartment{
	
	private int id;
	
	private Seat seat;
	
	private TreeSet<Seat> seatSet= new TreeSet<Seat>();
	
	public void setCompartmentId(int id ){
		this.id=id;	
	}
	
	public int  getCompartmentId(){
		return id;
	}
	
	public void setSeat(Seat seat){
		this.seat=seat;	
	}
	
	public Seat getSeat(){
		return seat;
	}
	
	public void setSeats(TreeSet<Seat> seatSet){
		
		this.seatSet=seatSet;	
	}
	
	public TreeSet<Seat> getSeats(){
		return seatSet;
	}
	
}