package com.lxisoft.game.model;

import java.util.*;


public class Game{


	private Board board=new Board();
	private ArrayList<Players> players=new ArrayList<Players>();
	private Coins Coins=new Coins();
	private Dice dice=new Dice();

	public void setBoard(Board board){

		this.board=board;
	}
	public Board getBoard(){

		return board;
	}
	public void setCoins(Coins coins){

		this.coins=coins;
	}
	public Coins getCoins(){

		return coins;
	}
	public void setDice(Dice dice){

		this.dice=dice;
	}
	public Dice getDice(){

		return dice;
	}
	public void setPlayers(ArrayList<Players> players){

		this.players=players;
	}
	public ArrayList<Players> getPlayers(){

		return players;
	}

}