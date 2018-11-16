package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.clearscreen.*;

public class SnakeAndLadderController {
	
	BoardController boardController = new BoardController();
	PlayerController playerController = new PlayerController();
	DiceController diceController;
	Scanner scanner = new Scanner(System.in);
	Cls clr=new Cls();

	int i,key,noOfUsers;
	String string;

	public SnakeAndLadderController() throws Exception{
		boardController.initBoard();
		startGame();
	}
	
	public void startGame()throws Exception{
				
		System.out.println("Select Number of Players....\n[1.2Players]\t[2.3Palyers]\t[3.4Players]");
		key= scanner.nextInt();
		switch(key){
				case 1:playerController.createPlayer(noOfUsers=2);
					playGame(noOfUsers=2);
				break;
				
				case 2:playerController.createPlayer(noOfUsers=3);
					playGame(noOfUsers=3);
				break;
				
				case 3:playerController.createPlayer(noOfUsers=4);
					playGame(noOfUsers=4);
				break;
				
				default:System.out.println("Invalied......");
				startGame();
			}
	}
			
	public void playGame(int users)throws Exception{
		
		System.out.println("<<<<<<<<<<<<<<<<GAME STARTS>>>>>>>>>>>>>>");
		do{
		for(i=1;i<=users;i++){
		playerController.startPlay(i);
		clr.cls();
		}
		}while(playerController.score[users]<=100);
		
	}
}