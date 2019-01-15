package com.lxisoft.snakeNLadder.model;
import java.util.*;


/** Represents a Board.
  * @author Deepthi E
  */
public class Board{


	private ArrayList<Cell> cells= new ArrayList<Cell>();
	private HashMap<String,Snake> snakes= new HashMap<String,Snake>();
	private HashMap<String,Ladder> ladders= new HashMap<String,Ladder>();

/** Sets the cell to the board.
  * @param cell the board's cell.
  */

	public void setCells(ArrayList<Cell> cells){
		this.cells=cells;	
	}
	
/** Gets the cell in the Board.
  * @return the board's cell.
  */
	public ArrayList<Cell> getCells(){
		return cells;
	}
/** Sets the snakes as HashMap. String be the key and Snake be the value.
  * The String maps the snake.
  */ 
	public void setSnakes(HashMap<String,Snake> snakes){
		this.snakes=snakes;
		}
	
/** Gets the snakes HashMap.
  * @return the snakes.
  */	
	
	public HashMap<String,Snake> getSnakes(){
		return snakes;
		}
	
/** Sets the ladders as HashMap. String be the key and Ladder be the value.
  * The String maps the ladder.
  */

	public void setLadders(HashMap<String,Ladder> ladders){
		this.ladders=ladders;
		}
/** Gets the ladders HashMap.
  * @return the ladders.
  */

	public HashMap<String,Ladder> getLadders(){
		return ladders;
		
		}

	
}