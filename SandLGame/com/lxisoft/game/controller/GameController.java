package com.lxisoft.game.controller;

import java.util.Scanner;

public class GameController{

	BoardController board=new BoardController();
	PlayersController players=new PlayersController();
	CoinsController coins=new CoinsController();
	DiceController dice=new DiceController();

	Scanner input=new Scanner(System.in);
	
	/**public GameController(){
		System.out.println("*********Home Page**********    ");
			System.out.println("Enter Number of Players");

			int totalPlayers=input.nextInt();
			for(int i=0;i<totalPlayers;i++){
				
				homePage();


			}


	}*/

	public void homePage(){

		System.out.println("Enter number of Players");
		int limit=input.nextInt();
		System.out.println(" 1.New User Register here     2.Login");
		int choice=input.nextInt();
		switch(choice){
			case 1:players.playersRegistration(limit);
					break;

			case 2:players.playersLogin();
					break;

		}
		
	}
}