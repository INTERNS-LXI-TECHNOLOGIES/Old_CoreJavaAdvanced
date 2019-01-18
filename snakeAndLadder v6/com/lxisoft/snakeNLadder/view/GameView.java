package com.lxisoft.snakeNLadder.view;
import com.lxisoft.snakeNLadder.model.*;
import java.util.*;
public class GameView{
	
	public void homePage(Date date){
		
		System.out.println("\t\t\t\t---------------------");
		System.out.println("\t\t\t\t<<<SNAKE & LADDER>>>");
		System.out.println("\t\t\t\t---------------------\n");
		System.out.println("Date:"+ date.toString()+"\n");
		System.out.println(" <<[1.Player registration]>> <<[2.Player Login]>> <<[3.Exit]>>\n\n");
	}
	public void enterNumOfPlayers(){
		System.out.println("Enter Number of Players::");
	}
	public void enterPlayerName(int id){
		System.out.println(id+">");
		System.out.println("Name::");
	}
	public void passwordInstructions(){
		System.out.println("Enter a Strong password ...\n# Must contains one lowercase characters.\n# Must contains one digit from 0-9.\n# Must contains one uppercase characters.\n\n# Must contains one special symbols in the list(@#$%) \n# Length at least 6 characters and maximum of 10 ");
	}
	public void enterPassword(){
		System.out.println("Password::");
		
	}
	public void printCoinList(Game game){
		System.out.println(game.getPlayerCoins());
		System.out.println("Select your coin ::");
	}
	public void printPlayerCoins(Game game){
		System.out.println("Players are-->>");
		System.out.println(game.getPlayers());
		System.out.println("\n\n         <<<<<<<<<<<<<***********************>>>>>>>>>>>>\n\n");
	}		
public void printLoginStatus(int i,String line){
	if(i>0){
		System.out.println("\n\nLOGIN SUCCESSFUL\nBEST OF LUCK\nDetails of Registration-->>"+line);
	}
	else{
		System.out.println("LOGIN UNSUCCESSFULL\nPLEASE RETRY.............!!");
	}
}	
public void printScore(Game game,int playerId){
	System.out.println("Score::"+game.getPlayers().get(playerId).getScore());
}
}