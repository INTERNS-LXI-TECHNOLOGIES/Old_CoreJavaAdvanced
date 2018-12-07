package com.lxisoft.snakeNladder.controller;

import java.util.*;
import java.io.*;

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
	while(noOfUsers<=0){
	 try {
       System.out.print("Enter the number of Players:: ");
       noOfUsers = scanner.nextInt();

         }

        catch(InputMismatchException e) {
			 System.out.println("Enter Again......");
			break;

         }
	
	
		startGame();	
		playerController = new PlayerController();
		playerController.createPlayer(noOfUsers);
		playGame(noOfUsers);
	}
	}
	
	public void playGame(int users){
		
		System.out.println("<<<<<<<<<<<<<<<<GAME STARTS>>>>>>>>>>>>>>");
		
		do{
		for(i=1;i<=users;i++){
		playerController.startPlay(i);
		changeScore(i);
		playerPosition(i);
		}
		}while(playerController.score[users]<=100);
		
	}
	
	
	public void playerPosition(int id0){
		if(playerController.player[id0].getScore()<100){

			if(playerController.diceValue==1||playerController.diceValue==6){
				System.out.println("Roll Again.......  "+playerController.player[id0].getName());
				playerController.startRollDice(id0);
				}
			}else{
				System.out.println("Congrats.........."+playerController.player[id0].getName()+"  You Win the Game..........\n");
				System.exit(0);
			}			
	}
	
	public void changeScore(int id){
		if(playerController.score[id]==0&&playerController.diceValue==1){
			scoreSetting(id);
			//playerController.score[id]=1;
			//playerController.player[id].setScore(playerController.score[id]);
			System.out.println("Score::"+playerController.player[id].getScore());
		}
		else if(playerController.score[id]==0&&playerController.diceValue>=1){
			playerController.score[id]=0;
			playerController.player[id].setScore(playerController.score[id]);
			System.out.println("Score::"+playerController.player[id].getScore());

		}
		else if(playerController.score[id]>=1&&playerController.score[id]<=94&&playerController.diceValue>=1){
			scoreSetting(id);
			System.out.println("Score::"+playerController.player[id].getScore());
			snakeCheck(id);
			ladderCheck(id);
		}
		else if(playerController.score[id]>94&&playerController.score[id]<=100){
			finalRound(id);
			System.out.println("Score::"+playerController.player[id].getScore());
		}
	}

	public void finalRound(int id1){
		if(playerController.score[id1]==95&&playerController.diceValue<6){
			scoreSetting(id1);
		}
		else if(playerController.score[id1]==96&&playerController.diceValue<5){
			scoreSetting(id1);
		}
		else if(playerController.score[id1]==97&&playerController.diceValue<4){
			scoreSetting(id1);
		}
		else if(playerController.score[id1]==98&&playerController.diceValue<3){
			scoreSetting(id1);
		}
		else if(playerController.score[id1]==99&&playerController.diceValue==1){
			scoreSetting(id1);
		}
	
	}
	
	public void scoreSetting(int id4){
			playerController.score[id4]+=playerController.diceValue;
			playerController.player[id4].setScore(playerController.score[id4]);
	}
	
	public void snakeCheck(int id2){

		if(playerController.score[id2]==boardController.sh1){
			System.out.println("Ooops..... Snake!");
			playerController.score[id2]=boardController.st1;
			playerController.player[id2].setScore(playerController.score[id2]);
			System.out.println("Fall to "+playerController.player[id2].getScore());
		}
		else if(playerController.score[id2]==boardController.sh2){
			System.out.println("Ooops..... Snake2!");
			playerController.score[id2]=boardController.st2;
			playerController.player[id2].setScore(playerController.score[id2]);
			System.out.println("Fall to "+playerController.player[id2].getScore());
		}
		else if(playerController.score[id2]==boardController.sh3){
			System.out.println("Ooops..... Snake3!");
			playerController.score[id2]=boardController.st3;
			playerController.player[id2].setScore(playerController.score[id2]);
			System.out.println("Fall to "+playerController.player[id2].getScore());
		}
		else if(playerController.score[id2]==boardController.sh4){
			System.out.println("Ooops..... Snake4!");
			playerController.score[id2]=boardController.st4;
			playerController.player[id2].setScore(playerController.score[id2]);
			System.out.println("Fall to "+playerController.player[id2].getScore());
		}
	}
	
	public void ladderCheck(int id3){
	
		if(playerController.score[id3]==boardController.ls1){
			System.out.println("Wow..... Ladder1!");
			playerController.score[id3]=boardController.le1;
			playerController.player[id3].setScore(playerController.score[id3]);
			System.out.println(">>>>>>>>>>Jumb to "+playerController.player[id3].getScore()+"<<<<<<<<<<\nRoll again......"+playerController.player[id3].getName());
			playerController.startRollDice(id3);
			}
		else if(playerController.score[id3]==boardController.ls2){
			System.out.println("Wow..... Ladder2!");
			playerController.score[id3]=boardController.le2;
			playerController.player[id3].setScore(playerController.score[id3]);
			System.out.println(">>>>>>>>>>Jumb to "+playerController.player[id3].getScore()+"<<<<<<<<<<\nRoll again......"+playerController.player[id3].getName());
			playerController.startRollDice(id3);
		}
		else if(playerController.score[id3]==boardController.ls3){
			System.out.println("Wow..... Ladder3!");
			playerController.score[id3]=boardController.le3;
			playerController.player[id3].setScore(playerController.score[id3]);
			System.out.println(">>>>>>>>>>Jumb to "+playerController.player[id3].getScore()+"<<<<<<<<<<\nRoll again......"+playerController.player[id3].getName());
			playerController.startRollDice(id3);
		}
		else if(playerController.score[id3]==boardController.ls4){
			System.out.println("Wow..... Ladder4!");
			playerController.score[id3]=boardController.le4;
			playerController.player[id3].setScore(playerController.score[id3]);
			System.out.println(">>>>>>>>>>Jumb to "+playerController.player[id3].getScore()+"<<<<<<<<<<\nRoll again......"+playerController.player[id3].getName());
			playerController.startRollDice(id3);
		}
		
	}
	
}