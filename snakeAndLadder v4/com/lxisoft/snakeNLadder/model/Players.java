package com.lxisoft.snakeNLadder.model;

public class Players{
	
	String name;
	int id;
	int score;
	String password;
	String regDate;
	Coins coin;
	
	public Players(int id,String name,String password){
		this.id=id;
		this.name=name;
		this.password=password;
	}
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setCoins(Coins coin) {
		this.coin= coin;

	}
	public Coins getCoin() {
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