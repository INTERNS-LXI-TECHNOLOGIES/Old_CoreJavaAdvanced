package com.lxisoft.metro.model;
import java.io.Serializable;

public class Train implements Comparable<Train>{

	
	private String trainName;
	private String trainId;
	private String arraivalTime;
	private String departureTime;
	private String startPoint;
	private String destinationPoint;

	public Train(){

	}
	public static Train tn(String trainName){
		Train t=new Train();

		t.trainName=trainName;
		return t;

	}
	/**public Train(String trainId){

		this.trainId=trainId;

	}
	public Train(String arraivalTime){

		this.arraivalTime=arraivalTime;
		
	}
	public Train(String departureTime){

		this.departureTime=departureTime;
	}
	*/

	public static Train dp(String destinationPoint){
		Train t=new Train();

		t.destinationPoint=destinationPoint;
		return t;
	}
	public Train(String startPoint,String destinationPoint){

		this.startPoint=startPoint;
		this.destinationPoint=destinationPoint;
	}

	public Train(String trainName,String trainId,String arraivalTime,String departureTime,String startPoint,String destinationPoint){

		this.trainName=trainName;
		this.trainId=trainId;
		this.arraivalTime=arraivalTime;
		this.departureTime=departureTime;
		this.startPoint=startPoint;
		this.destinationPoint=destinationPoint;
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
	public String toString(){

		return trainName + " "+trainId+""+arraivalTime+""+departureTime+""+startPoint+""+destinationPoint;
	}
	public int compareTo(Train train){

		return trainName.compareTo(train.getTrainName());
	}
	public boolean equals(Object o){

		Train train=(Train) o;
		if(o==null){
			return false;
		}
		if(this==o){

			return true;
		}
		if(trainName.equals(train.trainName)){

			return true;
		}
		else{

			return false;
		}
	}
	public int hashCode(){

		int result=0;
		if(trainName.contains("EXPRESS")){

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