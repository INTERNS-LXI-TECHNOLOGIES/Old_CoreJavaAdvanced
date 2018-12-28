package com.lxisoft.game.model;

import java.util.*;

public class Board{

	private ArrayList<Cell> cells=new ArrayList<Cell>();
	private ArrayList<Snake> snakes=new ArrayList<Snake>();
	private ArrayList<Ladder> ladders=new ArrayList<Ladder>();


	public void setCells(ArrayList<Cell> cells){

		this.cells=cells;
		
	}
	public ArrayList<Cell> getCells(){

		return cells;
	}
	public void setSnakes(ArrayList<Snake> snakes){

		this.snakes=snakes;
	}
	public ArrayList<Snake> getSnakes(){

		return snakes;
	}
	public void setLadders(ArrayList<Ladder> ladders){

		this.ladders=ladders;
	}
	public ArrayList<Ladder> getLadders(){

		return ladders;
	}

	/**public String toString(){
		return getCells();
	}*/

}
