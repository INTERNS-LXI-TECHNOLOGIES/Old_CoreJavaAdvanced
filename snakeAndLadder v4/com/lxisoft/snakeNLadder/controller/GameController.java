package com.lxisoft.snakeNLadder.controller;
import java.util.*;
import java.io.*;

public class GameController{
	
	PlayerController playerControl = new PlayerController();
	
	Scanner scan= new Scanner(System.in);
	int noOfPlayers,i;
	
	String[] s=new String[20];

	public GameController(){
		
		Date date = new Date();
	    System.out.println("Date:"+ date.toString());
		
		System.out.println("\t\t\t\t----------WELCOME----------");
		System.out.println("[1.Player Login] [2.Player registration][3.Exit]");
		System.out.println("\n\n");
		
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
	
		switch(key){
			case 1: System.out.println("Enter Number of Players::");
					noOfPlayers = scan.nextInt();
					for(i=1;i<=noOfPlayers;i++){
					playerControl.login();}
					break;
		    case 2: System.out.println("Enter Number of Players::");
					noOfPlayers = scan.nextInt();
					for(i=1;i<=noOfPlayers;i++){
					playerControl.playerRegestration();}
					break;
			case 3: System.exit(0);break;
		    default: System.out.println("YOU ENTERED A WRONG CHOICE");
		}
	}
	
	
	
}