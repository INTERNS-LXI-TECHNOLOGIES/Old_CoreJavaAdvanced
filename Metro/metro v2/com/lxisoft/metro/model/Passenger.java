package com.lxisoft.metro.model;

public class Passenger implements Comparable<Passenger>{
	private String name;
	private String mobileNumber;
	private String age;
	
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
	public void setAge(String age){
		this.age=age;	
	}
	
	public String  getAge(){
		return age;
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
	
	public int compareTo(Passenger passenger){ 
        return name.compareTo(passenger.getName()); 
    } 
}