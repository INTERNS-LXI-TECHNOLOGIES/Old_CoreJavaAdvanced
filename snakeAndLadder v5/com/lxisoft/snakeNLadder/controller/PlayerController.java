package com.lxisoft.snakeNLadder.controller;

import com.lxisoft.snakeNLadder.model.*;
import java.util.*;



/** Represents a PlayerController.
 * @author Deepthi E
 */

public class PlayerController{
	Player player;
	ArrayList<Player> playerList= new ArrayList<Player>();
	Scanner scan = new Scanner(System.in);
	int[] score = new int[100];
	
	public int startRollDice(Game game){
			System.out.println("Press 0 to Roll Dice..");
			int n=scan.nextInt();
			if(n==0){
			int diceValue=game.getDice.getDiceValue();	
			System.out.println("Dicevalue::"+diceValue);
			
			return diceValue;
			//changeScore(playerId);
			}
		}



}	