package com.lxisoft.snakenladder.controller;

import java.util.*;

public class BoardController{

	CellController cell=new CellController();
	ComponentController component= new ComponentController();
	int xLoc,yLoc;
	Random ran=new Random();
	public void location(){

		do{

			xLoc=ran.nextInt(10);
			yLoc=ran.nextInt(10);
		}while(SnakeAndLadderController.board[xLoc][yLoc]!=null);
		SnakeAndLadderController.board[xLoc][yLoc]=this;
	}
}