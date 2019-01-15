package com.lxisoft.snakeNLadder.model;

import java.util.*;
/** Represents a Board.
 * @author Deepthi E
 */
public class Game{
	
	//private ArrayList<Player> playerList=new ArrayList<Player>();
	
	//private Player player = new Player();
	
	//private Dice dice= new Dice();
	
	//private Board board= new Board();
	
	private Coin coin;
		
	
	private ArrayList<Coin> coinList= new ArrayList<Coin>();

/** Creates an ArrayList of playerCoins with the specified colour.
  * @param playerCoin's The player’s coin with a String colour.
  */
public void setPlayerCoins(ArrayList<Coin> coinList){
	this.coinList=coinList;
}


/** Gets the playerCoins from the ArrayList .
  * @return An ArrayList of String representing the playerCoin's colour.
  */
public ArrayList<Coin> getPlayerCoins(){
	return coinList;
}


	
/** Sets the players to the Game.
  * @param cell the game's player.
  */

/*	public void setPlayers(ArrayList<Player> playerList){
		this.playerList=playerList;	
	}*/
	
/** Gets the player in the Game.
  * @return the player.
  */
/*	public ArrayList<Player> getPlayers(){
		return playerList;
	}
	
/** Sets the player for the Game.
  * @param player the player for the game.
  */
	
/*	public void setPlayer(Player player){
		this.player=player;	
	}
	
/** Gets the player.
  * @return the player.
  */
/*	public Player getPlayer(){
		return player;
	}

/**Sets the Board.
  *@param board the board object.
  */
/*  public void setBoard(Board board){
	  this.board= board;
	  
  }
/** Gets the Board.
  * @return A board.
  */
  
/*	public Board getBoard(){
		return board;
		}	
/**Sets the Dice.
  *@param dice the Dice object.
  */
/*  public void setDice(Dice dice){
	  this.dice= dice;
	  
  }
	

/** Gets the Dice.
  * @return A dice.
  */
  
/*	public Dice getDice(){
		return dice;
		}
	
	
/** Sets the coins for the Game.
  * @param coins the coin for the game.
  */
	
	public void setCoins(Coin coin){
		this.coin=coin;	
	}
	
/** Gets the coins.
  * @return the coins.
  */
	public Coin getCoin(){
		return coin;
	}
	
}
	