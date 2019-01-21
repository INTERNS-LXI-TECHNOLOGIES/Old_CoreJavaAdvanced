package com.lxisoft.metro.model;
import java.util.*;

public class Metro{
private Admin admin;
private Train train;
private ArrayList<Train> trainList=new ArrayList<Train>(); 
	
	
public void setTrainList(ArrayList<Train> trainList){
	this.trainList=trainList;
}


public ArrayList<Train> getTrainList(){
	return trainList;
}

public void setAdmin(Admin admin){
		this.admin=admin;	
	}
	
	public Admin  getAdmin(){
		return admin;
	}
	
	public void setTrain(Train train){
		this.train=train;	
	}
	
	public Train  getTrain(){
		return train;
	}
}