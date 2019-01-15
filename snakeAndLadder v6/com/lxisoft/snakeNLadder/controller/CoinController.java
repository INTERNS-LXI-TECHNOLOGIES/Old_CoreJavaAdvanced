package com.lxisoft.snakeNLadder.controller;

import java.util.*;
import java.io.*;
import com.lxisoft.snakeNLadder.model.*;


public class CoinController{

 private Coin coin;
 ArrayList<Coin> coinList= new ArrayList<Coin>();

	public void createCoins(){
				
		coinList.add(new Coin("Green"));
		coinList.add(new Coin("Blue"));
		coinList.add(new Coin("Red"));
		coinList.add(new Coin("Yellow"));
		coinList.add(new Coin("Rose"));
		coinList.add(new Coin("Violet"));
		coinList.add(new Coin("Black"));
		coinList.add(new Coin("White"));
		coinList.add(new Coin("Brown"));

	}
	
	/*public ArrayList<Coin> getCoinList(){
		return coinList;
	}*/
	
	
}