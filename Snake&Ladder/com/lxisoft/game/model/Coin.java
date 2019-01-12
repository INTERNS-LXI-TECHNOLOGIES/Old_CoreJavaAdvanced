package com.lxisoft.game.model;

import java.util.*;

public class Coin{

	//String[] playerCoins={"RED","GREEN","BLUE","ORANGE","YELLOW"};
	
	private ArrayList<String> playerCoins=new ArrayList<String>();

	public void setPlayerCoins(ArrayList<String> playerCoins){

		this.playerCoins=playerCoins;
	}
	public ArrayList<String> getPlayerCoins(){

		return playerCoins;
	}
}