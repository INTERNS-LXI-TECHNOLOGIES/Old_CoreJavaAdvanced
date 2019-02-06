package com.lxisoft.metro.model;

import java.util.ArrayList;
public class Compartment{

	private String compartType;

	private ArrayList<Seat> seats=new ArrayList<Seat>();


	public Compartment(String compartType,ArrayList<Seat> seats){

		this.compartType=compartType;
		this.seats=seats;
	}
	public String getCompartmentType(){

		return compartType;
	}

	public ArrayList<Seat> getSeats(){

		return seats;
	}
	public String toString(){

		return compartType+""+seats;
	}

}