package com.lxisoft.snakeNLadder.controller;

import com.lxisoft.snakeNLadder.model.*;
import java.util.*;


public class ComponentController{


		Random random=new Random();
		Set<Integer> componentSet = new LinkedHashSet<Integer>();
		Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		Snakes[] snake=new Snakes[20];
		Ladders[] ladder=new Ladders[20];
			
		Snakes snake1= new Snakes();
		Snakes snake2= new Snakes();
		Snakes snake3= new Snakes();
		Snakes snake4= new Snakes();
		Snakes snake5= new Snakes();

		Ladders ladder1= new Ladders();
		Ladders ladder2= new Ladders();
		Ladders ladder3= new Ladders();
		Ladders ladder4= new Ladders();
		
		public void createComponent(){

		do{
			
		componentSet.add(random.nextInt(98-10) + 10);
		
		}while(componentSet.size()!=18);
		
		TreeSet<Integer> sorted=new TreeSet<Integer>(componentSet);
		Iterator<Integer> setIterator = sorted.iterator();
		while(setIterator.hasNext()){
			
			snake1.setSnakeTail(setIterator.next());
			ladder1.setLadderStart(setIterator.next());
			
			snake2.setSnakeTail(setIterator.next());
			ladder2.setLadderStart(setIterator.next());
			
			snake3.setSnakeTail(setIterator.next());
			ladder3.setLadderStart(setIterator.next());
			
			snake4.setSnakeTail(setIterator.next());
			ladder4.setLadderStart(setIterator.next());
			
			snake5.setSnakeTail(setIterator.next());
			
			snake1.setSnakeHead(setIterator.next());			
			ladder1.setLadderEnd(setIterator.next());
			
			snake2.setSnakeHead(setIterator.next());
			ladder2.setLadderEnd(setIterator.next());
			
			snake3.setSnakeHead(setIterator.next());
			ladder3.setLadderEnd(setIterator.next());
			
			snake4.setSnakeHead(setIterator.next());
			ladder4.setLadderEnd(setIterator.next());
			
			snake5.setSnakeHead(setIterator.next());
    
		}
		
		}
	

	
}