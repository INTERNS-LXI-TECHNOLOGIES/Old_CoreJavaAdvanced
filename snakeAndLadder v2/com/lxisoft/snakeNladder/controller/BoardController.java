package com.lxisoft.snakeNladder.controller;

import com.lxisoft.snakeNladder.model.*;
import java.util.*;

public class BoardController{
	Board[][] board = new Board[20][20];
	Cell[] cell = new Cell[150];
	
	ComponentController componentController = new ComponentController();
	
	int row,column,cellNumber;

	
	
	public BoardController(){
		initBoard();
	}
	public void initBoard(){
		for (row=1;row<=10;row++){
			
			for(column=1;column<=10;column++){
				
			board[row][column]=null;
			
			}
		}			
		printBoard();		
	}
	
	public void printBoard(){
	
	initCell();
	printCell();	}

	public void initCell(){
	int i;
	for ( i= 1;i<=100;i++){
			cell[i] = new Cell(i);
			cellNumber=cell[i].getCellNumber();
			
		}
	
	}
	
	public void printCell(){
		
		for(row=1;row<=10;row++){
			
			if(row%2==1){
				
			for(column=1;column<=10;column++){
							
					System.out.print("["+cellNumber+"]\t");						
					cellNumber--;
			}
			}	
			
			else{				
			 cellNumber=cellNumber-10;			 
				for(column=1;column<=10;column++){					
					cellNumber++;
					System.out.print("["+cellNumber+"]\t");
				}
			
				cellNumber=cellNumber-10;
			}
			
			System.out.println("\n\n\n");
			}
	}


}