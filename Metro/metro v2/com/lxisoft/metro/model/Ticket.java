package com.lxisoft.metro.model;
import java.util.Date;

public class Ticket{

	private String passengerName;
	private String passengerAge;
	private String trainName;
	private String compartmentType;
	private int seatNo;
	private Date date;
	private int fair;

	public Ticket(Date date,String passengerName,String passengerAge,String trainName,String compartmentType,int seatNo,int fair){
		this.date=date;
		this.passengerName=passengerName;
		this.passengerAge=passengerAge;
		this.trainName=trainName;
		this.compartmentType=compartmentType;
		this.seatNo=seatNo;
		this.fair=fair;
	}
	public Date getDate(){

		return date;
	}
	public int getFair(){

		return fair;
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