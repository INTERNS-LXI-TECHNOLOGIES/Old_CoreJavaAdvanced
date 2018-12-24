package com.lxisoft.game.model;

public class Ladders{

	Ladders ladderHead=new Ladders();
	Ladders ladderTail=new Ladders();

	public void setLadderHead(Ladders ladderHead){

		this.ladderHead=ladderHead;
	}
	public Ladders getLadderHead(){

		return ladderHead;
	}

	public void setLadderTail(Ladders ladderTail){

		this.ladderTail=ladderTail;
	}

	public Ladders getLadderTail(){

		return ladderTail;
	}
}