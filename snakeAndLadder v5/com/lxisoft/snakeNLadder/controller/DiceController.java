package com.lxisoft.snakeNLadder.controller;

import com.lxisoft.snakeNLadder.model.*;
import java.util.Random;
import java.util.ArrayList;

enum DiceValues{ ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);

	DiceValues(int number){
		this.number=number;
	}
	private int number;
	public int getNumber(){

		return number;
	} 
 }
public class DiceController{

	Dice dice=new Dice();
	Random ran=new Random();
	int no_Of_Sides=6;
	public void createDice(){

		for(DiceValues dv:DiceValues.values()){
			
			dice.setDice_No(dv.getNumber());
		}

	}
	public int getDiceValue(){

		int diceValue=ran.nextInt(no_Of_Sides) + 1;
		//System.out.println(diceValue);
		return diceValue;
	}
}