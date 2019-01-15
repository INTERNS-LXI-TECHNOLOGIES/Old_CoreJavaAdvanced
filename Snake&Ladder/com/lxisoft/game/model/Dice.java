package com.lxisoft.game.model;
/**Represents a Dice
*@author Sumi G
*/
import java.util.ArrayList;
import java.util.Random;
enum DiceValues{ ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);

	DiceValues(int num){
		this.num=num;
	}
	private int num;
	public int getNum(){

		return num;
	} 
 }
public class Dice{

	ArrayList<DiceValues> diceValues=new ArrayList<DiceValues>();

	public Dice(){
		for(DiceValues dvs:DiceValues.values()){
			diceValues.add(dvs);
		}

	}
	public int getDiceValue(){

		Random ran=new Random();
		diceValues=getDiceVal();
		return diceValues.get(ran.nextInt(diceValues.size())).getNum();
	}
	
	/**Gets the dice number
	*@return A int representing dice's number 
	*/
	public ArrayList<DiceValues>  getDiceVal(){

		return diceValues;
	}
}
	