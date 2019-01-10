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
		players.playersLogin();
		startGame();
		//playGame();
		moveCoins();
		
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
	public void playGame(){

		try
		{
			FileReader fr=new FileReader("./com/lxisoft/game/playersDetails.txt");
			BufferedReader br=new BufferedReader(fr);
			String line,name;
			
			while((line=br.readLine())!=null)
			{
				String data[]=line.split(";");
				name=data[1];
				System.out.println(name+"Your Turn");
				//moveCoins()
			 	
			}
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}
	public void moveCoins(){


		do{
			rollDie();
			
				score=game.getPlayers().getPlayersScore();
				if(diceval==1&&score==0){
					score=1;
					game.getPlayers().setPlayersScore(score);
				}
				/**if(diceval==1||diceval==6)
				{
					score+=diceval;
					game.getPlayers().setPlayersScore(score);

					rollDie();
				}*/
			
				else if(score>=1&&score<=94){
					score+=diceval;
					game.getPlayers().setPlayersScore(score);
					board.checkSnakes(game);
					board.checkLadders(game);

				}
				else if(diceval<=5&&score==95){
					score+=diceval;
					game.getPlayers().setPlayersScore(score);
					board.checkSnakes(game);
				}
				else if(diceval<=4&&score==96){
					score+=diceval;
					game.getPlayers().setPlayersScore(score);

				}
				else if(diceval<=3&&score==97){
					score+=diceval;
					game.getPlayers().setPlayersScore(score);

				}
				else if(diceval<=2&&score==98){
					score+=diceval;
					game.getPlayers().setPlayersScore(score);

				}
				else if(diceval==1&&score==99){
					score=100;
					game.getPlayers().setPlayersScore(score);

				}
			

			//score+=diceval;
			System.out.println(diceval);
			System.out.println(game.getPlayers().getPlayersScore());
			board.printBoard(game);

		}while(game.getPlayers().getPlayersScore()<100);
			//System.out.println(game.getPlayers().getPlayersScore());
	
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