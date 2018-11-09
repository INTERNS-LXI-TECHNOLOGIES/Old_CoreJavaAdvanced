package com.lxisoft.controller;

import java.util.Random;
import java.util.Scanner;

import com.lxisoft.model.*;

public class PlayerController {
	
	int i,id,diceValue=0;
	String name,string;
	
	int noOfUsers=0;
	//int currentPlayer=1;
	
	
	Player[] player;
	
	Scanner scanner=new Scanner(System.in);

	public int rollDice()
	{
	    int n = 0;
	    Random random = new Random();
	    n=random.nextInt(7);
	    return (n==0?1:n);
	}

	
	public int createPlayer(int users){
		
		
		for(i =1;i<=users;i++){
			player=new Player[10];
			player[i] = new Player(i);
			id=player[i].getPlayerId();
			System.out.println("\nName:\n");
			player[i].setName(scanner.nextLine());
			selectCoinColour();
			

			//System.out.print("Player"+id);
			//System.out.print("\t\t"+player[i].getName());
			//System.out.print("\t\t"+player[i].getCoinColour()+"\n");
			

		}
		return users;
	}
	
	public void selectCoinColour(){
		int key;
		System.out.println("****Choose a coin****\n[1.Green] [2.Blue] [3.Red] [4.Yellow]");
		key=scanner.nextInt();
		 switch(key){
				 case 1:player[i].setCoinColour("Green");
				 break;
				 case 2:player[i].setCoinColour("Blue");
				 break;
				 case 3:player[i].setCoinColour("Red");
				 break;
				 case 4:player[i].setCoinColour("Yellow");
				 break;
				 default:System.out.println("Invalied");
			 }
	}
	
}