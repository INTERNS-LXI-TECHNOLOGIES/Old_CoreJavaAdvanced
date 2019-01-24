package com.lxisoft.metro.model;

public class Passenger{
	private String name;
	private String mobileNumber;
	
	public Passenger(String name){
		this.name=name;
	}
	
	public String  getName(){
		return name;
	}
	
	public void setMobileNumber(String mobileNumber){
		this.mobileNumber=mobileNumber;	
	}
	
	public String  getMobileNumber(){
		return mobileNumber;
	}
	
	public boolean equals(Object o) {
		if((o instanceof Passenger) &&(((Passenger)o).name == name)) {
			return true;
			} else {
			return false;}
	}
	public int hashCode() {
		return name.length(); }
	public String toString(){ 
		return name+" "+mobileNumber+" ";  
	}
}