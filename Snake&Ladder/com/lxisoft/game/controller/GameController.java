package com.lxisoft.game.controller;

import com.lxisoft.game.model.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class GameController{

	Game game=new Game();
	BoardController board=new BoardController();
	CoinController coins=new CoinController();
	DiceController dice=new DiceController();
	Scanner input=new Scanner(System.in);
	ArrayList<Player> players=new ArrayList<Player>();
	File file;
	FileWriter details;
	FileReader fr;
	BufferedReader br;
	int diceval;
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
			case 1:playersRegistration(limit);
					break;

			case 2:playersLogin(limit);
					break;
		
		}
		startGame(limit);
		
	}
	public void startGame(int limit){
		try{
			
				fr=new FileReader("./com/lxisoft/game/playersDetails.txt");
				br=new BufferedReader(fr); 
				String name,line;
				int i=1;
				while((line=br.readLine())!=null&&i<=limit)
				{
					file=new File("./com/lxisoft/game/"+"player"+i+"Details"+".txt");
		 			details=new FileWriter(file);
					String data[]=line.split(";");
					name=data[0];
					System.out.println(data[0]+":  Choose your Coin");
					System.out.println(coins.coinsList);
					String color=input.nextLine();
					coins.coinsList.remove(color);
					details.write(data[0]+";");
					details.write(data[1]+";");
					details.write(data[2]+";");
					details.write(data[3]+";");
					details.write(color+";");
					details.close();
					i++;
			
				}

			}
			catch(Exception e){

				e.printStackTrace();
			}
			playGame(limit);

		}
		public void playGame(int plyNum){

			int score=0;;
		do{
			
				for(int i=0;i<plyNum;i++){
				rollDie();
				System.out.println(game.getPlayers().get(i));
				score=game.getPlayers().get(i).getPlayersScore();
				if(diceval==1&&score==0){
					score=1;
					game.getPlayers().get(i).setPlayersScore(score);
				}
				else if(score>=1&&score<=94){
					score+=diceval;
					game.getPlayers().get(i).setPlayersScore(score);
					board.checkSnakes(game,i);
					board.checkLadders(game,i);

				}
				else if(diceval<=5&&score==95){
					score+=diceval;
					game.getPlayers().get(i).setPlayersScore(score);
					board.checkSnakes(game,i);
				}
				else if(diceval<=4&&score==96){
					score+=diceval;
					game.getPlayers().get(i).setPlayersScore(score);

				}
				else if(diceval<=3&&score==97){
					score+=diceval;
					game.getPlayers().get(i).setPlayersScore(score);

				}
				else if(diceval<=2&&score==98){
					score+=diceval;
					game.getPlayers().get(i).setPlayersScore(score);

				}
				else if(diceval==1&&score==99){
					score=100;
					game.getPlayers().get(i).setPlayersScore(score);

				}
			

			//score+=diceval;
			System.out.println(diceval);
			System.out.println(score);
			board.printBoard(game,i);
		}

		}while(score<100);
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
	public void playersRegistration(int limit){
		try{
			
				file=new File("./com/lxisoft/game/playersDetails.txt");
				details=new FileWriter(file);
				for(int i=1;i<=limit;i++){
				
				Player playrs=new Player();
				input=new Scanner(System.in);
				System.out.println("Full Name:");
				playrs.setPlayersName(input.nextLine());
				System.out.println("Phone Number:");
				playrs.setPlayersPhNo(input.nextLine());
				System.out.println("Email Id:");
				playrs.setPlayersEmailId(input.nextLine());
				System.out.println("Password");
				playrs.setPlayersPassword(input.nextLine());
				players.add(playrs);
				game.setPlayers(players);
				details.write(playrs.getPlayersName()+";");
				details.write(playrs.getPlayersPhNo()+";");
				details.write(playrs.getPlayersEmailId()+";");
				details.write(playrs.getPlayersPassword()+"\n");
				System.out.println("Registered Successfully");

				

			}
			details.close();

			System.out.println("Please login any registered player");
			playersLogin(limit);
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}
	public void playersLogin(int limit){

		System.out.println("*******<<<<<<<<LOGIN>>>>>>>******* ");
		System.out.println("Email Id:");
		String email=input.nextLine();
		System.out.println("Password");
		String pass=input.nextLine();
		loadFile(email,pass,limit);
		
	}
	public void loadFile(String email,String pass,int limit)
	{
		
		try
		{
			
				fr=new FileReader("./com/lxisoft/game/playersDetails.txt");
				br=new BufferedReader(fr);
				String line,data1,data2;
				int flag=0;
				while((line=br.readLine())!=null)
				{
					String data[]=line.split(";");
					data1=data[2];
					data2=data[3];
					if(data1.equals(email)&&data2.equals(pass)){
						flag=1;
					
					}
					else{
						flag=0;
					}
					
				}
				if(flag==1){
					System.out.println("login Success");
				}
				else{
					System.out.println("login failure......Please login again");
					playersLogin(limit);
				}
			
		}	
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}