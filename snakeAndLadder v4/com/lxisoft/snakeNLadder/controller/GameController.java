package com.lxisoft.snakeNLadder.controller;


import com.lxisoft.snakeNLadder.model.Coins;
import com.lxisoft.snakeNLadder.clear.*;
import java.text.*;  
import java.util.*;
import java.io.*;

public class GameController{
	
	PlayerController playerControl;
	BoardController boardControl ;
	DiceController diceControl ;
	CoinController coinControl;
	
	
	Scanner scan= new Scanner(System.in);
	int i,players,key,playerNumber,playerNumber1,diceValue;
	String coinColour,noOfPlayers;
	String[] s=new String[20];

	
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
						cls();}
						printPlayerCoins(playerNumber);
						boardControl= new BoardController();
						playGame(playerNumber);
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
			playerControl.playerList.get(i-1).setCoins(coinControl.coin);
			cls();
			//playerControl.player.setCoins(coinControl.coin);	
			}
			System.out.println("Players are-->>");
			System.out.println(playerControl.playerList);
			System.out.println("\n\n<<<<<<<<<<<<<>>>>>>>>>>>>\n\n");
	}
	
	public void playGame(int players){
		
		System.out.println("<<<<<<<<<<<<<<<<GAME STARTS>>>>>>>>>>>>>>");
		
		do{
		for(i=0;i<=players;i++){
		System.out.println(playerControl.playerList.get(i).getScore());
		startPlay(i);
		changeScore(i);
		playerPosition(i);}
		}while(playerControl.score[players]<=100);
		
	}
	
	public void startPlay(int k){
	
	if(playerControl.playerList.get(k).getScore()<=100){
		//if(player[k].getScore()<=100){
		System.out.println("\n*********************\nTurn of Player  "+playerControl.playerList.get(k).getName());
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
	}
	public void playerPosition(int id0){
		if(playerControl.playerList.get(id0).getScore()<100){

			if(diceValue==1||diceValue==6){
				System.out.println("Roll Again.......  "+playerControl.playerList.get(id0).getName());
				startRollDice(id0);
				}
			}else{
				System.out.println("Congrats.........."+playerControl.playerList.get(id0).getName()+"  You Win the Game..........\n");
				System.exit(0);
			}			
	}
	
	public void changeScore(int id){
		if(playerControl.score[id]==0&&diceValue==1){
			scoreSetting(id);
			//playerController.score[id]=1;
			//playerController.player[id].setScore(playerController.score[id]);
			System.out.println("Score::"+playerControl.playerList.get(id).getScore());
		}
		else if(playerControl.score[id]==0&&diceValue>=1){
			playerControl.score[id]=0;
			playerControl.playerList.get(id).setScore(playerControl.score[id]);
			System.out.println("Score::"+playerControl.playerList.get(id).getScore());

		}
		else if(playerControl.score[id]>=1&&playerControl.score[id]<=94&&diceValue>=1){
			scoreSetting(id);
			System.out.println("Score::"+playerControl.playerList.get(id).getScore());
			snakeCheck(id);
			ladderCheck(id);
		}
		else if(playerControl.score[id]>94&&playerControl.score[id]<=100){
			finalRound(id);
			System.out.println("Score::"+playerControl.playerList.get(id).getScore());
		}
	}

	public void finalRound(int id1){
		if(playerControl.score[id1]==95&&diceValue<6){
			scoreSetting(id1);
		}
		else if(playerControl.score[id1]==96&&diceValue<5){
			scoreSetting(id1);
		}
		else if(playerControl.score[id1]==97&&diceValue<4){
			scoreSetting(id1);
		}
		else if(playerControl.score[id1]==98&&diceValue<3){
			scoreSetting(id1);
		}
		else if(playerControl.score[id1]==99&&diceValue==1){
			scoreSetting(id1);
		}
	
	}
	
	public void scoreSetting(int id4){
			playerControl.score[id4]+=diceValue;
			playerControl.playerList.get(id4).setScore(playerControl.score[id4]);
	}
	
	public void snakeCheck(int id2){

		if(playerControl.score[id2]==boardControl.sh1){
			System.out.println("Ooops..... Snake!");
			playerControl.score[id2]=boardControl.st1;
			snakeSwallowing(id2);
		}
		else if(playerControl.score[id2]==boardControl.sh2){
			System.out.println("Ooops..... Snake2!");
			playerControl.score[id2]=boardControl.st2;
			snakeSwallowing(id2);
		}
		else if(playerControl.score[id2]==boardControl.sh3){
			System.out.println("Ooops..... Snake3!");
			playerControl.score[id2]=boardControl.st3;
			snakeSwallowing(id2);
		}
		else if(playerControl.score[id2]==boardControl.sh4){
			System.out.println("Ooops..... Snake4!");
			playerControl.score[id2]=boardControl.st4;
			snakeSwallowing(id2);
		}
	}
	
	public void snakeSwallowing(int id02){
		playerControl.playerList.get(id02).setScore(playerControl.score[id02]);
		System.out.println("Fall to "+playerControl.playerList.get(id02).getScore());
		
	}
	
	public void ladderCheck(int id3){
	
		if(playerControl.score[id3]==boardControl.ls1){
			System.out.println("Wow..... Ladder1!");
			playerControl.score[id3]=boardControl.le1;
			jumbingThrowLadder(id3);
			}
		else if(playerControl.score[id3]==boardControl.ls2){
			System.out.println("Wow..... Ladder2!");
			playerControl.score[id3]=boardControl.le2;
			jumbingThrowLadder(id3);
		}
		else if(playerControl.score[id3]==boardControl.ls3){
			System.out.println("Wow..... Ladder3!");
			playerControl.score[id3]=boardControl.le3;
			jumbingThrowLadder(id3);
		}
		else if(playerControl.score[id3]==boardControl.ls4){
			System.out.println("Wow..... Ladder4!");
			playerControl.score[id3]=boardControl.le4;
			jumbingThrowLadder(id3);
		}
	}

	public void jumbingThrowLadder(int id03){
			playerControl.playerList.get(id03).setScore(playerControl.score[id03]);
			System.out.println(">>>>>>>>>>Jumb to "+playerControl.playerList.get(id03).getScore()+"<<<<<<<<<<\nRoll again......"+playerControl.playerList.get(id03).getName());
			startRollDice(id03);
	}	


	
	public void cls(){
		Cls clrscr=new Cls();
		try{
			clrscr.cls();
		}
		catch (IOException e){
			
		}
		catch (InterruptedException e){
			
		}
	}	
}