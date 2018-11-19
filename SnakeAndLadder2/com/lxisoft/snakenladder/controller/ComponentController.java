package com.lxisoft.snakenladder.controller;

import com.lxisoft.snakenladder.model.*;
import java.util.*;

public class ComponentController{

	Component Component=new Component();
	Ladder ladder[]=new Ladder[10];
	Snake snake[]=new Snake[10];


	Random ran=new Random();

	/**int startPoint,endPoint;
	public void createLadder(){

		
		for(int i=1;i<4;i++){

			startPoint=ran.nextInt(4);
			endPoint=ran.nextInt(4);
			ladder[i]=new Ladder(i,startPoint,endPoint);
			BoardController.location();

		}


	}
	public void createSnake(){

		for(int i=1;i<=4;i++){

			startPoint=ran.nextInt(4);
			endPoint=ran.nextInt(4);
			snake[i]=new Snake(i,startPoint,endPoint);
			BoardController.location();
		}
	}*/
}