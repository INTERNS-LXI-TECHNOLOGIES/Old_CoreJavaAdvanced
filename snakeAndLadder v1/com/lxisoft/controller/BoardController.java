package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;

public class BoardController{
	
	Board[][] board = new Board[20][20];
	CellController cellController = new CellController();
	Snake[] snake=new Snake[10]; 
	Ladder[] ladder= new Ladder[10];

	
	
	int i,j,S,T,E,H;

	public void initBoard(){
		for (i=1;i<=10;i++){
			
			for(j=1;j<=10;j++){
				
			board[i][j]=null;
			
			}
		}
			
		printBoard();
		
	}
	public void printBoard(){
	
	cellController.initCell();
	 addSnakeAndLadder();
	
}

public void addSnakeAndLadder(){
	 snake[1] = new Snake(99,54);
	 snake[2] = new Snake(70,55);
	 snake[3] = new Snake(23,2);
     snake[4] = new Snake(65,5);
	
	 ladder[1] = new Ladder(4,19);
	 ladder[2] = new Ladder(27,32);
	 ladder[3] = new Ladder(59,68);
	 ladder[4] = new Ladder(17,85);
	 
	 /*for(i=1;i<=4;i++){
	  H=snake[i].getHeadPosition();
	  T=snake[i].getTailPosition();
	 }
	 
	 for(i=1;i<=4;i++){
	  S=ladder[i].getStartPosition();
	  E=ladder[i].getEndPosition();
	 }
	 
	*/
}

}