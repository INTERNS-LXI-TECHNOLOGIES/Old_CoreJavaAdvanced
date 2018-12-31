package com.lxisoft.snakeNLadder.model;
/** Represents a Cell.
  * @author Deepthi E
  */
public class Cell{
		
	private int cellNumber;
	
/** Creates a Cell with the specified cellNumber.
  * @param cellNumber The cell's cellNumber.
  */
	public Cell(int cellNumber){	
		this.cellNumber = cellNumber;	
	    }

/** Gets the cell's cellNumber .
  * @return An Integer representing the cell's cellNumber.
  */
  
	public int getCellNumber(){
		return cellNumber;
		}
		
public String toString(){ 
  return cellNumber+" ";  
 }  
}