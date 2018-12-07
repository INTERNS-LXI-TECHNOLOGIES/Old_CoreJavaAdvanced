package com.lxisoft.snakeNladder.controller;

import com.lxisoft.snakeNladder.model.*;
import java.util.*;

public class BoardController{
	Board[][] board = new Board[20][20];
	Cell[] cell = new Cell[150];
	
	ComponentController component=new ComponentController();
	
	int row,column,cellNumber;
	int x=4,y=4,z=4,w=4;
	int sh1,sh2,sh3,sh4,st1,st2,st3,st4,sh5,st5;
	int ls1,ls2,ls3,ls4,le1,le2,le3,le4,ls,le;

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
	getComponents();
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
				
						if(cellNumber==sh1||cellNumber==sh2||cellNumber==sh3||cellNumber==sh4||cellNumber==sh5){
						addSnakeHead();
						}
						else if(cellNumber==st1||cellNumber==st2||cellNumber==st3||cellNumber==st4||cellNumber==st5){
						addSnakeTail();
						}
						else if(cellNumber==ls1||cellNumber==ls2||cellNumber==ls3||cellNumber==ls4){
						addLadderStart();
						}
						else if(cellNumber==le1||cellNumber==le2||cellNumber==le3||cellNumber==le4){
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
					
				if(cellNumber==sh1||cellNumber==sh2||cellNumber==sh3||cellNumber==sh4||cellNumber==sh5){
					addSnakeHead();
				}
				else if(cellNumber==st1||cellNumber==st2||cellNumber==st3||cellNumber==st4||cellNumber==st5){
					addSnakeTail();
				}
				else if(cellNumber==ls1||cellNumber==ls2||cellNumber==ls3||cellNumber==ls4){
					addLadderStart();
				}
				else if(cellNumber==le1||cellNumber==le2||cellNumber==le3||cellNumber==le4){
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

	public void getComponents(){
	
	
	sh1=component.snake1.getSnakeHead();
	st1=component.snake1.getSnakeTail();
	
	sh2=component.snake2.getSnakeHead();
	st2=component.snake2.getSnakeTail();
	
	sh3=component.snake3.getSnakeHead();
	st3=component.snake3.getSnakeTail();
	
	sh4=component.snake4.getSnakeHead();
	st4=component.snake4.getSnakeTail();
	
	sh5=component.snake5.getSnakeHead();
	st5=component.snake5.getSnakeTail();
	
	ls1=component.ladder1.getLadderStart();
	le1=component.ladder1.getLadderEnd();
	
	ls2=component.ladder2.getLadderStart();
	le2=component.ladder2.getLadderEnd();
	
	ls3=component.ladder3.getLadderStart();
	le3=component.ladder3.getLadderEnd();

	ls4=component.ladder4.getLadderStart();
	le4=component.ladder4.getLadderEnd();	
	
	} 
}