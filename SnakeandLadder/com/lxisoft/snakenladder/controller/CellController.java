package com.lxisoft.snakenladder.controller;
import java.util.*;

import com.lxisoft.snakenladder.model.*;

public class CellController {
	Snake snake1;
	Snake snake2;
	Snake snake3;
	Snake snake4;

	Ladder ladder1;
	Ladder ladder2;
	Ladder ladder3;
	Ladder ladder4;

	Cell[] cell=new Cell[150];
	
	int cellNum;
	public void initCell()
	{
		for(int num=1;num<=100;num++)
		{
			cell[num]=new Cell(num);
			cellNum=cell[num].getNumber();
			snake1=new Snake(98,47); 
			snake2=new Snake(74,27);
			snake3=new Snake(58,24);
			snake4=new Snake(35,3); 
			ladder1=new Ladder(57,86);
			ladder2=new Ladder(40,81);
			ladder3=new Ladder(36,73);
			ladder4=new Ladder(16,34);
			
		}
		printCell();
	}
	public void printCell()
	{ 
		int i=4,j=4,k=4,l=4;
		for(int row=1;row<=10;row++)
		{
			if(row%2==1)
			{
				for(int column=1;column<=10;column++)
				{

					if((snake1.getSnakeHead()==cellNum)||(snake2.getSnakeHead()==cellNum)||(snake3.getSnakeHead()==cellNum)||(snake4.getSnakeHead()==cellNum))
					{
			
						System.out.print("[SH"+i+"]"+"\t");
						i--;
					}

					else if(ladder1.getLHeadPos()==cellNum||ladder2.getLHeadPos()==cellNum||ladder3.getLHeadPos()==cellNum||ladder4.getLHeadPos()==cellNum)
					{
				
						System.out.print("[LH"+k+"]"+"\t");
						k--;
					
					}
				
					else
					{
						System.out.print(cellNum+"\t");
					}

					cellNum--;
				}
				
				
			}
			
			else
			{
				cellNum=cellNum-10;
				for(int column=1;column<=10;column++)
				{
					cellNum++;
					if((snake1.getSnakeTail()==cellNum)||(snake2.getSnakeTail()==cellNum)||(snake3.getSnakeTail()==cellNum)||(snake4.getSnakeTail()==cellNum))
					{
				
						System.out.print("[ST"+j+"]"+"\t");
						j--;
					}
					else if(ladder1.getLTailPos()==cellNum||ladder2.getLTailPos()==cellNum||ladder3.getLTailPos()==cellNum||ladder4.getLTailPos()==cellNum)
					{
				
						System.out.print("[LT"+l+"]"+"\t");
						l--;
					
					}
					else
					{
						System.out.print(cellNum+"\t");
					}
					
				}
				cellNum=cellNum-10;
			}
			System.out.println("\n\n\n");
		
		}
			
	}
	
}
