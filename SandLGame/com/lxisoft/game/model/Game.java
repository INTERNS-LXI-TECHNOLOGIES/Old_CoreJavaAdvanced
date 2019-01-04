package com.lxisoft.game.model;

import java.util.*;


public class Game{


	private Board board=new Board();
	private Player players=new Player();
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
	public void setPlayers(Player players){

		this.players=players;
	}
	public Player getPlayers(){

		return players;
	}

}