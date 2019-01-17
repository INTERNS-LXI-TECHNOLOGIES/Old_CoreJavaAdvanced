package com.lxisoft.snakeNLadder.controller;
import com.lxisoft.snakeNLadder.model.*;
import com.lxisoft.snakeNLadder.view.*;
import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import com.lxisoft.snakeNLadder.cls.*;

public class GameController{
	
	Game game= new Game();
	Date date ;
	GameView gameView;
	
	CoinController coinControl;
	DiceController diceControl;
	BoardController boardControl;
	
	File playerRegister= new File("./PlayerRegister.txt");	
	Scanner scan= new Scanner(System.in);
	final int winPoint=100;
	int[] score=new int[100]; 
	
	
	public GameController()throws InterruptedException{

		coinControl=new CoinController();
		coinControl.createCoins();
		diceControl= new DiceController();
		diceControl.createDice();
		boardControl=new BoardController();
		boardControl.createBoard();
		gameHome();
		//selectPlayerCoin();
		//diceControl.getDiceValues();
	}
	private void gameHome()throws InterruptedException{

		gameView=new GameView();
		date = new Date();
		gameView.homePage(date);
		selectOption();
	}
	private void selectOption()throws InterruptedException{
		int i,playerNumber;
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
		switch(key){
		case 1: playerNumber=inputPlayerNum();
					for(i=1;i<=playerNumber;i++){
						playerRegestration(i);
						Thread.sleep(1500);
						}
						selectPlayerCoin(playerNumber);	
						playGame(playerNumber);
					break;
					
		case 2: playerNumber=inputPlayerNum();
					for(i=1;i<=playerNumber;i++){
						login(i);
						}
					break;
					
		case 3: System.exit(0);break;
		default: System.out.println("YOU ENTERED A WRONG CHOICE");
		}
	}

	private int inputPlayerNum(){
		String noOfPlayers ;
		try{
		gameView.enterNumOfPlayers();
		noOfPlayers = scan.nextLine();}
		catch(NumberFormatException e) {
			System.out.println("Enter Again......\n");
			Scanner scan = new Scanner(System.in);
			noOfPlayers=scan.nextLine();
         }
		int playerNum = Integer.parseInt(noOfPlayers);
		return playerNum;
	}
	
	public void playerRegestration(int id)throws InterruptedException{
		String strDate,name,password;
		
		date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
        strDate = dateFormat.format(date);	
		gameView.enterPlayerName(id);name=scan.nextLine();
		game.setPlayer(new Player(name));
		gameView.passwordInstructions();
		gameView.enterPassword();
		password=passwordValidation();
		game.getPlayer().setPassword(password);
		game.getPlayers().add(game.getPlayer());
		addToFile(strDate,name,password); 
	}
	
	private String passwordValidation(){		
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
	boolean validate=Pattern.matches(password_Regex, pass);
	if(validate==true){
		return pass;	
	}
	else{
		System.out.println("Re-enter the password:");
		passwordValidation();	}
		return pass;
	}
	
	private void addToFile(String regDate,String name,String password)throws InterruptedException{
		FileWriter fw=null;
		BufferedWriter bw=null;
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
					fw.close();}
		catch(IOException e){
				e.printStackTrace();}
		}
	}
	
	public void login(int id)throws InterruptedException{
		String lPlayerName,lPassword,password1,playerName1,line,regDate;
		int count=0,current,i=0;
	  gameView.enterPlayerName(id); lPlayerName = scan.nextLine();
	  gameView.enterPassword(); lPassword = scan.nextLine();
	
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
					count++;
					System.out.println(count);
					gameView.printLoginStatus(count,line);
					Thread.sleep(1000);
					}	
			}while(false);
			if(count>0){
				current=count;
				count=0;
				lPassword="";lPlayerName="";
				}
				else{
					gameView.printLoginStatus(i,line);	
				}
			playerName1=""; password1="";
	}catch(IOException e){
			System.out.println("Error");}
	}	

	public void selectPlayerCoin(int playerNumber)throws InterruptedException{
		int i;
		game.setPlayerCoins(coinControl.coinList);
		for(i=1;i<=playerNumber;i++){
		gameView.printCoinList(game);
		String coinColour=scan.nextLine();
		removeCoin(coinColour,i);
		Thread.sleep(1000);}
		System.out.println(game.getPlayers());
		Thread.sleep(2000);

		}
	public void removeCoin(String coinColour,int playerId){	
		int i,size;
		Coin coin=null;
		size=game.getPlayerCoins().size();
		for (i=0;i<=size;i++){
		String colour=game.getPlayerCoins().get(i).getColour();
		if(coinColour.equals(colour)){
			coin=game.getPlayerCoins().get(i);
			game.getPlayerCoins().remove(i);
			game.getPlayers().get(playerId-1).setCoins(coin);
		break;}
		}	
	}

	public void playGame(int players)throws InterruptedException{
		int i;
		System.out.println("              <<<<<<<<<<<<<<<<GAME STARTS>>>>>>>>>>>>>>\n\n");
		game.setBoard(boardControl.board);

		do{
		for(i=0;i<players;i++){
		
		startPlay(i);
		boardControl.printBoard(game,players,i);	
		//Thread.sleep(2500);
		//cls();
		}

		}while(game.getPlayer().getScore()<=winPoint);
		
		}
		
		public void startPlay(int playerId){
			
		if(game.getPlayers().get(playerId).getScore()<=winPoint){
		System.out.println("\n*********************\nTurn of Player  "+game.getPlayers().get(playerId).getName());
		startRollDice(playerId);
			}
		}
		public void startRollDice(int playerId){
			int diceValue=0;
			System.out.println("Press 0 to Roll Dice..");
			int n=scan.nextInt();
			if(n==0){
			diceValue=diceControl.getDiceValues();	
			System.out.println("Dicevalue::"+diceValue);
			}
			changeScore(playerId,diceValue);
			playerPosition(playerId,diceValue);
		}
		public void changeScore(int playerId,int diceValue){
			
		if(game.getPlayers().get(playerId).getScore()==0&&diceValue>1){
			score[playerId]=0;
			game.getPlayers().get(playerId).setScore(score[playerId]);
			gameView.printScore(game,playerId);
		}
		else if(score[playerId]==0&&diceValue==1){
			scoreSetting(playerId,diceValue);
			gameView.printScore(game,playerId);
		}	
		else if(score[playerId]>=1&&score[playerId]<=94&&diceValue>=1){
			scoreSetting(playerId,diceValue);
			int fallingScore=boardControl.snakeCheck(game,playerId);
			game.getPlayers().get(playerId).setScore(fallingScore);
			int jumbingScore=boardControl.ladderCheck(game,playerId);
			game.getPlayers().get(playerId).setScore(jumbingScore);
			gameView.printScore(game,playerId);
		}
		else if(score[playerId]>94&&score[playerId]<=100){
			finalRound(playerId,diceValue);
			gameView.printScore(game,playerId);
		}
		//boardControl.printBoard(game);
		}
		
		public void scoreSetting(int playerId,int diceValue){
			score[playerId]=game.getPlayers().get(playerId).getScore();
			score[playerId]+=diceValue;
			game.getPlayers().get(playerId).setScore(score[playerId]);
			
	}
		
		public void finalRound(int playerId,int diceValue){
		if(score[playerId]==95&&diceValue<6){
			scoreSetting(playerId,diceValue);
		}
		else if(score[playerId]==96&&diceValue<5){
			scoreSetting(playerId,diceValue);
		}
		else if(score[playerId]==97&&diceValue<4){
			scoreSetting(playerId,diceValue);
		}
		else if(score[playerId]==98&&diceValue<3){
			scoreSetting(playerId,diceValue);
		}
		else if(score[playerId]==99&&diceValue==1){
			scoreSetting(playerId,diceValue);
		}
	}
	
	public void playerPosition(int playerId,int diceValue){
		if(game.getPlayers().get(playerId).getScore()<winPoint){

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
	
	
	
	
	