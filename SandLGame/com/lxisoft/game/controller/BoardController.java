package com.lxisoft.game.controller;

import com.lxisoft.game.model.*;
import java.util.*;

public class BoardController{

	Board board=new Board();
	//ArrayList<Cells> cells=new ArrayList<Cells>();


	Cells[][] cells=new Cells[50][50];

	public BoardController(){
		for(int row=0;row<10;row++){
			for(int column=0;column<10;column++){

				cells[row][column]=null;
			}
		}

	}

	public void printBoard(){

		
	}
	/**public void createCells(){

		for(int num=1;num<=100;num++){
			Cells cels=new Cells();
			cels.setCellNum(num);
			cells.add(cels);
			

		}
		//System.out.println(cells);
	//	board.setCells(cells);
	}
	public void printCells(){
 

		createCells();
		System.out.println(board.getCells());
	}*/

}