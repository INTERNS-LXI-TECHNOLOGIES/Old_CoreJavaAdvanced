package com.lxisoft.snakeNladder.model;

public class Ladder {
	int ladderStart;
	int ladderEnd;

	public int getLadderStart() {
	return ladderStart;
	}

	public void setLadderStart(int ladderStart) {
	this.ladderStart = ladderStart;
	}
	public int getLadderEnd() {
	return ladderEnd;
	}

	public void setLadderEnd(int ladderEnd) {
	this.ladderEnd = ladderEnd;
	}
	
	public String toString(){ 
	return ladderStart+" ";  
	}  
}