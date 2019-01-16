package com.lxisoft.game.controller;

import com.lxisoft.game.model.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GameController{

	Game game;
	BoardController board;
	CoinController coins;
	DiceController dice;
	Scanner input=new Scanner(System.in);
	ArrayList<Player> players=new ArrayList<Player>();
	File file;
	FileWriter details;
	FileReader fr;
	BufferedReader br;
	int diceval;
	int score=0;
	Date date=new Date();
	String plyrDate; 
	public GameController(){
		game=new Game();
		board=new BoardController();
		coins=new CoinController();
		board.createBoard();
		dice=new DiceController();
		coins.createCoins();

	}
	public void homePage(){  
		System.out.println("Enter number of Players");
		String li=input.nextLine();
		int limit=Integer.parseInt(li);
		System.out.println("1.New User Register here     2.Login");
		String ch=input.nextLine();
		int choice=Integer.parseInt(ch);

		switch(choice){
			case 1:playersRegistration(limit);
					break;

			case 2:playersLogin(limit);
					break;
		
		}
		startGame(limit);
		
	}
	public void startGame(int limit){
		
			for(int num=0;num<limit;num++){
					game.setCoins(coins.getCoinsList());
					for(int i=0;i<coins.coinsList.size();i++){
					System.out.print(i+"  "+game.getCoins().get(i).getColor()+"  ");
				}
				 	System.out.println(game.getPlayers().get(num).getPlayersName()+":Choose Your coin");
					
				int ch=input.nextInt();
				switch(ch){
				
						
						case 0: System.out.println(game.getCoins().get(0).getColor());
								game.getPlayers().get(num).setCoin(game.getCoins().get(0));
								coins.remove(game.getCoins().get(0));
								break;
						case 1:	System.out.println(game.getCoins().get(1).getColor());
								game.getPlayers().get(num).setCoin(game.getCoins().get(1));
								coins.remove(game.getCoins().get(1));
								break;
						case 2:	System.out.println(game.getCoins().get(2).getColor());
								game.getPlayers().get(num).setCoin(game.getCoins().get(2));
								coins.remove(game.getCoins().get(2));
								break;
						case 3:	System.out.println(game.getCoins().get(3).getColor());
								game.getPlayers().get(num).setCoin(game.getCoins().get(3));
								coins.remove(game.getCoins().get(3));
								break;
						case 4:	System.out.println(game.getCoins().get(4).getColor());
								game.getPlayers().get(num).setCoin(game.getCoins().get(4));	
								coins.remove(game.getCoins().get(4));
								break;


					
				}
				
				}
		
			playGame(limit);
		}
		public void playGame(int plyNum){

			
		do{
			
				for(int i=0;i<plyNum;i++){
		
				System.out.println(game.getPlayers().get(i).getPlayersName()+":"+game.getPlayers().get(i).getCoin().getColor());
				rollDie();
				calculateScore(i,plyNum);
				
				
		}

		}while(score<100);
		

	
	}
	public void calculateScore(int i,int plyNum){

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
			
			System.out.println(diceval);
			System.out.println(score);
			board.printBoard(game,i);
			if(score==100){

				playerWon(i,plyNum);
				System.exit(0);
			}
			if(diceval==1||diceval==6){
				System.out.println("you get:"+diceval+" Roll again.......");
				rollDie();
				calculateScore(i,plyNum);
				
			}
			
	}
public void playerWon(int plyId,int plyNum){


	System.out.println(game.getPlayers().get(plyId).getPlayersName()+"You WON**,,,**");
	try{
			
				fr=new FileReader("./com/lxisoft/game/playersDetails.txt");
				br=new BufferedReader(fr); 
				String name,line;
				int i=0;
				while((line=br.readLine())!=null&&i<plyNum)
				{
					file=new File("./com/lxisoft/game/"+"player"+i+"Details"+".txt");
		 			details=new FileWriter(file);
					String data[]=line.split(";");
					details.write(data[0]+";");
					details.write(data[1]+";");
					details.write(data[2]+";");
					details.write(data[3]+";");
					details.write(data[4]+";");
					details.write(game.getPlayers().get(i).getPlayersScore()+";");
					details.close();
					i++;
				}
			}
			catch(Exception e)
			{

				e.printStackTrace();

			}
			
		}
	public void rollDie(){

		System.out.println("Press 'R' to Roll the Dice");
		Scanner in=new Scanner(System.in);
		String roll=in.nextLine();
		try{
				if(roll.equals("R")||roll.equals("r")){

					diceval=dice.dice.getDiceValue();

				}
			}
			catch(InputMismatchException ie){

				ie.printStackTrace();
			}
		
		
		}
	public void playersRegistration(int limit){
		try{
				Date date=Calendar.getInstance().getTime();
				DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
				plyrDate=dateFormat.format(date);
				file=new File("./com/lxisoft/game/playersDetails.txt");
				details=new FileWriter(file);
				for(int i=1;i<=limit;i++){
				details.write(plyrDate+";");
				input=new Scanner(System.in);
				System.out.println("Full Name:");
				details.write(input.nextLine()+";");
				System.out.println("Phone Number:");
				details.write(input.nextLine()+";");
				System.out.println("Email Id:");
				details.write(input.nextLine()+";");
				System.out.println("Password");
				details.write(input.nextLine()+"\n");
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
	{	int flag=0;
		
		try
		{
			
				fr=new FileReader("./com/lxisoft/game/playersDetails.txt");
				br=new BufferedReader(fr);
				String line,data1,data2;
				while((line=br.readLine())!=null)
				{
					Player playrs=new Player();
					String data[]=line.split(";");
					playrs.setPlayersName(data[1]);
					playrs.setPlayersPhNo(data[2]);
					playrs.setPlayersEmailId(data[3]);
					playrs.setPlayersPassword(data[4]);
					players.add(playrs);
					game.setPlayers(players);
					if(data[3].equals(email)&&data[4].equals(pass)){
						flag=1;
						break;
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