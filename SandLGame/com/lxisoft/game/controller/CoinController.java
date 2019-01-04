package com.lxisoft.game.controller;

import com.lxisoft.game.model.Coin;

import java.util.*;
public class CoinController{

	Coin coins=new Coin();
	ArrayList<String> coinsList=new ArrayList<String>();
	 public void createCoins(){

	 	coinsList.add("RED");
	 	coinsList.add("GREEN");
	 	coinsList.add("BLUE");
	 	coinsList.add("ORANGE");
	 	coinsList.add("YELLOW");
	 	coins.setPlayerCoins(coinsList);

	 }


	
}