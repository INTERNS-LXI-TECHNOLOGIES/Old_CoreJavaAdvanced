package com.lxisoft.snakenladder.controller;
import com.lxisoft.snakenladder.model.*;

public class CellController{

	Cell[] cell=new Cell[150];

	int Num,snh1;

	public void createCell(){

		for(int num=1;num<=100;num++){

			cell[num]=new Cell(num);
			Num=cell[num].getNumber();

		}
	
	}
}