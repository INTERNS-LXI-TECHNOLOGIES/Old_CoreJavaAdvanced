package com.lxisoft.snakeNLadder.controller;
import com.lxisoft.snakeNLadder.model.*;
//import com.lxisoft.snakeNLadder.clear.*;
import java.text.*;  
import java.util.*;
import java.io.*;

/** Represents a GameController.
 * @author Deepthi E
*/

public class GameController{
	
	
	PlayerController playerControl;
	BoardController boardControl ;
	//Dice dice =new Dice();;
	CoinController coinControl= new CoinController();
	
	
	Scanner scan= new Scanner(System.in);
	int i,players,key,playerNumber,playerNumber1,diceValue;
	String coinColour,noOfPlayers;
	//String[] s=new String[20];
	Coin coin;
	
	public GameController()throws InterruptedException{
		System.out.println("\t\t\t\t---------------------");
		System.out.println("\t\t\t\t<<<SNAKE & LADDER>>>");
		System.out.println("\t\t\t\t---------------------\n");
		Date date = new Date();
	    System.out.println("Date:"+ date.toString());
		playerControl = new PlayerController();
		System.out.println(" <<[1.Player registration]>> <<[2.Player Login]>> <<[3.Exit]>>");
		System.out.println("\n\n");
		
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
		switch(key){

		    case 1: playerNumber=inputPlayerNum();
					for(i=1;i<=playerNumber;i++){
						playerControl.playerRegestration(i);
						//cls();}
		}
						printPlayerCoins(playerNumber);	
						boardControl = new BoardController();
						//playGame(playerNumber);
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
		try{
		System.out.println("Enter Number of Players::");
		noOfPlayers = scan.nextLine();}
		
		catch(NumberFormatException e) {
			System.out.println("Enter Again......\n");
			Scanner scan = new Scanner(System.in);
			noOfPlayers=scan.nextLine();
         }
		int playerNum = Integer.parseInt(noOfPlayers);
		return playerNum;
	}
	
	public void printPlayerCoins(int playerNumber1){
		for(i=1;i<=playerNumber1;i++){
		
			coin=coinControl.selectCoin(i);
			
			playerControl.playerList.get(i-1).setCoins(coin);
			//cls();
			//playerControl.player.setCoins(coinControl.coin[]);	
			}
			System.out.println("Players are-->>");
			System.out.println(playerControl.playerList);
			System.out.println("\n\n         <<<<<<<<<<<<<***********************>>>>>>>>>>>>\n\n");
	}		
}