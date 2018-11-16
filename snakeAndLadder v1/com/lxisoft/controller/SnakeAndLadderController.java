package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;
import com.lxisoft.controller.*;

public class SnakeAndLadderController{
	
	BoardController boardController = new BoardController();
	PlayerController playerController = new PlayerController();
	DiceController diceController;
	Scanner scanner = new Scanner(System.in);

	int i,key,noOfUsers;
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
		playerController.startPlay(i);
		}
		}while(playerController.score[users]<=100);
		
	}
}