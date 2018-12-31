package com.lxisoft.snakeNLadder.model;
/** Represents a Snake.
  * @author Deepthi E
  */
public class Snake {
	
	private int snakeHead;
	private int snakeTail;
	
/** Creates a Snake with specified snakeHead and snakeTail.
  * @param snakeHead The snake's head position.
  * @param snakeTail The snake's tail position.
  */	
	public Snake(int snakeHead,int snakeTail){
		this.snakeHead=snakeHead;
		this.snakeTail=snakeTail;
	}
	
/** Gets the snake's snakeHead .
  * @return An Integer representing the snake's head.
  */
	public int getSnakeHead() {
	return snakeHead;
	}

/** Gets the snake's cellNumber .
  * @return An Integer representing the snake's tail.
  */
	public int getSnakeTail() {
	return snakeTail;
	}
 
}