package com.lxisoft.snakeAndLadder.controller;

import com.lxisoft.snakeAndLadder.model.*;

public class BoardController {

	Board[][] board = new Board[10][10];
	Snake snake = new Snake();
	Ladder ladder = new Ladder();
public BoardController(){
	
	printBoard();
}
	
	public void printBoard(){
		int num=100;
		for (int i=0;i<10;i++){
			
			for(int j=0;j>10;j++){
				
			board[i][j]=null;
				//System.out.println(" "+num);
				//num--;
		
			}
				System.out.println(" "+num);
				num--;
		}
	}


}

