package com.lxisoft.snakeNladder.controller;

import com.lxisoft.snakeNladder.model.*;
import java.util.*;

public class BoardController{
	Board[][] board = new Board[20][20];
	Cell[] cell = new Cell[150];
	
	ComponentController component=new ComponentController();
	
	int row,column,cellNumber;
	int x=4,y=4,z=4,w=4;

	
	
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
	component.createComponent();
	component.getComponents();
	printCell();	}

	public void initCell(){
	int i;
	for ( i= 1;i<=100;i++){
			cell[i] = new Cell(i);
			cellNumber=cell[i].getCellNumber();
			
		}
	
	}
		
	public void printCell(){
			System.out.println(component.sh1);
		
		for(row=1;row<=10;row++){
			
			if(row%2==1){
				
			for(column=1;column<=10;column++){
				if(cellNumber==component.sh1||cellNumber==component.sh2||cellNumber==component.sh3||cellNumber==component.sh4||cellNumber==component.sh5){
					addSnakeHead();
				}
				else if(cellNumber==component.st1||cellNumber==component.st2||cellNumber==component.st3||cellNumber==component.st4||cellNumber==component.st5){
					addSnakeTail();
				}
				else if(cellNumber==component.ls1||cellNumber==component.ls2||cellNumber==component.ls3||cellNumber==component.ls4){
					addLadderStart();
				}
				else if(cellNumber==component.le1||cellNumber==component.le2||cellNumber==component.le3||cellNumber==component.le4){
					addLadderEnd();
				}	
				else {		
				System.out.print("["+cellNumber+"]\t");
				}				
				cellNumber--;
				
			}
			}	
			
			else{				
			 cellNumber=cellNumber-10;			 
				for(column=1;column<=10;column++){					
					cellNumber++;
					
				if(cellNumber==component.sh1||cellNumber==component.sh2||cellNumber==component.sh3||cellNumber==component.sh4||cellNumber==component.sh5){
					addSnakeHead();
				}
				else if(cellNumber==component.st1||cellNumber==component.st2||cellNumber==component.st3||cellNumber==component.st4||cellNumber==component.st5){
					addSnakeTail();
				}
				else if(cellNumber==component.ls1||cellNumber==component.ls2||cellNumber==component.ls3||cellNumber==component.ls4){
					addLadderStart();
				}
				else if(cellNumber==component.le1||cellNumber==component.le2||cellNumber==component.le3||cellNumber==component.le4){
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