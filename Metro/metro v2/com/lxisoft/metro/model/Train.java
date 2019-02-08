package com.lxisoft.metro.model;
import java.util.*;
import java.io.*;


public class Train implements Comparable<Train>{
	
	private String trainName;
	private String trainId;
	//private Compartment compartment;
	private String arraivalTime,departureTime;
	private String startPoint,destination;
	private ArrayList<Compartment> compartments;//= new ArrayList<Compartment>();
	
	public Train(String trainName,String trainId,String arraivalTime,String departureTime,String startPoint,String destination,ArrayList<Compartment> compartments){
		this.trainName=trainName;
		this.trainId=trainId;
		this.arraivalTime=arraivalTime;		
		this.departureTime=departureTime;
		this.destination=destination;
		this.startPoint=startPoint;
		this.compartments=compartments;		
	}
	
	public Train(){}
	public Train (String trainName){
		this.trainName=trainName;}
	
	public Train(String startPoint,String destination){
		this.startPoint=startPoint;
		this.destination=destination;}
		
	public String  getTrainName(){
		return trainName;}

	public String  getTrainId(){	
		return trainId;}
	
	public String  getArraivalTime(){
		return arraivalTime;}
	
	public String  getDepartureTime(){
		return departureTime;}
	
	public String  getDestination(){
		return destination;}

	public String  getStartPoint(){
		return startPoint;}

	public ArrayList<Compartment> getCompartments(){
		return compartments;
	}
	public String toString(){ 
		return  trainName+" "+trainId+" "+arraivalTime+" "+departureTime+" "+startPoint+" "+destination+" "+compartments;  
	} 
	
    public int compareTo(Train train){ 
        return trainName.compareTo(train.getTrainName()); 
    } 
	
	public boolean equals(Object o) {
		
		Train train=(Train)o;
		if(o==null){
			return false;}
		if(this==o){
			return true;}
		if(trainName.equals(train.trainName)){
			return true;}	
		else {
			return false;}
	}
	public int hashCode() {
		int result=0;
		if(trainName.contains("PASS")){
			result=1;
			return result;
		}
		if(trainName.contains("EXP")){
			result=2;
			return result;
		}
		else{
			return result;
		}
		
	}
}