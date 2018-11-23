package com.lxisoft.snakenladder.controller;


import com.lxisoft.snakenladder.model.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

public class ComponentController{
	
		Random random=new Random();
		Set<Integer> mySet = new LinkedHashSet<Integer>();
		Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		int a,b;

	Snake snake1=new Snake();
	Snake snake2=new Snake();
	Snake snake3=new Snake();
	Snake snake4=new Snake();
	Ladder ladder1=new Ladder();
	Ladder ladder2=new Ladder();
	Ladder ladder3=new Ladder();
	Ladder ladder4=new Ladder();
	int lh1,lh2,lh3,lh4,lt1,lt2,lt3,lt4;
	int sh1,sh2,sh3,sh4,st1,st2,st3,st4;



	Random ran=new Random();
	public void createComponent(){

			do{
		mySet.add(random.nextInt(98-10) + 10);
		
	}while(mySet.size()!=16);
	TreeSet<Integer> sorted=new TreeSet<Integer>(mySet);
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
			snake1.setSnakeHead(setIterator.next());
			ladder1.setLadderEnd(setIterator.next());
			snake2.setSnakeHead(setIterator.next());
			ladder2.setLadderEnd(setIterator.next());
			snake3.setSnakeHead(setIterator.next());
			ladder3.setLadderEnd(setIterator.next());
			snake4.setSnakeHead(setIterator.next());
			ladder4.setLadderEnd(setIterator.next());
		
		}
		getComponent();
	
	}
	public void getComponent(){
		sh1=snake1.getSnakeHead();
		st1=snake1.getSnakeTail();

		sh2=snake2.getSnakeHead();
		st2=snake2.getSnakeTail();

		sh3=snake3.getSnakeHead();
		st3=snake3.getSnakeTail();

		sh4=snake4.getSnakeHead();
		st4=snake4.getSnakeTail();

		lh1=ladder1.getLadderStart();
		lt1=ladder1.getLadderEnd();

		lh2=ladder2.getLadderStart();
		lt2=ladder2.getLadderEnd();

		lh3=ladder3.getLadderStart();
		lt3=ladder3.getLadderEnd();

		lh4=ladder4.getLadderStart();
		lt4=ladder4.getLadderEnd();
	
	}
}