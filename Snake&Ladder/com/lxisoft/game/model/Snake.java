package com.lxisoft.game.model;
/**Represents a Snake
*@author Sumi G
*/
public class Snake{

	private int snakeHead;
	private int snakeTail;
	/**Creates a Snake with the head and tail
	*@param snakeHead The snake's head
	*@param snakeTail The snake's tail
	*/
	public Snake(int snakeHead,int snakeTail){

		this.snakeHead=snakeHead;
		this.snakeTail=snakeTail;
	}
	/**Gets the snake's head
	*@return A int representing snake's head
	*/
	public int getSnakeHead(){

		return snakeHead;
	}
	/**Gets the snake's tail
	*@return A int representing snake's tail
	*/
	public int getSnakeTail(){

		return snakeTail;
	}
}