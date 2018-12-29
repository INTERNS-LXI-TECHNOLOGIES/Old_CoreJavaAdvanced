package com.lxisoft.snakeNLadder.model;

/** Represents a Dice.
 * @author Deepthi E
*/
public class Dice{
	
/*Represents the sides of a Dice.
*/	
	public int NUMBER_OF_SIDES=6;
	
/** Roll the dice.
 * @return A integer representing the side of a dice.
*/
    public  int roll(){
         return r.nextInt(NUMBER_OF_SIDES) + 1;
    }
}