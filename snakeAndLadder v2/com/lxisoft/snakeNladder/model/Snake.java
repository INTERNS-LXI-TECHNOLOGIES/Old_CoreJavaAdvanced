package com.lxisoft.snakeNladder.model;

public class Snake{
	int headPosition;
	int tailPosition;
	public Snake(int headPosition, int tailPosition){
	this. headPosition= headPosition;
	this.tailPosition=tailPosition;
}

public int getHeadPosition(){
	return headPosition;
}
public int getTailPosition(){
	return tailPosition;
}
}