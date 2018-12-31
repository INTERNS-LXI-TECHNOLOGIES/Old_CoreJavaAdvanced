package com.lxisoft.snakeNLadder.controller;

import com.lxisoft.snakeNLadder.model.*;
import java.util.*;



public class BoardController{
		
	Board board = new Board();
	ArrayList<Cell> cells = new ArrayList<Cell>();
	HashMap<String,Snake> snakes= new HashMap<String,Snake>();
	HashMap<String,Ladder> ladders= new HashMap<String,Ladder>();
	
	public BoardController(){
		printBoard();
	}
	
	public void printBoard(){
		printCells();
	}
	
	public void createCells(){
		for(int num=1;num<=100;num++){
			Cell cell= new Cell(num);
			cells.add(cell);	
		}
		board.setCells(cells);
	}
	
	public void createSnakes(){
		Snake snake1=new Snake(13,4);
		Snake snake2=new Snake(36,10);
		Snake snake3=new Snake(76,28);
		Snake snake4=new Snake(95,34);
		snakes.put("s1",snake1);
		snakes.put("s2",snake2);
		snakes.put("s3",snake3);
		snakes.put("s4",snake4);
		board.setSnakes(snakes);
	}
	
	public void createLadders(){
		Ladder lader1= new Ladder(7,24);
		Ladder lader2= new Ladder(15,56);
		Ladder lader3= new Ladder(31,68);
		Ladder lader4= new Ladder(70,91);
		ladders.put("l1",lader1);
		ladders.put("l2",lader2);
		ladders.put("l3",lader3);
		ladders.put("l4",lader4);
		board.setLadders(ladders);
	}
	public void printCells(){
  
		int cels[]=new int[100];
		createCells();
		createSnakes();
		createLadders();
		cells=board.getCells();
		snakes=board.getSnakes();
		ladders=board.getLadders();
		int index=99;
		for(int i=0;i<10;i++){
			if(i%2==0){
			for(int j=1;j<=10;j++){

				for(Map.Entry<String,Snake> m:snakes.entrySet()){
				String key=m.getKey();
				Snake s=m.getValue();
			
			if((cells.get(index).getCellNumber())==(s.getSnakeHead())||(cells.get(index).getCellNumber())==(s.getSnakeTail())){
					System.out.print(key);
				}
			}
			for(Map.Entry<String,Ladder> m1:ladders.entrySet()){
				String lkey=m1.getKey();
				Ladder l=m1.getValue();
			
			if((cells.get(index).getCellNumber())==(l.getLadderStart())||(cells.get(index).getCellNumber())==(l.getLadderEnd())){
					System.out.print(lkey);	
				}
			}	
			System.out.print("["+cells.get(index).getCellNumber()+"	");
			index--;
		}
	}
	else{
		for(int j=0;j<10;j++){			
		cels[j]=cells.get(index).getCellNumber();
		index--;
		}
	
	for(int k=9;k>=0;k--){
		for(Map.Entry<String,Snake> m:snakes.entrySet()){
				String key=m.getKey();
				Snake s=m.getValue();
			
			if((cels[k])==(s.getSnakeHead())||(cels[k])==(s.getSnakeTail())){
					System.out.print(key);
					}
				}
			
			for(Map.Entry<String,Ladder> m1:ladders.entrySet()){
				String lkey=m1.getKey();
				Ladder l=m1.getValue();
			
			if((cels[k])==(l.getLadderStart())||(cels[k])==(l.getLadderEnd())){
					System.out.print(lkey);
					}
				}
			
		System.out.print(cels[k]+"]"+"	");

			}
		}
	System.out.println("\n\n");
		}
		
	}

}