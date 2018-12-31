package com.lxisoft.game.model;

import java.util.ArrayList;
public class Dice{

	private ArrayList<Integer> dice_No=new ArrayList<Integer>();

	public void setDice_No(ArrayList<Integer> dice_No){

		this.dice_No=dice_No;
	}
	public ArrayList<Integer> getDice_No(){

		return dice_No;
	}

	
}