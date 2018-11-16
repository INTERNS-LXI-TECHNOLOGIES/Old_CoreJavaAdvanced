package com.lxisoft.controller;

import java.util.Random;
import java.util.Scanner;

import com.lxisoft.model.*;

public class PlayerController {
	
	
	int i,position,diceValue,id1,id,sid,lid;
	String name,string;
	BoardController boardController;
	SnakeController snakeController=new SnakeController();
	LadderController ladderController=new LadderController();
	
	Player[] player=new Player[10];
	Coin coin;
	int[] score = new int[100];
	DiceController diceController;
	Scanner scanner=new Scanner(System.in);

	public int createPlayer(int users){
		
		for(i =1;i<=users;i++){
			player[i] = new Player(i);
			System.out.println("Name:");
			player[i].setName(scanner.nextLine());
			coin = new Coin(i);			
			selectCoinColour();
			
		}
			for(i=1;i<=users;i++){
				showPlayerList();
			}
		return users;
	}
	
	public void selectCoinColour(){
		String key;
		System.out.println("****Choose a coin****\n[1.Green] [2.Blue] [3.Red] [4.Yellow]");
		key=scanner.nextLine();
		int num = Integer.parseInt(key);			

		 switch(num){
				 case 1:player[i].setCoinColour("Green\n");
				 break;
				 case 2:player[i].setCoinColour("Blue\n");
				 break;
				 case 3:player[i].setCoinColour("Red\n");
				 break;
				 case 4:player[i].setCoinColour("Yellow\n");
				 break;
				 default:System.out.println("Invalied");
			 }
	}
	public void showPlayerList(){
		
	System.out.println("Player"+player[i].getPlayerId()+":\nName:"+player[i].getName()+"\nCoin:"+player[i].getCoinColour());
		
	}
	
	public void startPlay(int k){
		if(player[k].getScore()<=100){
		System.out.println("*********************\nTurn of Player"+player[k].getPlayerId());
		startRollDice(k);
		
		}
	}
	
	public void startRollDice(int id){
			
			System.out.println("Press 0 to Roll Dice..");
			int n=scanner.nextInt();
			if(n==0){
			diceController=new DiceController();
			diceValue=diceController.dice.getDiceValue();
			changeScore(id);
			if(player[id].getScore()<100){

				if(diceValue==1||diceValue==6){
					System.out.println("Roll Again......."+player[id].getName());
					startRollDice(id);
				}
			}else{
				System.out.println("Congrats..........You Win the Game..........\nWinner:"+player[id].getName());
				System.exit(0);
			}		
		}
	}

	public void changeScore(int id){
		if(score[id]==0&&diceValue==1){
			score[id]=1;
			player[id].setScore(score[id]);
			System.out.println("Score:"+player[id].getScore());
		}
		else if(score[id]==0&&diceValue>=1){
			score[id]=0;
			player[id].setScore(score[id]);
			System.out.println("Score:"+player[id].getScore());

		}
		else if(score[id]>=1&&score[id]<=94&&diceValue>=1){
			score[id]+=diceValue;
			player[id].setScore(score[id]);
			System.out.println("Score:"+player[id].getScore());
			checkForSnake(id);
			checkForLadder(id);
		}
		else if(score[id]>94&&score[id]<=100){
			finalRound(id);
			System.out.println("Score:"+player[id].getScore());
		}
	}

	public void finalRound(int id1){
		if(score[id1]==95&&diceValue<6){
			score[id1]+=diceValue;
			player[id1].setScore(score[id1]);
		}
		else if(score[id1]==96&&diceValue<5){
			score[id1]+=diceValue;
			player[id1].setScore(score[id1]);
		}
		else if(score[id1]==97&&diceValue<4){
			score[id1]+=diceValue;
			player[id1].setScore(score[id1]);
		}
		else if(score[id1]==98&&diceValue<3){
			score[id1]+=diceValue;
			player[id1].setScore(score[id1]);
			
		}
		else if(score[id1]==99&&diceValue==1){
			score[id1]+=diceValue;
			player[id1].setScore(score[id1]);
		}
	
	}
	
	public void checkForSnake(int sid){
		//System.out.println(score[sid]);
		
		snakeController.constructSnakePosition();
		if(score[sid]==snakeController.head1){
			System.out.println("Ooops..... Snake1!");
			System.out.println(snakeController.tail1);
			score[sid]=snakeController.tail1;
			player[sid].setScore(score[sid]);
			System.out.println("Fall to "+player[sid].getScore());
		}
		else if(score[sid]==snakeController.head2){
			System.out.println("Ooops..... Snake2!");
			score[sid]=snakeController.tail2;
			player[sid].setScore(score[sid]);
			System.out.println("Fall to "+player[sid].getScore());
		}
		else if(score[sid]==snakeController.head3){
			System.out.println("Ooops..... Snake3!");
			score[sid]=snakeController.tail3;
			player[sid].setScore(score[sid]);
			System.out.println("Fall to "+player[sid].getScore());
		}
		else if(score[sid]==snakeController.head4){
			System.out.println("Ooops..... Snake4!");
			score[sid]=snakeController.tail4;
			player[sid].setScore(score[sid]);
			System.out.println("Fall to "+player[sid].getScore());
		}
	}
	
	public void checkForLadder(int lid){
		
		ladderController.constructLadderPosition();
		if(score[lid]==ladderController.start1){
			System.out.println("Wow..... Ladder1 ");
			score[lid]=ladderController.end1;
			player[lid].setScore(score[lid]);
			System.out.println(">>>>>>>>>>Jumb to "+player[lid].getScore()+"<<<<<<<<<<\nRoll again......"+player[lid].getName());
			startRollDice(lid);
			}
		else if(score[lid]==ladderController.start2){
			System.out.println("Wow..... Ladder2 ");
			score[lid]=ladderController.end2;
			player[lid].setScore(score[lid]);
			System.out.println(">>>>>>>>>>Jumb to "+player[lid].getScore()+"<<<<<<<<<<\nRoll again......"+player[lid].getName());
			startRollDice(lid);
		}
		else if(score[lid]==ladderController.start3){
			System.out.println("Wow..... Ladder3 ");
			score[lid]=ladderController.end3;
			player[lid].setScore(score[lid]);
			System.out.println(">>>>>>>>>>Jumb to "+player[lid].getScore()+"<<<<<<<<<<\nRoll again......"+player[lid].getName());
			startRollDice(lid);
		}
		else if(score[lid]==ladderController.start4){
			System.out.println("Wow..... Ladder4 ");
			score[lid]=ladderController.end4;
			player[lid].setScore(score[lid]);
			System.out.println(">>>>>>>>>>Jumb to "+player[lid].getScore()+"<<<<<<<<<<\nRoll again......"+player[lid].getName());
			startRollDice(lid);
		}
		
	}

}