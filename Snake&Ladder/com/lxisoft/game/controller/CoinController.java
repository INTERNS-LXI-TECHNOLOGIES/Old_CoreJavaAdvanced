package com.lxisoft.game.controller;

import com.lxisoft.game.model.Coin;

import java.util.*;
public class CoinController{

	
	ArrayList<Coin> coinsList=new ArrayList<Coin>();
	 public void createCoins(){

	 	Coin coin1=new Coin("RED");
	 	Coin coin2=new Coin("GREEN");
	 	Coin coin3=new Coin("BLUE");
	 	Coin coin4=new Coin("ORANGE");
	 	Coin coin5=new Coin("YELLOW");
	 	coinsList.add(coin1);
	 	coinsList.add(coin2);
	 	coinsList.add(coin3);
	 	coinsList.add(coin4);
	 	coinsList.add(coin5);

	 }
	 public ArrayList<Coin> getCoinsList(){

		return coinsList;
	}
	public void remove(Coin coin){

		for(int i=0;i<coinsList.size();i++){
		if(coinsList.get(i).equals(coin)==true){

			coinsList.remove(coin);
			//System.out.println(coinsList);
		}
	}
	}


	
}