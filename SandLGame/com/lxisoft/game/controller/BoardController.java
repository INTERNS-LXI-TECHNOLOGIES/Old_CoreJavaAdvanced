package com.lxisoft.game.controller;

import com.lxisoft.game.model.*;
import java.util.*;

public class BoardController{

	Board board=new Board();
	ArrayList<Cells> cells=new ArrayList<Cells>();
	public void createCells(){

		for(int num=1;num<=100;num++){
			Cells cels=new Cells();
			cels.setCellNum(num);
			cells.add(cels);

		}
		board.setCells(cells);
	}
	public void printCells(){

		createCells();
		System.out.println(board.getCells());
	}
}