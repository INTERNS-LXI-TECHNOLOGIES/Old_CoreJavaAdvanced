
package com.lxisoft.game.controller;

import com.lxisoft.game.model.*;
import java.util.Random;
import java.util.ArrayList;
public class DiceController{

	Dice dice=new Dice();
	Random ran=new Random();
	int no_Of_Sides=6;
	ArrayList<Integer> dice_No=new ArrayList<Integer>();
	public void createDice(){

		for(int i=1;i<=no_Of_Sides;i++){

			dice_No.add(i);
			dice.setDice_No(dice_No);
		}

	}
	public void getDiceValue(){

		int diceValue=ran.nextInt(no_Of_Sides) + 1;
		System.out.println(diceValue);

	}
}