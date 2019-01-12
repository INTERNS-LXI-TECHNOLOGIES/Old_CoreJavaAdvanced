package com.lxisoft.game.controller;

import com.lxisoft.game.model.*;
import java.util.Random;
import java.util.ArrayList;

enum DiceValues{ ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);

	DiceValues(int num){
		this.num=num;
	}
	private int num;
	public int getNum(){

		return num;
	} 
 }
public class DiceController{

	
	Random ran=new Random();
	
	public void createDice(){
		int no_Of_Sides=6;
		Dice dice=new Dice();
		for(DiceValues dv:DiceValues.values()){
			
			dice.setDice_No(dv.getNum());
		}

	}
	public int getDiceValue(){

		int diceValue=ran.nextInt(DiceValues.values().length)+1;

		return diceValue;
	}
}