package com.lxisoft.game.controller;

import com.lxisoft.game.model.*;
import java.util.*;

public class BoardController{

	Board board=new Board();
	ArrayList<Cell> cells=new ArrayList<Cell>();
	HashMap<String,Snake> snakes=new HashMap<String,Snake>();

	public void printBoard(){

		
	}
	public void createCells(){

		for(int num=1;num<=100;num++){
		
			Cell cels=new Cell();
			cels.setCellNum(num);
			cells.add(cels);
		}
		board.setCells(cells);
	}
    public void createSnakes(){

		Snake sk1=new Snake(26,4);
		Snake sk2=new Snake(34,10);
		Snake sk3=new Snake(76,30);
		Snake sk4=new Snake(95,40);
		snakes.put("s1",sk1);
		snakes.put("s2",sk2);
		snakes.put("s3",sk3);
		snakes.put("s4",sk4);
		board.setSnakes(snakes);
	}
	public void printCells(){
  
		int cels[]=new int[100];
		createCells();
		createSnakes();
		cells=board.getCells();
		snakes=board.getSnakes();
		int index=99;
		for(int i=0;i<10;i++){
			if(i%2==0){
			for(int j=1;j<=10;j++){

				for(Map.Entry<String,Snake> m:snakes.entrySet()){
				String key=m.getKey();
				Snake s=m.getValue();
			
			if((cells.get(index).getCellNum())==(s.getSnakeHead())||(cells.get(index).getCellNum())==(s.getSnakeTail())){
					System.out.print(key);
				}
			}			
			System.out.print("["+cells.get(index).getCellNum()+"]"+"	");
			index--;

		}
	}
	else{
		for(int j=0;j<10;j++){
					
		cels[j]=cells.get(index).getCellNum();
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
		System.out.print("["+cels[k]+"]"+"	");

	}
	}
	System.out.println("\n\n");
}
		
	}

}