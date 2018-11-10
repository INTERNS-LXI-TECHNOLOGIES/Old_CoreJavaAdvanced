package com.lxisoft.controller;

import java.util.Random;
import java.util.Scanner;

import com.lxisoft.model.*;

public class PlayerController {
	
	int i,id,diceValue=0;
	String name,string;
	
	int noOfUsers=0;
	//int currentPlayer=1;
	
		//String name;
	Player[] player=new Player[10];;
	
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
			player[i] = new Player(i);
			System.out.println("Name:");
			player[i].setName(scanner.nextLine());			
			selectCoinColour();
		}
			for(i=1;i<=users;i++){
			id=player[i].getPlayerId();			
			System.out.print("Player"+id+":");
			System.out.print("  "+player[i].getCoinColour()+"\n");
		}
		return users;
	}
	
	public void selectCoinColour(){
		String key;
		System.out.println("****Choose a coin****\n[1.Green] [2.Blue] [3.Red] [4.Yellow]");
		key=scanner.nextLine();
		//String number = "10";
		int num = Integer.parseInt(key);			
	//System.out.println(num);
		 switch(num){
				 case 1:player[i].setCoinColour("Green\n");
				 player[i].setPosition(0);
				 break;
				 case 2:player[i].setCoinColour("Blue\n");
				 player[i].setPosition(0);
				 break;
				 case 3:player[i].setCoinColour("Red\n");
				 player[i].setPosition(0);
				 break;
				 case 4:player[i].setCoinColour("Yellow\n");
				 player[i].setPosition(0);
				 break;
				 default:System.out.println("Invalied");
			 }
	}
	
}