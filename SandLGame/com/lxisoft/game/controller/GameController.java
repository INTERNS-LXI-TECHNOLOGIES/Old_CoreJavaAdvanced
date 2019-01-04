package com.lxisoft.game.controller;

import com.lxisoft.game.model.Game;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class GameController{

	BoardController board=new BoardController();
	PlayerController players=new PlayerController();
	CoinController coins=new CoinController();
	DiceController dice=new DiceController();
	Game game=new Game();
	int score=0;
	int diceval;
	Scanner input=new Scanner(System.in);
	public GameController(){
		
		board.createBoard();
		dice.createDice();
		coins.createCoins();

	}
	public void homePage(){  
		System.out.println("Enter number of Players");
		int limit=input.nextInt();
		System.out.println("1.New User Register here     2.Login");
		int choice=input.nextInt();
		switch(choice){
			case 1:players.playersRegistration(limit);
					break;

			case 2:players.playersLogin();
					break;

		}
		System.out.println("Please login any registered player");
		startGame();
		//players.playersLogin();
		
	}
	public void startGame(){
		try
		{
			FileReader fr=new FileReader("./com/lxisoft/game/playersDetails.txt");
			BufferedReader br=new BufferedReader(fr);
			String line,name;
			
			while((line=br.readLine())!=null)
			{
				String data[]=line.split(";");
				name=data[1];
				System.out.println(name+":  Choose your Coin");
				System.out.println(coins.coinsList);
				Scanner in=new Scanner(System.in);
			 	String color=in.nextLine();
				coins.coinsList.remove(color);
			}
		}
		catch(Exception e){

			e.printStackTrace();
		}
		

	}
	public void moveCoins(){


		do{
			rollDie();
			score+=diceval;
			game.getPlayers().setPlayersScore(score);
			System.out.println(game.getPlayers().getPlayersScore());
			board.printBoard(game);

		}while(game.getPlayers().getPlayersScore()<=100);
		//int diceval=dice.getDiceValue();
		//int score=game.getPlayers().getPlayersScore();

			
			System.out.println(game.getPlayers().getPlayersScore());
	
	}
	public void rollDie(){

		System.out.println("Press 'R' to Roll the Dice");
		Scanner in=new Scanner(System.in);
		String roll=in.nextLine();
		try{
				if(roll.equals("R")||roll.equals("r")){

					diceval=dice.getDiceValue();

				}
			}
			catch(InputMismatchException ie){

				ie.printStackTrace();
			}
		
		
		}
	
/**	public void loadFile(){

		try
		{
			FileReader fr=new FileReader("./com/lxisoft/game/playersDetails.txt");
			BufferedReader br=new BufferedReader(fr);
			String line,name;
			
			while((line=br.readLine())!=null)
			{
				String data[]=line.split(";");
				name=data[1];
				startGame(name);
			}
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}*/
}