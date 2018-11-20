package com.lxisoft.snakeNladder.controller;

import com.lxisoft.snakeNladder.model.*;
import java.util.*;

public class PlayerController{
	
	Player[] player=new Player[20];
	DiceController diceController;
	Coin coin;
	int[] score = new int[100];
	Scanner scanner= new Scanner(System.in);
	
	
	int users,i,key,diceValue;
	String k;
	String  Orange,Green,Blue,Red,Yellow,Rose,Violet,Black,White,Brown;
	
	public void createPlayer(int users){
		
		for(i =1;i<=users;i++){
			player[i] = new Player(i);
			System.out.println("Name::");
			player[i].setName(scanner.nextLine());
			
			System.out.println("Select coin::");
			coin=selectCoin(i);
			player[i].setCoin(coin);
			
		}
		for(i=1;i<=users;i++){
			showPlayerList();
		}
	}
	
	public void showPlayerList(){
		
	System.out.println("Player "+player[i].getPlayerId()+":\nName::"+player[i].getName()+"\tCoin::"+player[i].getCoin().getCoinColour());
		
	}
	
	public Coin selectCoin(int i){
		
			System.out.println(">>>[0.Orange][1.Green][2.Blue][3.Red][4.Yellow][5.Rose][6.Violet][7.Black][8.White][9.Brown] ");
			k=scanner.nextLine();
			int key=Integer.parseInt(k);
			if(key==0){
			coin = new Coin(i,"Orange");}
			else if(key==1){
			coin=new Coin(i,"Green");}
			else if(key==2){
			coin = new Coin(i,"Blue");}
			else if(key==3){
			coin = new Coin(i,"Red");}
			else if(key==4){
			coin= new Coin(i,"Yellow");}
			else if(key==5){
			coin=new Coin(i,"Rose");}
			else if(key==6){
			coin= new Coin(i,"Violet");}
			else if(key==7){
			coin= new Coin(i,"Black");}
			else if(key==8){
			coin= new Coin(i,"White");}
			else if(key==9){
			coin=new Coin(i,"Brown");}
			
			return coin;
			
	}
	
	public void startPlay(int k){
		if(player[k].getScore()<=100){
		System.out.println("\n*********************\nTurn of Player  "+player[k].getName());
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
					System.out.println("Roll Again.......  "+player[id].getName());
					startRollDice(id);
				}
			}else{
				System.out.println("Congrats.........."+player[id].getName()+"  You Win the Game..........\n");
				System.exit(0);
			}		
		}
	}

		public void changeScore(int id){
		if(score[id]==0&&diceValue==1){
			score[id]=1;
			player[id].setScore(score[id]);
			System.out.println("Score::"+player[id].getScore());
		}
		else if(score[id]==0&&diceValue>=1){
			score[id]=0;
			player[id].setScore(score[id]);
			System.out.println("Score::"+player[id].getScore());

		}
		else if(score[id]>=1&&score[id]<=94&&diceValue>=1){
			score[id]+=diceValue;
			player[id].setScore(score[id]);
			System.out.println("Score::"+player[id].getScore());
			//checkForSnake(id);
			//checkForLadder(id);
		}
		else if(score[id]>94&&score[id]<=100){
			finalRound(id);
			System.out.println("Score::"+player[id].getScore());
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