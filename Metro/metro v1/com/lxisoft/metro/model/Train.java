package com.lxisoft.metro.model;

public class Train{
	
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
	
	public String  getTrainName(){
		return trainName;
	}

	public String  getTrainId(){
		return trainId;
	}
	
/*	public void setCompartment(Compartment compartment){
		this.compartment=compartment;	
	}
	
	public Compartment getCompartment(){
		return compartment;
	}*/
	
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
	
	
	
}