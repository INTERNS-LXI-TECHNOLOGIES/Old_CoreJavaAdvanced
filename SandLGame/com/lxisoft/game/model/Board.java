package com.lxisoft.game.model;

import java.util.*;

public class Board{

	private ArrayList<Cells> cellNum=new ArrayList<Cells>();
	private ArrayList<Snakes> snakes=new ArrayList<Snakes>();
	private ArrayList<Ladders> ladders=new ArrayList<Ladders>();


	public void setCells(ArrayList<Cells> cellNum){

		this.cellNum=cellNum;
	}
	public ArrayList<Cells> getCells(){

		return cellNum;
	}
	public void setSnakes(ArrayList<Snakes> snakes){

		this.snakes=snakes;
	}
	public ArrayList<Snakes> getSnakes(){

		return snakes;
	}
	public void setLadders(ArrayList<Ladders> ladders){

		this.ladders=ladders;
	}
	public ArrayList<Ladders> getLadders(){

		return ladders;
	}



}
