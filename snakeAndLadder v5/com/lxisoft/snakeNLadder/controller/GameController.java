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
	PlayerController playerControl=new PlayerController();
	BoardController boardControl = new BoardController();
	DiceController diceControl =new DiceController();
	CoinController coinControl= new CoinController();
	
	Scanner scan= new Scanner(System.in);
	int i,players,key,playerNumber,playerNumber1,diceValue,score;
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
		playerControl = new PlayerController();
		System.out.println(" <<[1.Player registration]>> <<[2.Player Login]>> <<[3.Exit]>>");
		System.out.println("\n\n");
		
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
		
		System.out.println(id);
		System.out.println("Name::"); name=scan.nextLine();
		//player=new Player(name);
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
				while((line=br.readLine())!=null);
				do{
					String[] data = line.split(",");
					regDate=data[0];
					playerName1=data[1];
					password1=data[2];
				if(lPlayerName.equals(playerName1) && lPassword.equals(password1)){
					count++;}	
			}while(false);
			if(count>0){
				current=count;
				count=0;
				lPassword="";lPlayerName="";
				//break;
				}
			playerName1="";password1="";
			c1=0;
		if(current>0){
			System.out.println("\n\nLOGIN SUCCESSFUL\n");
			System.out.println("BEST OF LUCK\n");
			System.out.println("Details of Registration-->>"+line);
			Thread.sleep(1000);
			}
		else{
			System.out.println("LOGIN UNSUCCESSFULL\n");
			System.out.println("PLEASE RETRY.............!!");
			Thread.sleep(1000);}
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
		playerControl.playerList.get(i-1).setCoins(coinControl.getPlayerCoin());
		Thread.sleep(1000);
			//cls();
			//playerControl.player.setCoins(coinControl.coinList(coinColour));	
			}

			System.out.println("Players are-->>");
			System.out.println(playerControl.playerList);
			System.out.println("\n\n         <<<<<<<<<<<<<***********************>>>>>>>>>>>>\n\n");	
			Thread.sleep(2000);
			cls();
		}	

		/**
		* Method to playGame.
		*/
		
		public void playGame(int players)throws InterruptedException{
		System.out.println("              <<<<<<<<<<<<<<<<GAME STARTS>>>>>>>>>>>>>>\n\n");
		do{
		for(i=0;i<players;i++){
		boardControl.printBoard(game);	
		
		Thread.sleep(2000);
		//cls();
		
		//System.out.println(players);
		startPlay(i);
		//changeScore(i);
		//playerPosition(i);
		//System.out.println("Score::"+game.getPlayer().getScore());
		}
		}while(game.getPlayer().getScore()<=100);
		
		}
		
		public void startPlay(int playerId){
			
		System.out.println( "playerScore"  +game.getPlayer().getScore());
		if(playerControl.playerList.get(playerId).getScore()<=100){
		System.out.println("\n*********************\nTurn of Player  "+playerControl.playerList.get(playerId).getName());
		diceValue=playerControl.startRollDice(game);
		changeScore(playerId);
			}
		}
		
		
		
		public void changeScore(int playerId){
		if(playerControl.score[playerId]==0&&diceValue>=1){
			playerControl.score[playerId]=0;
			playerControl.playerList.get(playerId).setScore(playerControl.score[playerId]);
			System.out.println("Score::"+playerControl.playerList.get(playerId).getScore());

		}
		
		else if(playerControl.score[playerId]==0&&diceValue==1){
			System.out.println(playerControl.score[playerId]);
			scoreSetting(playerId);
			//playerController.score[id]=1;
			//playerController.player[id].setScore(playerController.score[id]);
			System.out.println("Score::"+playerControl.playerList.get(playerId).getScore());
		}
		
		else if(playerControl.score[playerId]>=1&&playerControl.score[playerId]<=94&&diceValue>=1){
			scoreSetting(playerId);
			System.out.println("Score::"+playerControl.playerList.get(playerId).getScore());
			boardControl.snakeCheck(game,playerId);
			boardControl.ladderCheck(game,playerId);
		}
		else if(playerControl.score[playerId]>94&&playerControl.score[playerId]<=100){
			finalRound(playerId);
			System.out.println("Score::"+playerControl.playerList.get(playerId).getScore());
		}
		//boardControl.printBoard(game);
		}
		
		
		public void finalRound(int playerId){
		if(playerControl.score[playerId]==95&&diceValue<6){
			scoreSetting(playerId);
		}
		else if(playerControl.score[playerId]==96&&diceValue<5){
			scoreSetting(playerId);
		}
		else if(playerControl.score[playerId]==97&&diceValue<4){
			scoreSetting(playerId);
		}
		else if(playerControl.score[playerId]==98&&diceValue<3){
			scoreSetting(playerId);
		}
		else if(playerControl.score[playerId]==99&&diceValue==1){
			scoreSetting(playerId);
		}
	
	}
	
	public void scoreSetting(int playerId){
		System.out.println(playerControl.playerList.get(playerId).getName());
		System.out.println("PlayerScore ))"+game.getPlayer().getScore());
		System.out.println("Dice>>>>>>>"+playerControl.score[playerId]);
			playerControl.score[playerId]+=diceValue;
			playerControl.playerList.get(playerId).setScore(playerControl.score[playerId]);
			int playerScore1=playerControl.playerList.get(playerId).getScore();
			//game.getPlayers().playerList.get(playerId).setScore(playerScore1);
			System.out.println("playerScore on board"+game.getPlayer().getScore());
	}
	
	
	
	public void snakeSwallowing(int playerId){
		playerControl.playerList.get(playerId).setScore(playerControl.score[playerId]);
		System.out.println("Fall to "+playerControl.playerList.get(playerId).getScore());
		
	}
	

	public void jumbingThrowLadder(int playerId){
			playerControl.playerList.get(playerId).setScore(playerControl.score[playerId]);
			System.out.println(">>>>>>>>>>Jumb to "+playerControl.playerList.get(playerId).getScore()+"<<<<<<<<<<\nRoll again......"+playerControl.playerList.get(playerId).getName());
			playerContol.startRollDice(playerId);
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