package com.lxisoft.snakeNladder.model;
/** Represents a Cell.
 * @author Deepthi E
*/
public class Cell{
		
	int cellNumber;
	public Cell(int cellNumber){	
		this.cellNumber = cellNumber;
		
	}
	public int getCellNumber(){
		return cellNumber;
	
	}
public String toString(){ 
  return cellNumber+" ";  
 }  
}