package com.lxisoft.snakeNladder.controller;

import com.lxisoft.snakeNladder.model.*;
import java.util.*;


public class ComponentController{


		Random random=new Random();
		Set<Integer> componentSet = new LinkedHashSet<Integer>();
		Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		int sh1,sh2,sh3,sh4,st1,st2,st3,st4,sh5,st5;
		int ls1,ls2,ls3,ls4,le1,le2,le3,le4;
		
		
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
		//System.out.print("\n"+setIterator.next()+"\n");
			
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
	

	public void getComponents(){
	
	
	sh1=snake1.getSnakeHead();
	st1=snake1.getSnakeTail();
	
	sh2=snake2.getSnakeHead();
	st2=snake2.getSnakeTail();
	
	sh3=snake3.getSnakeHead();
	st3=snake3.getSnakeTail();
	
	sh4=snake4.getSnakeHead();
	st4=snake4.getSnakeTail();
	
	sh5=snake5.getSnakeHead();
	st5=snake5.getSnakeTail();
	
	ls1=ladder1.getLadderStart();
	le1=ladder1.getLadderEnd();
	
	ls2=ladder2.getLadderStart();
	le2=ladder2.getLadderEnd();
	
	ls3=ladder3.getLadderStart();
	le3=ladder3.getLadderEnd();

	ls4=ladder4.getLadderStart();
	le4=ladder4.getLadderEnd();	
	
	} 
}