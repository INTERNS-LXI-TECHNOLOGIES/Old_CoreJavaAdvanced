package com.lxisoft.controller;

import java.util.Random;
import java.util.Scanner;

import com.lxisoft.model.*;

public class PlayerController {
	
	int i,position,diceValue,id1,id;
	String name,string;
	BoardController boardController;
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
		System.out.println("Turn of Player"+player[k].getPlayerId());
//System.out.println("Score:"+player[k].getScore());
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
					System.out.println("Roll Again.......");
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

}