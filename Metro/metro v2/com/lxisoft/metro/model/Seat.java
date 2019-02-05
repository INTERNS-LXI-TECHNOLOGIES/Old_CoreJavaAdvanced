package com.lxisoft.metro.model;


public class Seat{
	private int seatNum;
	
	public Seat(int seatNum){
		this.seatNum=seatNum;	
	}
	
	public int getSeatNum(){
		return seatNum;
	}
	
	public String toString(){ 
		return  seatNum+" ";  
	} 
	
}