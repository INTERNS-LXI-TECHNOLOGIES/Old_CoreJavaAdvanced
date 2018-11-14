package com.lxisoft.snakenladder.controller;

public class BoardController{


	CellController cell=new CellController();
	SnakeController s=new SnakeController();
	LadderController l=new LadderController();
	int i=4,j=4,k=4,m=4;



	//int sh1=s.sh1,sh2=s.sh2,sh3=s.sh3,sh4=s.sh4;
	//int lh1=l.lh1,lh2=l.lh2,lh3=l.lh3,lh4=l.lh4;

	//int st1=s.st1,st2=s.st2,st3=s.st3,st4=s.st4;
	//int lt1=l.lt1,lt2=l.lt2,lt3=l.lt3,lt4=l.lt4;

	public void printCell(){

		cell.createCell();
		s.createSnake();
		l.createLadder();

		for(int row=1;row<=10;row++)
		{
			if(row%2==1)
			{
				for(int column=1;column<=10;column++)
				{

					if((s.sh1==cell.Num)||(s.sh2==cell.Num)||(s.sh3==cell.Num)||(s.sh4==cell.Num))
					{
			
						printSnakeHead();
					}

					else if(l.lh1==cell.Num||l.lh2==cell.Num||l.lh3==cell.Num||l.lh4==cell.Num)
					{
				
						printLadderStart();
					
					}
				
					else
					{
						System.out.print(cell.Num+"\t");
					}

					cell.Num--;
				}
				
				
			}
			
			else
			{
				cell.Num=cell.Num-10;
				for(int column=1;column<=10;column++)
				{
					cell.Num++;
					
					if((s.st1==cell.Num)||(s.st2==cell.Num)||(s.st3==cell.Num)||(s.st4==cell.Num))
					{
				
						printSnakeTail();
					}
					else if(l.lt1==cell.Num||l.lt2==cell.Num||l.lt3==cell.Num||l.lt4==cell.Num)
					{
				
						printLadderEnd();
					
					}
					else
					{
						System.out.print(cell.Num+"\t");
					}
					
				}
				cell.Num=cell.Num-10;
			}
			System.out.println("\n\n\n");
		
		}
			
	}

	public void printSnakeHead(){

		System.out.print("[SH"+i+"]"+"\t");
		i--;

	}

	public void printSnakeTail(){

		System.out.print("[ST"+j+"]"+"\t");
						j--;
	}
	public void printLadderStart(){

		System.out.print("[LS"+k+"]"+"\t");
						k--;

	}
	public void printLadderEnd(){

		System.out.print("[LE"+m+"]"+"\t");
						m--;

	}

}