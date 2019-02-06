package com.lxisoft.metro.model;

public class Ticket{

	private String passengerName;
	private String passengerAge;
	private String trainName;
	private String compartmentType;
	private int seatNo;

	public Ticket(String passengerName,String passengerAge,String trainName,String compartmentType,int seatNo){

		this.passengerName=passengerName;
		this.passengerAge=passengerAge;
		this.trainName=trainName;
		this.compartmentType=compartmentType;
		this.seatNo=seatNo;
	}
	public String getPassengerName(){

		return passengerName;
	}
	public String getPassengerAge(){

		return passengerAge;
	}
	public String getTrainName(){

		return trainName;
	}
	public String getCompartmentType(){

		return compartmentType;
	}
	public int getSeatNo(){

		return seatNo;
	}
}