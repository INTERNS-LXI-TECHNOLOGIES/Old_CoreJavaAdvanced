package com.lxisoft.controller;

import java.util.Random;
import java.util.Scanner;

import com.lxisoft.model.*;

public class PlayerController {
	
	int i,id,diceValue=0;
	String name;
	int noOfUsers=0;
	
	
	Player[] player;
	
	Scanner scanner=new Scanner(System.in);

	public int rollDice()
	{
	    int n = 0;
	    Random random = new Random();
	    n=random.nextInt(7);
	    return (n==0?1:n);
	}

	
	public int createPlayer(){
		System.out.println("Number of players:");
		noOfUsers= scanner.nextInt();
		
		for(i =1;i<=noOfUsers;i++){
			player=new Player[10];
			player[i] = new Player(i);
			id=player[i].getPlayerId();
			System.out.println("Player"+id+"\n");	

		}
		return noOfUsers;
	}
		

	
		
}
	
	