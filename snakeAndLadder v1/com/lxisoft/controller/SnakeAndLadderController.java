package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;
import com.lxisoft.controller.*;

public class SnakeAndLadderController{
	
	BoardController boardController = new BoardController();
	PlayerController playerController = new PlayerController();
	Scanner scanner = new Scanner(System.in);

	int winpoint = 100,diceValue=0,i;
	int playerPosition,noOfUsers;
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
					playGame(noOfUsers=2);
			
				break;
				
				case 2:playerController.createPlayer(noOfUsers=3);
				break;
				
				case 3:playerController.createPlayer(noOfUsers=4);
				break;
				
				default:System.out.println("Invalied......");
				startGame();
			}
	}
			
	public void playGame(int users){
		
		System.out.println("<<<<<<<<<<<<<<<<GAME STARTS>>>>>>>>>>>>>>");
		do{
		for(i=1;i<=users;i++){
		System.out.println("TURN OF PLAYER"+playerController.player[i].getPlayerId()+" :");
		System.out.println("position:"+playerController.player[i].getPosition());
		playerScore=playerController.player[i].getPosition();
			if(playerScore==0){
			System.out.println("Press a to roll Dice");
			string = scanner.nextLine();
			diceValue = playerController.rollDice();
			
				while(diceValue==1){
				//ayerPosition=1;
				playerScore=playerScore+diceValue;
				playerController.player[i].setPosition(playerScore);
			//ytem.out.println("position:"+playerController.player[i].getPosition());
				}
			}
	//ontinueGame(playerScore);
			System.out.println("position:"+playerController.player[i].getPosition());
		}
		
		}while("a".equals(string));	
		//turn playerScore;
	}
			
	public void continueGame(int playerScore){
				do{
		 if(playerPosition>=1&&playerPosition<=100){
			diceValue=playerController.rollDice();
			playerPosition=playerPosition+diceValue;
			System.out.println(playerPosition);
				}
		/*else if(playerPosition==100){
					System.out.println("Player"+i+"win");
				}*/
			
			else{
					System.out.println("*********");
				}
		}while("a".equals(string));	
	}
}