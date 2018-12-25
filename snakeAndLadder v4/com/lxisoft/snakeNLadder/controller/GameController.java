package com.lxisoft.snakeNLadder.controller;

import com.lxisoft.snakeNLadder.model.Coins;
import java.text.*;  
import java.util.*;
import java.io.*;

public class GameController{
	
	PlayerController playerControl = new PlayerController();
	BoardController boardControl ;
	DiceController diceControl ;
	CoinController coinControl;
	
	Scanner scan= new Scanner(System.in);
	int i,players,key,playerNumber,playerNumber1;
	String coinColour,noOfPlayers;
	String[] s=new String[20];

	public GameController(){
		System.out.println("\t\t\t\t---------------------");
		System.out.println("\t\t\t\t<<<SNAKE & LADDER>>>");
		System.out.println("\t\t\t\t---------------------");
		Date date = new Date();
	    System.out.println("Date:"+ date.toString());
		
		//System.out.println("\t\t\t\t----------WELCOME----------");
		System.out.println(" <<[1.Player registration]>> <<[2.Player Login]>> <<[3.Exit]>>");
		System.out.println("\n\n");
		
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
		switch(key){

		    case 1: playerNumber=inputPlayerNum();
					for(i=1;i<=playerNumber;i++){
						playerControl.playerRegestration(i);}
				
						printPlayerCoins(playerNumber);
						boardControl= new BoardController();
					//playGame(playerNumber);
					break;
					
			case 2: playerNumber=inputPlayerNum();
					for(i=1;i<=playerNumber;i++){
						playerControl.login();}
					break;
					
			case 3: System.exit(0);break;
		    default: System.out.println("YOU ENTERED A WRONG CHOICE");
		}
	}
	
	public int inputPlayerNum(){
		System.out.println("Enter Number of Players::");
		noOfPlayers = scan.nextLine();
		int playerNum = Integer.parseInt(noOfPlayers);
		return playerNum;
	}
	
	public void printPlayerCoins(int playerNumber1){
		for(i=1;i<=playerNumber1;i++){
			coinControl= new CoinController();
			coinControl.selectCoin(i);
			playerControl.player[i].setCoins(coinControl.coin);	
			}
			for(i=1;i<=playerNumber1;i++){
			System.out.println(playerControl.player[i]);}
			
			System.out.println("\n\n<<<<<<<<<<<<<>>>>>>>>>>>>\n\n");
	}
/*	public void playGame(int players){
		
		System.out.println("<<<<<<<<<<<<<<<<GAME STARTS>>>>>>>>>>>>>>");
		
		do{
		for(i=1;i<=players;i++){
		startPlay(i);
		changeScore(i);
		playerPosition(i);
		}
		}while(playerControl.score[players]<=100);
		
	}
	
	public void startPlay(int k){
	
		if(player[k].getScore()<=100){
		System.out.println("\n*********************\nTurn of Player  "+player[k].getName());
		startRollDice(k);

	}
	}
	
	public void startRollDice(int id){
			System.out.println("Press 0 to Roll Dice..");
			int n=scan.nextInt();
			if(n==0){
			diceControl=new DiceController();
			diceValue=diceControl.dice.getDiceValue();
			
		}
	}*/
	 
	
}