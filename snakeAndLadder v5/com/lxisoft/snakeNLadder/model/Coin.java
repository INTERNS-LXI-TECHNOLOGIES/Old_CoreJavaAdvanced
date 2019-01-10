package com.lxisoft.snakeNLadder.model;

import java.util.*;

/** Represents a Coin.
  * @author Deepthi E
  */
public class Coin{
	
	private String colour;
	
	public Coin(String colour){
		this.colour=colour;
	}
	public Coin(){
	
	}
	
	

private ArrayList<String> coinList= new ArrayList<String>();

/** Creates an ArrayList of playerCoins with the specified colour.
  * @param playerCoin's The player’s coin with a String colour.
  */
public void setPlayerCoins(ArrayList<String> coinList){
	this.coinList=coinList;
}


/** Gets the playerCoins from the ArrayList .
  * @return An ArrayList of String representing the playerCoin's colour.
  */
public ArrayList<String> getPlayerCoins(){
	return coinList;
}


	
public String toString(){ 
		return " Coin::"+colour+" ";  
		}  
	
		
		
		
		
		
		
		
		
		
		
		
}