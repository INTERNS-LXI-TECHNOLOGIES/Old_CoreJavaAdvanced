package com.lxisoft.snakeNLadder.controller;
import com.lxisoft.snakeNLadder.model.*;
import java.util.*;
public class GameController{
	
	Game game= new Game();
	
	CoinController coinControl;
	DiceController diceControl;
	
	Scanner scan= new Scanner(System.in);
	
	public GameController(){
		
		coinControl=new CoinController();
		coinControl.createCoins();
		diceControl= new DiceController();
		diceControl.createDice();
		selectPlayerCoin();
		diceControl.getDiceValues();
	}
	
	
	public void selectPlayerCoin(){
		game.setPlayerCoins(coinControl.coinList);
		System.out.println(game.getPlayerCoins());
		System.out.println("Player Select coin ::");
		String coinColour=scan.nextLine();
		removeCoin(coinColour);
		}
	public void removeCoin(String coinColour){	
		int i,size;
		size=game.getPlayerCoins().size();
		for (i=0;i<=size;i++){
		String colour=game.getPlayerCoins().get(i).getColour();
		if(coinColour.equals(colour)){
			game.getPlayerCoins().remove(i);
		break;}
			}
		}
}
	
	
	
	
	