package com.lxisoft.snakenladder.model;

public class Component{

	public int id;
	public Cell startPoint;
	public Cell endPoint;

	public void setId(int id){
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setStartPoint(Cell startPoint){
		this.startPoint=startPoint;
	}
	public Cell getStartPoint(){
		return startPoint;
	}
	public void setEndPoint(Cell endPoint){
		this.endPoint=endPoint;
	}
	public Cell getEndPoint(){
		return endPoint;
	}

}