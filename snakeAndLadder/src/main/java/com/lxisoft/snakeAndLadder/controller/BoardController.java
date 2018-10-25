package com.lxisoft.snakeAndLadder.controller;

import java.util.Random;

import com.lxisoft.snakeAndLadder.model.*;

public class BoardController {

	Board[][] board = new Board[20][20];
	Snake snake = new Snake();
	Ladder ladder = new Ladder();
	int i,j;
	int num=100;
	int num1;
public BoardController(){
	
	initBoard();
	printBoard();
	
}
	
	public void initBoard(){
		
		
		for (i=1;i<=10;i++){
			
			for(j=1;j<=10;j++){
				
			board[i][j]=null;
			
			}
		}		
	}

public void printBoard(){
	
	for(i=1;i<=10;i++)
		
	{ 
		if(i%2==1)
		{
		for(j=1;j<=10;j++)
		{
			if(board[i][j]==null)
			{
				System.out.print(num+"\t");
				num--;
			}
			else
			{
			
			}
		}
		//num1=num-9;
		
		}
		else
		{
		 num=num-10;
			for(j=1;j<=10;j++)
			{
				num++;
				System.out.print(num+"\t");
			}
			num=num-10;
		}
		
		System.out.println("\n\n\n");
		}		
}

}

