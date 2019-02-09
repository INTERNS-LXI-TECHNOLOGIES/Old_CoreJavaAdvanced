package com.lxisoft.metro.model;
import java.io.Serializable;


public class Seat implements Serializable{
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