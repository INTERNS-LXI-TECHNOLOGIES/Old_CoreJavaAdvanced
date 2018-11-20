package com.lxisoft.snakeNladder.controller;

import java.util.*;

public class SnakeAndLadderController{
	BoardController boardController;
	PlayerController playerController;
	
	int noOfUsers,i;
	Scanner scanner= new Scanner(System.in);
	
	public SnakeAndLadderController(){
		System.out.println("\t\t\t\t---------------------");
		System.out.println("\t\t\t\t<<<SNAKE & LADDER>>>");
		System.out.println("\t\t\t\t---------------------");
		boardController = new BoardController();
		startGame();
	}
	
	
	public void startGame(){				
		System.out.println("Enter number of users::");
		noOfUsers=scanner.nextInt();
		playerController = new PlayerController();
		playerController.createPlayer(noOfUsers);
		playGame(noOfUsers);
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