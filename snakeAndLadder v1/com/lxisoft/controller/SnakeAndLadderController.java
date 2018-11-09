package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;
import com.lxisoft.controller.*;

public class SnakeAndLadderController{
	
	BoardController boardController = new BoardController();
	PlayerController playerController = new PlayerController();
	Scanner scanner = new Scanner(System.in);

	int winpoint = 100,diceValue=0,i;
	int player1position=0,player2position=0,noOfUsers;
	int playerScore=0,key;
	int currentPlayer=0;
	String string;
	
	
	public SnakeAndLadderController(){
		boardController.initBoard();
		
		
		startGame();
	}
	
			public void startGame(){
				
				
			System.out.println("Select Number of Players....\n[1.2Players]\t[2.3Palyers]\t[3.4Players]");
			
		    key= scanner.nextInt();
	
			switch(key){
				
				case 1:playerController.createPlayer(noOfUsers=2);
					playGame();
			
				break;
				
				case 2:playerController.createPlayer(noOfUsers=3);
				break;
				
				case 3:playerController.createPlayer(noOfUsers=4);
				break;
				
				default:System.out.println("Invalied......");
				startGame();
			}
			
			
			}
			
	public void playGame(){
		
	
		do{
		System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
		System.out.println("Press a to roll Dice");
		string = scanner.nextLine();
		diceValue = playerController.rollDice();
		
	
		
		if(currentPlayer == -1){
			
			player1position = calculatePlayerValue(player1position,diceValue);
			System.out.println("First Player :: " + player1position);
			System.out.println("Second Player :: " + player2position);
			System.out.println("------------------\n<<<<<<<<<<<>>>>>>>>>>>");
			if(isWin(player1position))
			{
				System.out.println("Winner : First Player");
				return;
			}
		}
		
		else{
			
			player2position = calculatePlayerValue(player2position,diceValue);
			System.out.println("First Player :: " + player1position);
			System.out.println("Second Player :: " + player2position);
			System.out.println("------------------\n<<<<<<<<<<<>>>>>>>>>>>");
			if(isWin(player2position))
			{
				System.out.println("Winner : Second Player");
				return;
			}
		}
		}while("a".equals(string));
		
		currentPlayer= -currentPlayer;

}

public int calculatePlayerValue(int playerScore, int diceValue){
	
	System.out.println("Dice :"+diceValue);
	playerScore = playerScore + diceValue;
	
	if(playerScore > winpoint){
		
		playerScore = playerScore - diceValue;
		return playerScore;
	}
	
	/*if(null!=snake.get(player)){
		
		System.out.println("swallowed by snake");
		playerScore= snake.get(player);
	}
	
	if(null!=ladder.get(player)){
		
		System.out.println("climb up the ladder");
		playerScore= ladder.get(player);
	}*/
	return playerScore;
}

public boolean isWin(int playerScore){
	
	return winpoint == playerScore;
}

}