package com.lxisoft.controller;

import java.util.*;

import com.lxisoft.model.*;

public class BoardController{
	
	Board[][] board = new Board[20][20];
	Cell[] cell = new Cell[150];
	Snake[] snake=new Snake[10]; 
	Ladder[] ladder= new Ladder[10];
	
	int i,j,head1,head2,head3,head4,tail1,tail2,tail3,tail4,start1,start2,start3,start4,end1,end2,end3,end4,cellNumber;

	public void initBoard(){
		for (i=1;i<=10;i++){
			
			for(j=1;j<=10;j++){
				
			board[i][j]=null;
			
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
	for ( i= 1;i<=100;i++){
			cell[i] = new Cell(i);
			cellNumber=cell[i].getCellNumber();
			
		}
		
		//printCell();
	}
	
	public void constructSnakePosition(){

			snake[1] = new Snake(56,2);
			snake[2] = new Snake(31,5);
			snake[3] = new Snake(40,21);
			snake[4] = new Snake(92,4);
			
			//System.out.println(head);
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
			ladder[2] = new Ladder(26,44);
			ladder[3] = new Ladder(32,60);
			ladder[4] = new Ladder(4,88);
			
			//System.out.println(start);
			
			
			
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
	
	for(i=1;i<=10;i++){
			
			if(i%2==1){
				
			for(j=1;j<=10;j++){
				
			
				if(cellNumber==head1||cellNumber==head2||cellNumber==head3||cellNumber==head4){
					System.out.print("SH\t");
				}
				else if(cellNumber==tail1||cellNumber==tail2||cellNumber==tail3||cellNumber==tail4){
					System.out.print("ST\t");
				}
				else if(cellNumber==start1||cellNumber==start2||cellNumber==start3||cellNumber==start4){
					System.out.print("LS\t");
				}
				else if(cellNumber==end1||cellNumber==end2||cellNumber==end3||cellNumber==end4){
					System.out.print("LE\t");
				}
				else{				
					System.out.print(cellNumber+"\t");			
					}
					cellNumber--;
			}
			}	
			
			else{
				
			 cellNumber=cellNumber-10;
			 
				for(j=1;j<=10;j++){
					
					cellNumber++;
					
			//for ( i= 1;i<=4;i++){
			//head = snake[1].getHeadPosition();
			//tail = snake[i].getTailPosition();
			//start = ladder[i].getStartPosition();
			//end = ladder[i].getEndPosition();
					
					if(cellNumber==head1||cellNumber==head2||cellNumber==head3||cellNumber==head4){
					System.out.print("SH\t");
				}
				else if(cellNumber==tail1||cellNumber==tail2||cellNumber==tail3||cellNumber==tail4){
					System.out.print("ST\t");
				}
				else if(cellNumber==start1||cellNumber==start2||cellNumber==start3||cellNumber==start4){
					System.out.print("LS\t");
				}
				else if(cellNumber==end1||cellNumber==end2||cellNumber==end3||cellNumber==end4){
					System.out.print("LE\t");
				}
				
				else{
					
					System.out.print(cellNumber+"\t");
				}
				}
			
				cellNumber=cellNumber-10;
			}
			
			System.out.println("\n\n\n");
			}
	}
	/*public void addSnakeToBoard(){
	for(cellNumber=1;cellNumber<=100;cellNumber++){
				
				if(cellNumber==head){
								
								//cellNumber=
					System.out.print(cellNumber+"H\t");	
							
					}
			}
			}

	public void addLadderToBoard(){
	for(cellNumber=1;cellNumber<=100;cellNumber++){
				
				if(cellNumber==start){
								
					System.out.print(cellNumber+"S\t");	
							
					}
			}

	}	*/

}