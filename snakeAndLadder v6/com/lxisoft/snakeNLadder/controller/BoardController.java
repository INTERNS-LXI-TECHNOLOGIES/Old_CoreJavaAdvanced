package com.lxisoft.snakeNLadder.controller;

import com.lxisoft.snakeNLadder.model.*;
import com.lxisoft.snakeNLadder.view.*;
import java.util.*;

/** Represents a BoardController.
 * @author Deepthi E
 */


public class BoardController{
		
	Board board;
	BoardView boardView;
	ArrayList<Cell> cells = new ArrayList<Cell>();
	HashMap<String,Snake> snakes= new HashMap<String,Snake>();
	HashMap<String,Ladder> ladders= new HashMap<String,Ladder>();
	
	int playerPosition;
	int id;
	/**
	 * The method to createBoard.
	 */
	public void createBoard(){
		board=new Board();
		boardView=new BoardView();
		createCells();
		createSnakes();
		createLadders();	
	}
	/**
	 * The method to createCells on the board.
	 */
	public void createCells(){
		for(int num=1;num<=100;num++){
			Cell cell= new Cell(num);
			cells.add(cell);	
		}
		board.setCells(cells);
	}
	/**
	 * The method to create Snakes on the board.
	 * Snake objects are added to the HashMap<snakes>
	 */
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
	/**
	 * The method to create Ladders on the board.
	 * Ladder objects are added to the HashMap<ladders>
	 */
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
	/**
	 * The method to printBoard.
	 * The cells Snakes and Ladders are on the Board.
	 */
	public void printBoard(Game game){
		int cels[]=new int[100];
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
					System.out.print(key);}
			}
			for(Map.Entry<String,Ladder> m1:ladders.entrySet()){
				String lkey=m1.getKey();
				Ladder l=m1.getValue();
			
			if((cells.get(index).getCellNumber())==(l.getLadderStart())||(cells.get(index).getCellNumber())==(l.getLadderEnd())){
					System.out.print(lkey);}
			}
			if((cells.get(index).getCellNumber())==playerPosition){
					System.out.print("*p"+id);
				}	
			System.out.print("["+cells.get(index).getCellNumber()+"]	");
			index--;}
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
					System.out.print(key);}
				}
			for(Map.Entry<String,Ladder> m1:ladders.entrySet()){
				String lkey=m1.getKey();
				Ladder l=m1.getValue();
			
			if((cels[k])==(l.getLadderStart())||(cels[k])==(l.getLadderEnd())){
					System.out.print(lkey);}
			}
			if((cels[k])==playerPosition){
					System.out.print("*p"+id);
					}
		System.out.print("["+cels[k]+"]"+"	");
			}
		}
	System.out.println("\n\n");
		}	
	}
	public void playerGamePosition(Game game,int playerId){
		playerPosition=game.getPlayers().get(playerId).getScore();
		id=playerId;
	}
	
	public int snakeCheck(Game game,int playerId){
		int playerScore;
		if(game.getPlayers().get(playerId).getScore()==snakes.get("s1").getSnakeHead()){
			game.getPlayers().get(playerId).setScore(snakes.get("s1").getSnakeTail());
			playerScore=game.getPlayers().get(playerId).getScore();
			boardView.printSnakeReached(playerScore,1);
		}
		else if(game.getPlayers().get(playerId).getScore()==snakes.get("s2").getSnakeHead()){
			game.getPlayers().get(playerId).setScore(snakes.get("s2").getSnakeTail());
			playerScore=game.getPlayers().get(playerId).getScore();
			boardView.printSnakeReached(playerScore,2);
		}
		else if(game.getPlayers().get(playerId).getScore()==snakes.get("s3").getSnakeHead()){
			game.getPlayers().get(playerId).setScore(snakes.get("s3").getSnakeTail());
			playerScore=game.getPlayers().get(playerId).getScore();
			boardView.printSnakeReached(playerScore,3);
		}
		else if(game.getPlayers().get(playerId).getScore()==snakes.get("s4").getSnakeHead()){
			game.getPlayers().get(playerId).setScore(snakes.get("s4").getSnakeTail());
			playerScore=game.getPlayers().get(playerId).getScore();
			boardView.printSnakeReached(playerScore,4);
		}
		return game.getPlayers().get(playerId).getScore();
	}
	
	public int ladderCheck(Game game,int playerId){
		int playerScore;
		if(game.getPlayers().get(playerId).getScore()==ladders.get("l1").getLadderStart()){
			game.getPlayers().get(playerId).setScore(ladders.get("l1").getLadderEnd());
			playerScore=game.getPlayers().get(playerId).getScore();
			boardView.printLadderReached(playerScore,1);
		}
		else if(game.getPlayers().get(playerId).getScore()==ladders.get("l2").getLadderStart()){
			game.getPlayers().get(playerId).setScore(ladders.get("l2").getLadderEnd());
			playerScore=game.getPlayers().get(playerId).getScore();
			boardView.printLadderReached(playerScore,2);
		}
		else if(game.getPlayers().get(playerId).getScore()==ladders.get("l3").getLadderStart()){
			game.getPlayers().get(playerId).setScore(ladders.get("l3").getLadderEnd());
			playerScore=game.getPlayers().get(playerId).getScore();
			boardView.printLadderReached(playerScore,3);
		}
		else if(game.getPlayers().get(playerId).getScore()==ladders.get("l4").getLadderStart()){
			game.getPlayers().get(playerId).setScore(ladders.get("l4").getLadderEnd());
			playerScore=game.getPlayers().get(playerId).getScore();
			boardView.printLadderReached(playerScore,4);
		}
		return game.getPlayers().get(playerId).getScore();
	}
	
	
}