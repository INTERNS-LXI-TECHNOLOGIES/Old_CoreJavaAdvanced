package com.lxisoft.game.model;

import java.util.*;


public class Game{


	private Board board=new Board();
	private ArrayList<Player> players=new ArrayList<Player>();
	private Coin coins=new Coin();
	private Dice dice=new Dice();

	public void setBoard(Board board){

		this.board=board;
	}
	public Board getBoard(){

		return board;
	}
	public void setCoins(Coin coins){

		this.coins=coins;
	}
	public Coin getCoins(){

		return coins;
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