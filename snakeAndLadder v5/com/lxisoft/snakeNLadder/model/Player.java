package com.lxisoft.snakeNLadder.model;
/** Represents a Player.
 * @author Deepthi E
*/
public class Player{
	
	String name;
	int id;
	int score;
	String password;
	String regDate;
	Coin coin;
	
	public Player(int id,String name,String password){
		this.id=id;
		this.name=name;
		this.password=password;
		this.coin=coin;
	}
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setCoins(Coin coin) {
		this.coin= coin;

	}
	public Coin getCoin() {
		return coin;
	}
	
	public int getScore() {
		return score;
	
	}

	public void setScore(int score) {
		this.score= score;

	}
	public String toString(){ 
		return "Player Name::"+name+" "+" Coin::"+coin+" ";  
	}  
}