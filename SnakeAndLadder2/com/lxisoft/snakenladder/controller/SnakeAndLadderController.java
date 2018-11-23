package com.lxisoft.snakenladder.controller;

import com.lxisoft.snakenladder.clearscreen.*;
import java.util.*;
public class SnakeAndLadderController{

	BoardController board=new BoardController();
	PlayerController[] player=new PlayerController[10];
	Cls clear=new Cls();
	Scanner scan=new Scanner(System.in);
	int playerno,i;
		int point,points;
	public SnakeAndLadderController() throws Exception{
		board.printCell();
		gamePlayer();
		System.out.println("Game Start.......\n ");
		playGame();
	}
	public void gamePlayer()
	{
		System.out.println("Enter no:of players: ");
		playerno=scan.nextInt();
		System.out.println("Coins of "+playerno+" Player's are:\n");
		for(int id=0;id<playerno;id++)
		{
			player[id]=new PlayerController(id);
		}
	}
	public void playGame() throws Exception{

		do{
		for(int i=0;i<playerno;i++){
			point=player[i].point[i];
			if(point<=100){
		
		player[i].startPlay(i);
		moveCoin(i);
		//clear.cls();
	}
	}
}while(point<=100);
		
}

public void moveCoin(int id1){
		
			System.out.println(player[id1].point[id1]);
			if(player[id1].point[id1]<100){
			if(player[id1].dieno==1||player[id1].dieno==6){
				System.out.println("Roll again: "+player[id1].name);
				player[id1].rollDie(id1);
			}
			}
			else if(player[id1].point[id1]==100){

				System.out.println("You win...\n"+"Winner is....:  "+player[id1].name);
				System.exit(0);
			}
			if(player[id1].point[id1]==0&&player[id1].dieno==1)
			{

				player[id1].point[id1]=1;
				points=player[id1].point[id1];
				player[id1].setPoint(id1,points);
				
			}
			else if(player[id1].point[id1]==0&&player[id1].dieno>=2)
			{
				player[id1].point[id1]=0;
				points=player[id1].point[id1];
				player[id1].setPoint(id1,points);
				
			}
			else if(player[id1].point[id1]>=1&&player[id1].point[id1]<=94&&player[id1].dieno>=1){

				player[id1].point[id1]+=player[id1].dieno;
				points=player[id1].point[id1];
				player[id1].setPoint(id1,points);
				snakeCheck(id1);
				ladderCheck(id1);	
			}
			else if(player[id1].point[id1]>94&&player[id1].point[id1]<=100){
				finalFinishing(id1);
					
			}
			else{
				player[id1].point[id1]=0;
				points=player[id1].point[id1];
				player[id1].setPoint(id1,points);
				
			}
		

	}
	public void snakeCheck(int sid){
		if(player[sid].point[sid]==board.sh1)
		{
			player[sid].point[sid]=board.st1;
			points=player[sid].point[sid];
			player[sid].setPoint(sid,points);
			System.out.println("snake1 Entry");
		}
		else if(player[sid].point[sid]==board.sh2){

			player[sid].point[sid]=board.st2;
			points=player[sid].point[sid];
			player[sid].setPoint(sid,points);
			System.out.println("snake2 Entry");
		}
		else if(player[sid].point[sid]==board.sh3){

			player[sid].point[sid]=board.st3;
			points=player[sid].point[sid];
			player[sid].setPoint(sid,points);
			System.out.println("snake3 Entry");
		}
		else if(player[sid].point[sid]==board.sh4){

			player[sid].point[sid]=board.st4;
			points=player[sid].point[sid];
			player[sid].setPoint(sid,points);
			System.out.println("snake4 Entry");
		}

		
		

	}
	public void ladderCheck(int lid){

		if(player[lid].point[lid]==board.lh1)
		{
			player[lid].point[lid]=board.lt1;
			points=player[lid].point[lid];
			player[lid].setPoint(lid,points);
			System.out.println("ladder1 Entry");
			player[lid].rollDie(lid);
		}
		else if(player[lid].point[lid]==board.lh2){

			player[lid].point[lid]=board.lt2;
			points=player[lid].point[lid];
			player[lid].setPoint(lid,points);
			System.out.println("ladder2 Entry");
			player[lid].rollDie(lid);
		}
		else if(player[lid].point[lid]==board.lh3){

			player[lid].point[lid]=board.lt3;
			points=player[lid].point[lid];
			player[lid].setPoint(lid,points);
			System.out.println("ladder3 Entry");
			player[lid].rollDie(lid);
		}
		else if(player[lid].point[lid]==board.lh4){

			player[lid].point[lid]=board.lt4;
			points=player[lid].point[lid];
			player[lid].setPoint(lid,points);
			System.out.println("ladder4 Entry");
			player[lid].rollDie(lid);
		}
		
	}
	public void finalFinishing(int id2){

	if(player[id2].point[id2]==95&&player[id2].dieno<=5){
		player[id2].point[id2]+=player[id2].dieno;
		points=player[id2].point[id2];
		player[id2].setPoint(id2,points);
		snakeCheck(id2);
	}
	else if(player[id2].point[id2]==96&&player[id2].dieno<=4){
		player[id2].point[id2]+=player[id2].dieno;
		points=player[id2].point[id2];
		player[id2].setPoint(id2,points);
		snakeCheck(id2);

	}
	else if(player[id2].point[id2]==97&&player[id2].dieno<=3){
		player[id2].point[id2]+=player[id2].dieno;
		points=player[id2].point[id2];
		player[id2].setPoint(id2,points);
		snakeCheck(id2);
	}
	else if(player[id2].point[id2]==98&&player[id2].dieno<=2){
		player[id2].point[id2]+=player[id2].dieno;
		points=player[id2].point[id2];
		player[id2].setPoint(id2,points);
		snakeCheck(id2);
	}
	else if(player[id2].point[id2]==99&&player[id2].dieno==1){
		player[id2].point[id2]+=player[id2].dieno;
		points=player[id2].point[id2];
		player[id2].setPoint(id2,points);
	}


}
}