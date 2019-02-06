package com.lxisoft.metro.model;

import java.util.ArrayList;
import java.util.HashSet;
public class Metro{

	private Admin admin;
	private HashSet<Train> trainList;
	private ArrayList<Passenger> passengerList;
	private ArrayList<Ticket> ticketList;
	public void setAdmin(Admin admin){

		this.admin=admin;
	}
	public Admin getAdmin(){

		return admin;
	}
	public void setTrain(HashSet<Train> trainList){

		this.trainList=trainList;
	}
	public HashSet<Train> getTrain(){

		return trainList;
	}
	public void setPassenger(ArrayList<Passenger> passengerList){

		this.passengerList=passengerList;
	}
	public ArrayList<Passenger> getPassenger(){

		return passengerList;
	}
	public void setTicket(ArrayList<Ticket> ticketList){

		this.ticketList=ticketList;
	}
	public ArrayList<Ticket> getTicket(){

		return ticketList;
	}

} 