package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;

public class BoardController{
	
	Board[][] board = new Board[20][20];
	Cell[] cell = new Cell[150];
	Snake[] snake=new Snake[10]; 
	Ladder[] ladder= new Ladder[10];
	
	int head1,head2,head3,head4,tail1,tail2,tail3,tail4,start1,start2,start3,start4,end1,end2,end3,end4,cellNumber;
	int row,column;
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
	constructSnakePosition();
	constructLadderPosition();
	printCell();
	}

	public void initCell(){
		int i;
	for ( i= 1;i<=100;i++){
			cell[i] = new Cell(i);
			cellNumber=cell[i].getCellNumber();
			
		}
		
	}
	
	public void constructSnakePosition(){

			snake[1] = new Snake(40,2);
			snake[2] = new Snake(56,24);
			snake[3] = new Snake(61,29);
			snake[4] = new Snake(92,34);
			
			head1 = snake[1].getHeadPosition();
			tail1 = snake[1].getTailPosition();
			
			head2 = snake[2].getHeadPosition();
			tail2 = snake[2].getTailPosition();
			
			head3 = snake[3].getHeadPosition();
			tail3 = snake[3].getTailPosition();
			
			head4 = snake[4].getHeadPosition();
			tail4 = snake[4].getTailPosition();
		
	}

	public void constructLadderPosition() {
			ladder[1] = new Ladder(10,22);
			ladder[2] = new Ladder(4,44);
			ladder[3] = new Ladder(26,60);
			ladder[4] = new Ladder(32,88);
			
			
			start1 = ladder[1].getStartPosition();
			end1 = ladder[1].getEndPosition();
			
			start2 = ladder[2].getStartPosition();
			end2 = ladder[2].getEndPosition();
			
			start3 = ladder[3].getStartPosition();
			end3 = ladder[3].getEndPosition();
			
			start4 = ladder[4].getStartPosition();
			end4 = ladder[4].getEndPosition();

	}
	public void printCell(){
	int w=4,x=4,y=4,z=4;
	System.out.println("\n\t\t\t************Snake And Ladder************\n\n");
	
	for(row=1;row<=10;row++){
			
			if(row%2==1){
				
			for(column=1;column<=10;column++){
				
			
				if(cellNumber==head1||cellNumber==head2||cellNumber==head3||cellNumber==head4){
					System.out.print("<<SH"+w+"\t");
					w--;
				}
			
				else if(cellNumber==tail1||cellNumber==tail2||cellNumber==tail3||cellNumber==tail4){
					System.out.print("ST"+x+">>\t");
					x--;
				}
				else if(cellNumber==start1||cellNumber==start2||cellNumber==start3||cellNumber==start4){
					System.out.print("##LS"+y+"\t");
					y--;
				}
				else if(cellNumber==end1||cellNumber==end2||cellNumber==end3||cellNumber==end4){
					System.out.print("LE"+z+"##\t");
					z--;
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
					
					if(cellNumber==head1||cellNumber==head2||cellNumber==head3||cellNumber==head4){
					System.out.print("<<SH"+w+"\t");
					w--;
				}
				else if(cellNumber==tail1||cellNumber==tail2||cellNumber==tail3||cellNumber==tail4){
					System.out.print("ST"+x+">>\t");
					x--;
				}
				else if(cellNumber==start1||cellNumber==start2||cellNumber==start3||cellNumber==start4){
					System.out.print("##LS"+y+"\t");
					y--;
				}
				else if(cellNumber==end1||cellNumber==end2||cellNumber==end3||cellNumber==end4){
					System.out.print("LE"+z+"##\t");
					z--;
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

}