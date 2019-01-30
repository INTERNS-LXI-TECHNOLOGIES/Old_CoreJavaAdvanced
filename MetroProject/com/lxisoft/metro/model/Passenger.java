package com.lxisoft.metro.model;

public class Passenger{

	private String name,spoint,dpoint;

	public Passenger(String name, String spoint, String dpoint){

		this.name=name;
		this.spoint=spoint;
		this.dpoint=dpoint;
	}
	public String toString(){

		return name+" "+spoint+" "+dpoint;
	}
}