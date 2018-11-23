package com.lxisoft.snakenladder.controller;

public class BoardController{


	CellController cell=new CellController();

	ComponentController c=new ComponentController();
	
	int i=4,j=4,k=4,m=4;
	int sh1,sh2,sh3,sh4,st1,st2,st3,st4;

	int lh1,lh2,lh3,lh4,lt1,lt2,lt3,lt4;


	public void printCell(){

		cell.createCell();
		c.createComponent();
		sh1=c.sh1;sh2=c.sh2;sh3=c.sh3;sh4=c.sh4;
		st1=c.st1;st2=c.st2;st3=c.st3;st4=c.st4;
		lh1=c.lh1;lh2=c.lh2;lh3=c.lh3;lh4=c.lh4;
		lt1=c.lt1;lt2=c.lt2;lt3=c.lt3;lt4=c.lt4;

		for(int row=1;row<=10;row++)
		{
			if(row%2==1)
			{
				for(int column=1;column<=10;column++)
				{

					if((c.sh1==cell.Num)||(c.sh2==cell.Num)||(c.sh3==cell.Num)||(c.sh4==cell.Num))
					{
			
						printSnakeHead();
					}

					else if(c.lh1==cell.Num||c.lh2==cell.Num||c.lh3==cell.Num||c.lh4==cell.Num)
					{
				
						printLadderStart();
					
					}
					else if((c.st1==cell.Num)||(c.st2==cell.Num)||(c.st3==cell.Num)||(c.st4==cell.Num)){

						printSnakeTail();

					}
					else if(c.lt1==cell.Num||c.lt2==cell.Num||c.lt3==cell.Num||c.lt4==cell.Num){

						printLadderEnd();

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
					
					if((c.st1==cell.Num)||(c.st2==cell.Num)||(c.st3==cell.Num)||(c.st4==cell.Num))
					{
				
						printSnakeTail();
					}
					else if(c.lt1==cell.Num||c.lt2==cell.Num||c.lt3==cell.Num||c.lt4==cell.Num)
					{
				
						printLadderEnd();
					
					}
					else if((c.sh1==cell.Num)||(c.sh2==cell.Num)||(c.sh3==cell.Num)||(c.sh4==cell.Num)){

						printSnakeHead();
					}
					else if(c.lh1==cell.Num||c.lh2==cell.Num||c.lh3==cell.Num||c.lh4==cell.Num){
						
						printLadderStart();

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