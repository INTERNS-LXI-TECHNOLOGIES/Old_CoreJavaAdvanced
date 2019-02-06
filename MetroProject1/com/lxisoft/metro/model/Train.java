package com.lxisoft.metro.model;

import java.util.ArrayList;

public class Train{

	private String trainName;
	private String trainId;
	private String arraivalTime;
	private String departureTime;
	private String startPoint;
	private String destinationPoint;
	private ArrayList<Compartment> compartments;
	public Train(String trainName,String trainId,String arraivalTime,String departureTime,String startPoint,String destinationPoint,ArrayList<Compartment> compartments){

		this.trainName=trainName;
		this.trainId=trainId;
		this.arraivalTime=arraivalTime;
		this.departureTime=departureTime;
		this.startPoint=startPoint;
		this.destinationPoint=destinationPoint;
		this.compartments=compartments;
	}

	public Train(String trainName){
		
		this.trainName=trainName;
	

	}

	public String getTrainName(){

		return trainName;
	}
	public String getTrainId(){

		return trainId;
	}
	public String getArraivalTime(){

		return arraivalTime;
	}
	public String getDepartureTime(){

		return departureTime;
	}
	public String getStartPoint(){

		return startPoint;
	}
	public String getDestinationPoint(){

		return destinationPoint;
	}
	
	public ArrayList<Compartment> getCompartment(){

		return compartments;
	}
	public String toString(){

		return trainName + " "+trainId+""+arraivalTime+""+departureTime+""+startPoint+""+destinationPoint+""+compartments;
	}
	public boolean equals(Object o){

		
		if(o==null){
			return false;
		}
		if(this==o){

			return true;
		}
		if(o instanceof Train){

			Train train=(Train) o;

			return trainName.equals(train.trainName);
		}
		else{

			return false;
		}
	}
	public int hashCode(){

		int result=0;
		if(trainName.contains("EXP")){

			result=1;
			return result;
		}
		if(trainName.contains("PASS")){

			result=2;
			return result;
		}
		else{
			return result;
		}
	}

}