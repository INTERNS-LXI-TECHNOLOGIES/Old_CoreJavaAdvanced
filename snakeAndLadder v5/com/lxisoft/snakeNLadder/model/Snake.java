package com.lxisoft.snakeNLadder.model;
/** Represents a Snake.
 * @author Deepthi E
*/
public class Snake {
	
	private int snakeHead;
	private int snakeTail;
	
	public int getSnakeHead() {
	return snakeHead;
	}

	public void setSnakeHead(int snakeHead) {
	this.snakeHead = snakeHead;
	}
	public int getSnakeTail() {
	return snakeTail;
	}

	public void setSnakeTail(int snakeTail) {
	this.snakeTail = snakeTail;
	}
	public String toString(){ 
	return snakeHead+" ";  
 }  
}