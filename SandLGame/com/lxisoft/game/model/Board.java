package com.lxisoft.game.model;

import java.util.*;

public class Board{

	private ArrayList<Cell> cells=new ArrayList<Cell>();
	private HashMap<String,Snake> snakes=new HashMap<String,Snake>();
	private HashMap<String,Ladder> ladders=new HashMap<String,Ladder>();


	public void setCells(ArrayList<Cell> cells){

		this.cells=cells;
		
	}
	public ArrayList<Cell> getCells(){

		return cells;
	}
	public void setSnakes(HashMap<String,Snake> snakes){

		this.snakes=snakes;
	}
	public HashMap<String,Snake> getSnakes(){

		return snakes;
	}
	public void setLadders(HashMap<String,Ladder> ladders){

		this.ladders=ladders;
	}
	public HashMap<String,Ladder> getLadders(){

		return ladders;
	}

	/**public String toString(){
		return getCells();
	}*/

}
