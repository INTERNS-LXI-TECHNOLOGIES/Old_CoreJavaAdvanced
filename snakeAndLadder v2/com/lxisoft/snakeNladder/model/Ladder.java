package com.lxisoft.snakeNladder.model;

public class Ladder{
	int startPosition;
	int endPosition;
	public Ladder(int startPosition, int endPosition){
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}
	
	public int getEndPosition(){
	return endPosition;
	}

	public int getStartPosition(){
	return startPosition;
	}
	
}