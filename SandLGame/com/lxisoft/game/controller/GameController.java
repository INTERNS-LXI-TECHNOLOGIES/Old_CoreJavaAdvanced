package com.lxisoft.game.controller;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class GameController{

	BoardController board=new BoardController();
	PlayersController players=new PlayersController();
	CoinsController coins=new CoinsController();
	DiceController dice=new DiceController();

	Scanner input=new Scanner(System.in);
	
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
		loadFile();
		
	}
	public void startGame(String pName){

		System.out.println(pName+":  Choose your Coin");
		String[] coins={"RED","GREEN","BLUE","ORANGE","YELLOW"};
		List<String> coinsList=new ArrayList<String>(Arrays.asList(coins));
		System.out.println(coinsList);
		Scanner in=new Scanner(System.in);
	 String color=in.nextLine();
	if(color.equals(coins)){
		coinsList.remove(color);
		coins = coinsList.toArray(new String[0]);

	}

	
	//board.createCells();
	}
	public void loadFile(){

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
	}
}