package com.lxisoft.snakeNLadder.model;
import java.util.*;
import java.util.Random;
/**
 * Represents DiceValues as enum. 
 */ 
  enum DiceValues{ ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);

	DiceValues(int number){
		this.number=number;
	}
	private int number;
	public int getNumber(){

		return number;
	} 
  
  }
 /** Represents a Dice.
  * @author Deepthi E
  */ 
  
	public class Dice{
	Random ran= new Random();
	List<DiceValues> diceValue=new ArrayList<DiceValues>();
	public Dice(){
	
	for(DiceValues diceval:DiceValues.values()){
		diceValue.add(diceval);
			}
		}
	public List<DiceValues> getDiceValue(){
		return diceValue;
	}
	
	public void printDiceValue(){
	DiceValues value=getDiceValue().get(ran.nextInt(getDiceValue().size()));
	int rollDiceValue=value.getNumber();
	System.out.println(rollDiceValue);

	}
	
}