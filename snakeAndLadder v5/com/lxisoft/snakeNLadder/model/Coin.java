package com.lxisoft.snakeNLadder.model;
/** Represents a Coin.
 * @author Deepthi E
*/
public class Coin{
	
	
	
private String colour;

/** Creates a coin with the specified colour.
 * @param colour The coin’s colour.
*/
public Coin(String colour){
	this.colour=colour;}

	
/** Gets the coin's Colour .
  * @return A String representing the coin’s colour.
*/
public String getColour() {
	return colour;}

public String toString(){ 
  return colour+" ";  
 }  
}