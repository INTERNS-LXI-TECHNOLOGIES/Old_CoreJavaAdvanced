package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;
import com.lxisoft.controller.*;

public class SnakeAndLadderController{
	
	BoardController boardController = new BoardController();
	PlayerController playerController = new PlayerController();
	Scanner scanner = new Scanner(System.in);

	int winpoint = 100,diceValue=0,i;
	int playerPosition=0,noOfUsers;
	int playerScore=0;
	int currentPlayerPosition=0;
	String string;
	
	
	public SnakeAndLadderController(){
		boardController.initBoard();
		startGame();
	}
	
			public void startGame(){
			
			noOfUsers=playerController.createPlayer();
			int currentPlayer;
		
			for (currentPlayer=1;currentPlayer<=noOfUsers;currentPlayer++){
			do{
			System.out.println(currentPlayer+"PLAYER TURN");
		    System.out.println("Press a to roll Dice");
			string = scanner.next();
			diceValue=playerController.rollDice();
			System.out.println(diceValue);
			}
			while(diceValue==1);
			
			
				playerPosition=1;
				
			//continuePlay();
			}
			while("a".equals(string));
			
			}
			
			
			//public void startPlay(int currentPlayer){
			//do{
				 //int player=currentPlayer;
			
				//continuePlay();
				
				
			
		
			
			//public void continuePlay(){
			//	do{
			//diceValue=playerController.rollDice();
				//playerPosition=calculatePlayerValue(playerPosition,diceValue);
//playerPosition=calculatePlayerValue(playerPosition,diceValue);
				
			//currentPlayerPosition=playerPosition;
			
			/*System.out.println(currentPlayer+" Player :: " + playerPosition);
			System.out.println("------------------\n<<<<<<<<<<<>>>>>>>>>>>");
			if(isWin(currentPlayer))
			{
				System.out.println("Winner"+currentPlayer+"Player");
				return;
			}
		}
			while("a".equals(string));
		}*/
	
	public int calculatePlayerValue(int playerScore, int diceValue){
	
	System.out.println("Dice :"+diceValue);
	playerScore = playerScore + diceValue;
	
	if(playerScore > winpoint){
		
		playerScore = playerScore - diceValue;
	
	}
	return playerScore;
	}

	
	public boolean isWin(int playerScore){
	
	return winpoint== playerScore;
}
}