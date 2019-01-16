package com.lxisoft.game.controller;

import com.lxisoft.game.model.*;
import java.util.*;

public class BoardController{
	Board board=new Board();
	ArrayList<Cell> cells=new ArrayList<Cell>();
	HashMap<String,Snake> snakes=new HashMap<String,Snake>();
	HashMap<String,Ladder> ladders=new HashMap<String,Ladder>();
	
	public void createBoard(){

		for(int num=1;num<=100;num++){
		
			Cell cels=new Cell();
			cels.setCellNum(num);
			cells.add(cels);
		}
		board.setCells(cells);
		createSnakes();
		createLadders();
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
	public void createLadders(){
		Ladder ld1=new Ladder(12,45);
		Ladder ld2=new Ladder(25,50);
		Ladder ld3=new Ladder(32,79);
		Ladder ld4=new Ladder(54,94);
		ladders.put("l1",ld1);
		ladders.put("l2",ld2);
		ladders.put("l3",ld3);
		ladders.put("l4",ld4);
		board.setLadders(ladders);

	}
	public void printBoard(Game game,int plyId){
  
		int cels[]=new int[150];
		cells=board.getCells();
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
			for(Map.Entry<String,Ladder> m1:ladders.entrySet()){

				String lkey=m1.getKey();
				Ladder l=m1.getValue();

				if((cells.get(index).getCellNum())==(l.getLadderHead())||(cells.get(index).getCellNum())==(l.getLadderTail())){
					System.out.print(lkey);
				}
			}

				
				if((cells.get(index).getCellNum())==(game.getPlayers().get(plyId).getPlayersScore())){

					System.out.print(game.getPlayers().get(plyId).getCoin().getColor().charAt(0));
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
			for(Map.Entry<String,Ladder> m1:ladders.entrySet()){

				String lkey=m1.getKey();
				Ladder l=m1.getValue();

				if((cels[k])==(l.getLadderHead())||(cels[k])==(l.getLadderTail())){
					System.out.print(lkey);
				}
			}
			if((cels[k])==(game.getPlayers().get(plyId).getPlayersScore())){

					System.out.print(game.getPlayers().get(plyId).getCoin().getColor().charAt(0));
				}		
		System.out.print("["+cels[k]+"]"+"	");

	}
}
	System.out.println("\n\n");
}
		
	}
	public void checkSnakes(Game game,int plyId){
	
		if(game.getPlayers().get(plyId).getPlayersScore()==snakes.get("s1").getSnakeHead()){
			game.getPlayers().get(plyId).setPlayersScore(snakes.get("s1").getSnakeTail());
			System.out.println("Snake1 Entry");

		}
		else if(game.getPlayers().get(plyId).getPlayersScore()==snakes.get("s2").getSnakeHead()){
			game.getPlayers().get(plyId).setPlayersScore(snakes.get("s2").getSnakeTail());
			System.out.println("Snake2 Entry");
		}
		else if(game.getPlayers().get(plyId).getPlayersScore()==snakes.get("s3").getSnakeHead()){
			game.getPlayers().get(plyId).setPlayersScore(snakes.get("s3").getSnakeTail());
			System.out.println("Snake3 Entry");
		}
		else if(game.getPlayers().get(plyId).getPlayersScore()==snakes.get("s4").getSnakeHead()){
			game.getPlayers().get(plyId).setPlayersScore(snakes.get("s4").getSnakeTail());
			System.out.println("Snake4 Entry");
		}

	
	}
	public void checkLadders(Game game,int plyId){
		if(game.getPlayers().get(plyId).getPlayersScore()==ladders.get("l1").getLadderHead())
		{
			game.getPlayers().get(plyId).setPlayersScore(ladders.get("l1").getLadderTail());
			System.out.println("Ladder1 Entry");
		}
		else if(game.getPlayers().get(plyId).getPlayersScore()==ladders.get("l2").getLadderHead()){
			game.getPlayers().get(plyId).setPlayersScore(ladders.get("l2").getLadderTail());
			System.out.println("Ladder2 Entry");
		}
		else if(game.getPlayers().get(plyId).getPlayersScore()==ladders.get("l3").getLadderHead()){
			game.getPlayers().get(plyId).setPlayersScore(ladders.get("l3").getLadderTail());
			System.out.println("Ladder3 Entry");
		}

		else if(game.getPlayers().get(plyId).getPlayersScore()==ladders.get("l4").getLadderHead()){
			game.getPlayers().get(plyId).setPlayersScore(ladders.get("l4").getLadderTail());
			System.out.println("Ladder4 Entry");
		}
	}
}