package com.lxisoft.game.model;
/**Represents a Dice
*@author Sumi G
*/
import java.util.ArrayList;
public class Dice{

	private int  dice_No;

	/**Sets the dice's number
	*@param dice_No A int containing the dice's number
	*/
	public void setDice_No(int dice_No){

		this.dice_No=dice_No;
	}
	/**Gets the dice number
	*@return A int representing dice's number 
	*/
	public int getDice_No(){

		return dice_No;
	}
}
	