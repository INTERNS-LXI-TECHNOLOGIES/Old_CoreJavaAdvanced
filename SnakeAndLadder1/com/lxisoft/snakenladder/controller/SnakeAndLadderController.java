package com.lxisoft.snakenladder.controller;

import java.util.*;
public class SnakeAndLadderController{

	BoardController board=new BoardController();
	PlayerController[] player=new PlayerController[10];
	DieController die;
	Scanner scan=new Scanner(System.in);
	int playerno,i;
		int point=0;
	public SnakeAndLadderController(){
		board.printCell();
		gamePlayer();
		System.out.println("Game Start.......\n ");
		startGame();
	}
	public void gamePlayer()
	{
		System.out.println("Enter no:of players:   1.[One]  2.[Two]  3.[Three]  4.[Four]");
		playerno=scan.nextInt();
		System.out.println("Coins of "+playerno+" Player's are:\n");
		for(int id=0;id<playerno;id++)
		{
			player[id]=new PlayerController(id);
		}
	}
	public void playGame(){

		for(int i=0;i<playerno;i++){
			if(player[i].point[i]<=100){
		
		player[i].startPlay(i);
	}
	}
		
}
public void startGame()
{
	

	do{
	
	for(int j=0;j<playerno;j++)
	{
		
		for(int i=0;i<=j;i++)
		{
			
			playGame();
			point=player[j].point[i];
		}

	}
}while(point<=100);

}	

}