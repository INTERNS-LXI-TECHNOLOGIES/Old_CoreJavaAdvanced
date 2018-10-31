package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;
import com.lxisoft.controller.*;

public class SnakeAndLadderController{
	
	BoardController boardController = new BoardController();
	PlayerController playerController = new PlayerController();
	Scanner scanner = new Scanner(System.in);
	int WINPOINT = 100;
	
	
	public SnakeAndLadderController(){
		boardController.initBoard();
		startGame();
	}
	
	public void startGame(){
		
		playerController.createPlayer();
	
	int player1 =0, player2=0;
	int currentPlayer=-1;
	String string;
	int diceValue =0;
	do{
		
		System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
		System.out.println("Press a to roll Dice");
		string = scanner.next();
		diceValue = playerController.rollDice();
		
		
		if(currentPlayer == -1){
			
			player1 = calculatePlayerValue(player1,diceValue);
			System.out.println("First Player :: " + player1);
			System.out.println("Second Player :: " + player2);
			System.out.println("------------------\n<<<<<<<<<<<>>>>>>>>>>>");
			if(isWin(player1))
			{
				System.out.println("Winner : First Player");
				return;
			}
		}
		
		else{
			
			player2 = calculatePlayerValue(player2,diceValue);
			System.out.println("First Player :: " + player1);
			System.out.println("Second Player :: " + player2);
			System.out.println("------------------\n<<<<<<<<<<<>>>>>>>>>>>");
			if(isWin(player2))
			{
				System.out.println("Winner : Second Player");
				return;
			}
		}
		
		currentPlayer= -currentPlayer;
			
	}while("a".equals(string));
}

public int calculatePlayerValue(int playerScore, int diceValue){
	
	System.out.println("Dice :"+diceValue);
	playerScore = playerScore + diceValue;
	
	if(playerScore > WINPOINT){
		
		playerScore = playerScore - diceValue;
		return playerScore;
	}
	
	/*if(null!=boardController.snake.get(playerController.player)){
		
		System.out.println("swallowed by snake");
		playerScore=boardController.snake.get(playerController.player);
	}
	
	if(null!=boardController.ladder.get(playerController.player)){
		
		System.out.println("climb up the ladder");
		playerScore= boardController.ladder.get(playerController.player);
	}*/
	return playerScore;
}

public boolean isWin(int playerScore){
	
	return WINPOINT == playerScore;
}

}
