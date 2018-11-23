package com.lxisoft.snakenladder.model;

public class Board{

	private int sHead,sTail;
	private int lStart,lEnd;

	public void setComponent(int sHead,int sTail,int lStart,int lEnd){
		this.sHead=sHead;
		this.sTail=sTail;
		this.lStart=lStart;
		this.lEnd=lEnd;
	}
	public int getSnakeHead(){
		return sHead;
	}
	public int getSnakeTail(){
		return sTail;
	}
	public int getLadderStart(){
		return lStart;
	}
	public int getLadderEnd(){
		return lEnd;
	}

}