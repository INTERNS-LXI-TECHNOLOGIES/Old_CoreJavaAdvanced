package com.lxisoft.controller;

import java.util.Random;
import java.util.Scanner;

import com.lxisoft.model.*;

public class PlayerController {
	
	int i,id;
	//String name;
	Player[] player = new Player[10];
	
	
	Scanner scanner=new Scanner(System.in);

	public int rollDice()
	{
	    int n = 0;
	    Random random = new Random();
	    n=random.nextInt(7);
	    return (n==0?1:n);
	}

	
	public void createPlayer(){
		System.out.println("Number of players:");
		
		int n = scanner.nextInt();
		
		for(i =1;i<=n;i++){
			
			player[i]= new Player(i);
			id=player[i].getPlayerId();
			System.out.println("Id:");
			id=scanner.nextInt();
			
			System.out.println("Player"+id+"");
			//addDetails();
		}
		
		//return player ;
		
	}
	
	/*public void addDetails(){
			System.out.println("Name:");
			player[i].setName(Scanner.nextLine());
	}*/
}