package com.lxisoft.metro.model;

public class Passenger{

	private String pName;
	private String mobno;

	public Passenger(String pName,String mobno){

		this.pName=pName;
		this.mobno=mobno;
	}
	public String getPassengerName(){

		return pName;
	}
	public String getPassengerMobile(){

		return mobno;
	}

}