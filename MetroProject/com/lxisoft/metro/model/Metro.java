package com.lxisoft.metro.model;

import java.util.ArrayList;
public class Metro{

	private Admin admin;
	private ArrayList<Train> trainList;
	public void setAdmin(Admin admin){

		this.admin=admin;
	}
	public Admin getAdmin(){

		return admin;
	}
	public void setTrain(ArrayList<Train> trainList){

		this.trainList=trainList;
	}
	public ArrayList<Train> getTrain(){

		return trainList;
	}

} 