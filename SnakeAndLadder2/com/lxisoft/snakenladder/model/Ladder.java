package com.lxisoft.snakenladder.model;

public class Ladder {


int ladderStart,ladderEnd;
	public Ladder(int ladderStart, int ladderEnd) {
		this.ladderStart=ladderStart;
		this.ladderEnd=ladderEnd;
		
	}
	public int getLadderStart()
	{
		return ladderStart;
	}
	public int getLadderEnd()
	{
		return ladderEnd;
	}
}


