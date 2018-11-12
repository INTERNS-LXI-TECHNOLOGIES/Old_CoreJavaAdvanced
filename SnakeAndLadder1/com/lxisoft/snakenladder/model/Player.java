package com.lxisoft.snakenladder.model;

public class Player{

	String name;
	int point;
	public Player(String name){

		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPoint(int point){
		this.point=point;
	}
	public int getPoint(){
		return point;
	}
}