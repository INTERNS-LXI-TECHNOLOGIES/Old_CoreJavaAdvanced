package com.lxisoft.snakeNLadder.controller;

import com.lxisoft.snakeNLadder.model.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

public class DiceController{

	Dice dice;
	public void createDice(){
		
		dice=new Dice();
	}
	
	public int getDiceValues(){
		
		int diceValue=dice.printDiceValue();
	
	return diceValue;
	}
}