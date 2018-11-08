package com.lxisoft.snakenladder.model;

public class Ladder {

	int lHeadPos,lTailPos;
	public Ladder(int lHeadPos, int lTailPos) {
		this.lHeadPos=lHeadPos;
		this.lTailPos=lTailPos;
		
	}
	public int getLHeadPos()
	{
		return lHeadPos;
	}
	public int getLTailPos()
	{
		return lTailPos;
	}

}
