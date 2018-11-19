package com.lxisoft.snakeNladder.controller;

import java.util.*;
import com.lxisoft.snakeNladder.model.Dice;

public class DiceController{
	Dice dice;
	Random ran = new Random();
	int diceValue;
	public DiceController(){
		diceValue=rollDice();
		dice= new Dice(diceValue);
		System.out.println("\n You get:"+dice.getDiceValue());
	}
	public int rollDice()
	{
	    int n = 0;
	    n=ran.nextInt(7);
	    return (n==0?1:n);
	}
	
}