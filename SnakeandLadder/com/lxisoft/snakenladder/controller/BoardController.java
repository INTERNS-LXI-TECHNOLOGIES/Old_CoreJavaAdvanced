package com.lxisoft.snakenladder.controller;

import com.lxisoft.snakenladder.model.*;

public class BoardController {
	
	Board[][] board=new Board[20][20];
	CellController cell=new CellController();
	
	public void initBoard(){
	for(int row=1;row<=10;row++)
	{
		for(int column=1;column<=10;column++)
		{
			board[row][column]=null;
		}
		
	}
	cell.initCell();

		
	}
	
	
}
