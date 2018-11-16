package com.lxisoft.snakeNladder.controller;

import java.util.*;

public class SnakeAndLadderController{
	BoardController boardController = new BoardController();
	PlayerController playerController = new PlayerController();
	
	int noOfUsers;
	Scanner scanner= new Scanner(System.in);
	
	public SnakeAndLadderController(){
		startGame();
	}
	
	
		public void startGame(){
				
		System.out.println("Enter number of users::");
		noOfUsers=scanner.nextInt();
		playerController.createPlayer(noOfUsers);
				
	}
	
}