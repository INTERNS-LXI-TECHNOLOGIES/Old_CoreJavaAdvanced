package com.lxisoft.snakenladder.controller;

import com.lxisoft.snakenladder.clearscreen.*;
import java.util.*;
public class SnakeAndLadderController{

	BoardController board=new BoardController();
	PlayerController[] player=new PlayerController[10];
	DieController die;
	Cls clear=new Cls();
	Scanner scan=new Scanner(System.in);
	int playerno,i;
		int point;
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
		clear.cls();
	}
	}
}while(point<=100);
		
}

}