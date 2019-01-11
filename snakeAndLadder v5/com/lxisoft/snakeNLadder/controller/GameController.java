package com.lxisoft.snakeNLadder.controller;
import com.lxisoft.snakeNLadder.model.*;
import com.lxisoft.snakeNLadder.clear.*;
//import java.text.*;  
import java.util.*;
import java.io.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
//import java.util.Date;  
//import java.util.Calendar;  

//import java.io.*;
import java.util.regex.*;

/** Represents a GameController.
 * @author Deepthi E
 */

public class GameController{
	
	Game game = new Game();
	//PlayerController playerControl=new PlayerController();
	BoardController boardControl = new BoardController();
	DiceController diceControl =new DiceController();
	CoinController coinControl= new CoinController();
	
	Scanner scan= new Scanner(System.in);
	int i,players,key,playerNumber,playerNumber1,diceValue;
	int[] score = new int[100];
	String noOfPlayers,coinColour;
	FileWriter fw = null;
    BufferedWriter bw = null;
	
	String name,password,playerName,regDate,lPlayerName,lPassword;
	String password1="",playerName1="",line1="";
	int len,c1=0,count=0,current=0;
	boolean validate;
	
    File playerRegister= new File("./PlayerRegister.txt");	
	
	public GameController(){
		boardControl.createBoard();
		diceControl.createDice();
		coinControl.createCoins();	
	}
	/**
	 *  Method to print the homePage.
	 */
	public void homePage()throws InterruptedException{
		System.out.println("\t\t\t\t---------------------");
		System.out.println("\t\t\t\t<<<SNAKE & LADDER>>>");
		System.out.println("\t\t\t\t---------------------\n");
		Date date = new Date();
	    System.out.println("Date:"+ date.toString());
		//playerControl = new PlayerController();
		System.out.println(" <<[1.Player registration]>> <<[2.Player Login]>> <<[3.Exit]>>\n\n");
		
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
		switch(key){
		case 1: playerNumber=inputPlayerNum();
					for(i=1;i<=playerNumber;i++){
						playerRegestration(i);
						Thread.sleep(1500);
						cls();}
						printPlayerCoins(playerNumber);	
						playGame(playerNumber);
					break;
					
		case 2: playerNumber=inputPlayerNum();
					for(i=1;i<=playerNumber;i++){
						login();}
					break;
					
		case 3: System.exit(0);break;
		default: System.out.println("YOU ENTERED A WRONG CHOICE");
		}
	}
	/**
	 * Method to input the Number of players.
	 */
	public int inputPlayerNum(){
		try{
		System.out.println("Enter Number of Players::");
		noOfPlayers = scan.nextLine();}
		catch(NumberFormatException e) {
			System.out.println("Enter Again......\n");
			Scanner scan = new Scanner(System.in);
			noOfPlayers=scan.nextLine();
         }
		int playerNum = Integer.parseInt(noOfPlayers);
		return playerNum;
	}
	/**
	 *  Method for player Registration throws InterruptedException. 
	 */
	public void playerRegestration(int id)throws InterruptedException{
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
        String strDate = dateFormat.format(date);	
		System.out.println(id+">");
		System.out.println("Name::");name=scan.nextLine();
		//game.getPlayer().setPlayerName(name);
		game.setPlayer(new Player(name));
		System.out.println("Enter a Strong password ...\n# Must contains one lowercase characters.\n# Must contains one digit from 0-9.\n# Must contains one uppercase characters.\n\n# Must contains one special symbols in the list(@#$%) \n# Length at least 6 characters and maximum of 10 ");
		System.out.println("Password::");
		password=passwordValidation();
		game.getPlayer().setPassword(password);
		game.getPlayers().add(game.getPlayer());
		addToFile(strDate,name,password); 
	}
	/**
	 * Method for password Validation.
	 * password validates using regex.
	 * @returns  the password.
	 */
	public String passwordValidation(){		
  /**
	*(# Start of group
    *(?=.*\\d) # Must contains one digit from 0-9.
    *(?=.*[a-z]) # Must contains one lowercase characters.
    *(?=.*[A-Z]) # Must contains one uppercase characters.
    *(?=.*[@#$%]) # Must contains one special symbols in the list "@#$%".
             	# Match anything with previous condition checking
    *{6,20}	#Length at least 6 characters and maximum of 20	
    *) # End of group*/	
		
	String password_Regex="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10}"; 	
	String pass=scan.nextLine();
	validate=Pattern.matches(password_Regex, pass);
	if(validate==true){
		return pass;	
	}
	else{
		System.out.println("Re-enter the password:");
		passwordValidation();	}
		return pass;
	}
	/**
	 * Method for player registration throws InterruptedException.
	 *  create players and add to the file.
	 */
    public void addToFile(String regDate,String name,String password)throws InterruptedException{
	try{
		fw = new FileWriter(playerRegister,true);
		bw = new BufferedWriter(fw);
		bw.write(regDate+",");
		bw.write(name+",");
		bw.write(password);
		bw.newLine();
		System.out.println("Register Successfully......");
		Thread.sleep(1000);
	}catch(IOException e){
			System.out.println("Error");	
		}finally{
			try{
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			}catch(IOException e){
				e.printStackTrace();}
		}
	}
	 /**
	*Method for player Login throws InterruptedException.
	*
	*/
	public void login()throws InterruptedException{
		
	  System.out.println("Name::"); lPlayerName = scan.nextLine();
	  System.out.println("Password::"); lPassword = scan.nextLine();
	  String line; 
		try{
				FileReader fr=new FileReader(playerRegister);
				BufferedReader br=new BufferedReader(fr);
				while((line=br.readLine())!=null)
				do{
					String[] data = line.split(",");
					regDate=data[0];
					playerName1=data[1];
					password1=data[2];
				if(lPlayerName.equals(playerName1) && lPassword.equals(password1)){
					System.out.println("\n\nLOGIN SUCCESSFUL\nBEST OF LUCK\nDetails of Registration-->>"+line);
				Thread.sleep(1000);
					count++;}	
			}while(false);
			if(count>0){
				current=count;
				count=0;
				lPassword="";lPlayerName="";
				}
				else{
					System.out.println("LOGIN UNSUCCESSFULL\nPLEASE RETRY.............!!");
					Thread.sleep(1000);
				}
			playerName1="";password1="";
	}catch(IOException e){
			System.out.println("Error");}
	}	
	/**
	 *  Method to print the PlayerCoins.
	 */
	public void printPlayerCoins(int playerNumber1)throws InterruptedException{
		for(i=1;i<=playerNumber1;i++){
			
		System.out.println("Player"+i+" Select coin ::");
		coinControl.printCoinList();
		coinColour=scan.nextLine();
		coinControl.createPlayerCoin(coinColour);	
		coinControl.coinList.remove(coinColour);
		game.getPlayers().get(i-1).setCoins(coinControl.getPlayerCoin());
		Thread.sleep(1000);}
			System.out.println("Players are-->>");
			System.out.println(game.getPlayers());
			System.out.println("\n\n         <<<<<<<<<<<<<***********************>>>>>>>>>>>>\n\n");	
			Thread.sleep(2000);
			cls();
		}	
		/**
		* Method to playGame.
		*/
		public void playGame(int players)throws InterruptedException{
		System.out.println("              <<<<<<<<<<<<<<<<GAME STARTS>>>>>>>>>>>>>>\n\n");
		boardControl.printBoard(game);	Thread.sleep(2000);
		cls();
		do{
		for(i=0;i<players;i++){
		
		startPlay(i);
		boardControl.playerGamePosition(game,i);
		boardControl.printBoard(game);	
		Thread.sleep(2500);
		cls();
		}
		}while(game.getPlayer().getScore()<=100);
		
		}
		
		public void startPlay(int playerId){
			
		if(game.getPlayers().get(playerId).getScore()<=100){
		System.out.println("\n*********************\nTurn of Player  "+game.getPlayers().get(playerId).getName());
		startRollDice(playerId);
			}
		}
		public void startRollDice(int playerId){
			System.out.println("Press 0 to Roll Dice..");
			int n=scan.nextInt();
			if(n==0){
			diceValue=diceControl.getDiceValue();	
			System.out.println("Dicevalue::"+diceValue);
			}
			changeScore(playerId);
			playerPosition(playerId);
		}
		public void changeScore(int playerId){
		if(game.getPlayers().get(playerId).getScore()==0&&diceValue>1){
			score[playerId]=0;
			game.getPlayers().get(playerId).setScore(score[playerId]);
			System.out.println("Score::"+game.getPlayers().get(playerId).getScore());
		}
		else if(score[playerId]==0&&diceValue==1){
			scoreSetting(playerId);
			System.out.println("Score::"+game.getPlayers().get(playerId).getScore());
		}	
		else if(score[playerId]>=1&&score[playerId]<=94&&diceValue>=1){
			scoreSetting(playerId);
			int fallingScore=boardControl.snakeCheck(game,playerId);
			game.getPlayers().get(playerId).setScore(fallingScore);
			int jumbingScore=boardControl.ladderCheck(game,playerId);
			game.getPlayers().get(playerId).setScore(jumbingScore);
			System.out.println("Score::"+game.getPlayers().get(playerId).getScore());
		}
		else if(score[playerId]>94&&score[playerId]<=100){
			finalRound(playerId);
			System.out.println("Score::"+game.getPlayers().get(playerId).getScore());
		}
		//boardControl.printBoard(game);
		}
		
		public void scoreSetting(int playerId){
			score[playerId]=game.getPlayers().get(playerId).getScore();
			//System.out.println(score[playerId]);
			score[playerId]+=diceValue;
			game.getPlayers().get(playerId).setScore(score[playerId]);
			
	}
		
		public void finalRound(int playerId){
		if(score[playerId]==95&&diceValue<6){
			scoreSetting(playerId);
		}
		else if(score[playerId]==96&&diceValue<5){
			scoreSetting(playerId);
		}
		else if(score[playerId]==97&&diceValue<4){
			scoreSetting(playerId);
		}
		else if(score[playerId]==98&&diceValue<3){
			scoreSetting(playerId);
		}
		else if(score[playerId]==99&&diceValue==1){
			scoreSetting(playerId);
		}
	}
	
	public void playerPosition(int playerId){
		if(game.getPlayers().get(playerId).getScore()<100){

			if(diceValue==1||diceValue==6){
				System.out.println("Roll Again.......  "+game.getPlayers().get(playerId).getName());
				startRollDice(playerId);
				}
			}else{
				System.out.println("Congrats.........."+game.getPlayers().get(playerId).getName()+"  You Win the Game..........\n");
				System.exit(0);
			}			
	}
		
		
	public void cls(){
		Cls clrscr=new Cls();
		try{
			clrscr.cls();
		}
		catch (IOException e){
			
		}
		catch (InterruptedException e){
			
		}
	}
}	