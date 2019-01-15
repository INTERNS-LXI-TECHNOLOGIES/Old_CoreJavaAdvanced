package com.lxisoft.snakeNLadder.model;

import java.util.*;

/** Represents a Coin.
  * @author Deepthi E
  */
public class Coin{
	
	private String colour;
//	private int id;
	
	public Coin(String colour){
	
		this.colour=colour;
	}
	public Coin(){
	
	}
	
	public String getColour(){
		return colour;
		}

	
	public String toString(){ 
		return " Coin::"+colour+" ";  
		}  
	
	
			
		
		
}