package com.lxisoft.snakeNladder.controller;

import com.lxisoft.snakeNladder.model.*;
import java.util.*;


public class ComponentController{


		Random random=new Random();
		Set<Integer> componentSet = new LinkedHashSet<Integer>();
		Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		Snake[] snake=new Snake[20];
		Ladder[] ladder=new Ladder[20];
		
	/*	System.out.println("Choose level of Game::[1.Simple]\n [2.Medium]\n [3.Hard]");
		level = scanner.nextInt();
		switch(level){
				case 1:simpleLevel();
				break;
				
				case 2:mediumLevel();
				break;
				
				case 3:hardLevel();
				break;
			}	
		
		public void simpleLevel(){
			for(i=1;i<=3;i++){
				 snake[i]= new Snake(i);
			}
		
			for(i=1;i<=5;i++){
				ladder[i]= new Ladder(i);
			}
		}
		
		public void mediumLevel(){
			
			for(i=1;i<=4;i++){
				 snake[i]= new Snake(i);
			}
		
			for(i=1;i<=4;i++){
				ladder[i]= new Ladder(i);
			}
		
		}
		
		public void hardLevel(){*/
			
		Snake snake1= new Snake();
		Snake snake2= new Snake();
		Snake snake3= new Snake();
		Snake snake4= new Snake();
		Snake snake5= new Snake();

		Ladder ladder1= new Ladder();
		Ladder ladder2= new Ladder();
		Ladder ladder3= new Ladder();
		Ladder ladder4= new Ladder();
		
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