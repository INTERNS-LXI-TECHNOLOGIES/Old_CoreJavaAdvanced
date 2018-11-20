package com.lxisoft.snakenladder.controller;

import com.lxisoft.snakenladder.model.*;

public class SnakeController{

	Snake snake1;
	Snake snake2;
	Snake snake3;
	Snake snake4;
	int sh1,sh2,sh3,sh4,st1,st2,st3,st4;


	public void createSnake(){

		snake1=new Snake(98,47); 
		snake2=new Snake(74,27);
		snake3=new Snake(58,24);
		snake4=new Snake(35,3); 

		sh1=snake1.getSnakeHead();
		st1=snake1.getSnakeTail();

		sh2=snake2.getSnakeHead();
		st2=snake2.getSnakeTail();

		sh3=snake3.getSnakeHead();
		st3=snake3.getSnakeTail();

		sh4=snake4.getSnakeHead();
		st4=snake4.getSnakeTail();
	}
}