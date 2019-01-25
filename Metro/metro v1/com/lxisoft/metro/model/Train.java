package com.lxisoft.metro.model;
import java.util.*;
import java.io.*;


public class Train implements Comparable<Train>{
	
	private String trainName;
	private String trainId;
	//private Compartment compartment;
	private String arraivalTime,departureTime;
	private String startPoint,destination;
	
	
	public Train(String trainName,String trainId,String arraivalTime,String departureTime,String startPoint,String destination){
		this.trainName=trainName;
		this.trainId=trainId;
		this.arraivalTime=arraivalTime;		
		this.departureTime=departureTime;
		this.destination=destination;
		this.startPoint=startPoint;			
	}
	
	public Train(){
		
	}
	public static Train tn(String trainName){
		Train t=new Train();
		t.trainName=trainName;
		return t;
	}
	public static  Train tId(String trainId){
		Train t=new Train();
		t.trainId=trainId;
		return t;
	}
	public static Train aT(String arraivalTime){
		Train t=new Train();
		t.arraivalTime=arraivalTime;
		return t;		
	}
	public static Train dn(String destination){
		Train t=new Train();
		t.destination=destination;
		return t;
	}
	
	public Train(String startPoint,String destination){
		this.startPoint=startPoint;
		this.destination=destination;

	}
	public String  getTrainName(){
		return trainName;
	}

	public String  getTrainId(){
		
		return trainId;
	}
	
	public String  getArraivalTime(){
		return arraivalTime;
	}
	
	public String  getDepartureTime(){
		return departureTime;
	}
	
	public String  getDestination(){
		return destination;
	}

	public String  getStartPoint(){
		return startPoint;
	}
	
	public String toString(){ 
		return  trainName+" "+trainId+" "+arraivalTime+" "+departureTime+" "+startPoint+" "+destination+" ";  
	} 
	
    public int compareTo(Train train){ 
        return trainName.compareTo(train.getTrainName()); 
    } 
}