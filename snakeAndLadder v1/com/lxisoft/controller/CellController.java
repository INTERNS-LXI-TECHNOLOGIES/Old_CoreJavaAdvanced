package com.lxisoft.controller;

import com.lxisoft.model.*;

public class CellController{
	
	Cell[] cell = new Cell[150];
	int cellNumber;
	int i,j;
	
	
	public void initCell(){
	for ( i= 1;i<=100;i++){
			cell[i] = new Cell(i);
			cellNumber=cell[i].getCellNumber();
			
		}
		
		printCell();
	}

	public void printCell(){
	
	for(i=1;i<=10;i++){
			
			if(i%2==1){
				
			for(j=1;j<=10;j++){
				
					
					System.out.print(cellNumber+"\t");	
					
					
					cellNumber--;
			}
			
			}
			
			else{
				
			 cellNumber=cellNumber-10;
			 
				for(j=1;j<=10;j++){
					
					cellNumber++;
					
					System.out.print(cellNumber+"\t");
					
				}
				cellNumber=cellNumber-10;
			}
			
			System.out.println("\n\n\n");
			}
	}
}
