package com.lxisoft.snakeNLadder.controller;

import java.util.*;
import java.io.*;
import com.lxisoft.snakeNLadder.model.*;

/** Represents a CoinController.
 * @author Deepthi E
 */

public class CoinController{
	Coin coin=new Coin();
	//ArrayList<Coin> coinList= new ArrayList<Coin>();
	/*public void createCoins(){
		
		coinList.add(coin=new Coin("Green"));
		coinList.add(coin=new Coin("Blue"));
		coinList.add(coin=new Coin("Red"));
		coinList.add(coin=new Coin("Yellow"));
		coinList.add(coin=new Coin("Rose"));
		coinList.add(coin=new Coin("Violet"));
		coinList.add(coin=new Coin("Black"));
		coinList.add(coin=new Coin("White"));
		coinList.add(coin=new Coin("Brown"));
		coin.setPlayerCoins(coinList);
	}
	
	public void printCoinList(){
	
	System.out.println(coinList);	
	}*/
	
	ArrayList<String> coinList= new ArrayList<String>();
	/**
	 * The method to createCoins with specified colours.
	 */
	public void createCoins(){
		
		coinList.add("Green");
		coinList.add("Blue");
		coinList.add("Red");
		coinList.add("Yellow");
		coinList.add("Rose");
		coinList.add("Violet");
		coinList.add("Black");
		coinList.add("White");
		coinList.add("Brown");
		coin.setPlayerCoins(coinList);
	}
	
	
	public void printCoinList(){
	
	System.out.println(coinList);	
	}
		
	public void createPlayerCoin(String colour){
		coin=new Coin(colour);
	}
	public Coin getPlayerCoin(){
		return coin;
	}
	
}	