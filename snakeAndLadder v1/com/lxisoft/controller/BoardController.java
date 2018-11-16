package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;

public class BoardController{
	
	Board[][] board = new Board[20][20];
	Cell[] cell = new Cell[150];
	SnakeController snakeController=new SnakeController();
	LadderController ladderController=new LadderController();
	
	int row,column,cellNumber;
	int w=4,x=4,y=4,z=4;
	
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
	snakeController.constructSnakePosition();
	ladderController.constructLadderPosition();
	printCell();
	}

	public void initCell(){
	int i;
	for ( i= 1;i<=100;i++){
			cell[i] = new Cell(i);
			cellNumber=cell[i].getCellNumber();
			
		}		
	}
		
	public void printCell(){
	
	System.out.println("\n\t\t\t************Snake And Ladder************\n\n");
	
	for(row=1;row<=10;row++){
			
			if(row%2==1){
				
			for(column=1;column<=10;column++){
				
			
				if(cellNumber==snakeController.head1||cellNumber==snakeController.head2||cellNumber==snakeController.head3||cellNumber==snakeController.head4){
					addSnakeHead();
				}
			
				else if(cellNumber==snakeController.tail1||cellNumber==snakeController.tail2||cellNumber==snakeController.tail3||cellNumber==snakeController.tail4){
					addSnakeTail();
				}
				else if(cellNumber==ladderController.start1||cellNumber==ladderController.start2||cellNumber==ladderController.start3||cellNumber==ladderController.start4){
					addLadderStart();
				}
				else if(cellNumber==ladderController.end1||cellNumber==ladderController.end2||cellNumber==ladderController.end3||cellNumber==ladderController.end4){
					addLadderEnd();
				}
				else{				
					System.out.print("["+cellNumber+"]\t");			
					}			
					cellNumber--;
			}
			}	
			
			else{				
			 cellNumber=cellNumber-10;			 
				for(column=1;column<=10;column++){					
					cellNumber++;
					
					if(cellNumber==snakeController.head1||cellNumber==snakeController.head2||cellNumber==snakeController.head3||cellNumber==snakeController.head4){
					addSnakeHead();
				}
				else if(cellNumber==snakeController.tail1||cellNumber==snakeController.tail2||cellNumber==snakeController.tail3||cellNumber==snakeController.tail4){
					addSnakeTail();
				}
				else if(cellNumber==ladderController.start1||cellNumber==ladderController.start2||cellNumber==ladderController.start3||cellNumber==ladderController.start4){
					addLadderStart();
				}
				else if(cellNumber==ladderController.end1||cellNumber==ladderController.end2||cellNumber==ladderController.end3||cellNumber==ladderController.end4){
					addLadderEnd();
				}	
				else{	
					System.out.print("["+cellNumber+"]\t");
				}
				}
			
				cellNumber=cellNumber-10;
			}
			
			System.out.println("\n\n\n");
			}
	}
	public void addSnakeHead(){
		System.out.print("<<SH"+w+"\t");
		w--;
	}
	public void addSnakeTail(){
		System.out.print("ST"+x+">>\t");
		x--;
	}
	public void addLadderStart(){
		System.out.print("##LS"+y+"\t");
		y--;
	}
	public void addLadderEnd(){
		System.out.print("LE"+z+"##\t");
		z--;
	}

}