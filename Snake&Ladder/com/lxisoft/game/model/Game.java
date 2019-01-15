package com.lxisoft.game.model;

import java.util.*;


public class Game{


	private Board board;
	private ArrayList<Player> players=new ArrayList<Player>();
	private ArrayList<Coin> coinsList=new ArrayList<Coin>();
	private Dice dice;

	public void setBoard(Board board){

		this.board=board;
	}
	public Board getBoard(){

		return board;
	}
	public void setCoins(ArrayList<Coin> coinsList){

		this.coinsList=coinsList;
	}
	public ArrayList<Coin> getCoins(){

		return coinsList;
	}
	public void setDice(Dice dice){

		this.dice=dice;
	}
	public Dice getDice(){

		return dice;
	}
	public void setPlayers(ArrayList<Player> players){

		this.players=players;
	}
	public ArrayList<Player> getPlayers(){

		return players;
	}

}