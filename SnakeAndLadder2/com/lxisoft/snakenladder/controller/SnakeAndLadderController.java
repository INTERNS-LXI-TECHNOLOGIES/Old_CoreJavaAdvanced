package com.lxisoft.snakenladder.controller;

public class SnakeAndLadderController{


	public static BoardController[][] board=new BoardController[20][20];

	public SnakeAndLadderController(){
		for(int row=1;row<=10;row++){

			for(int column=1;column<=10;column++){

				board[row][column]=null;
				System.out.print("\t"+board[row][column]);
			}
			System.out.println("\n\n");
		}


	}
}