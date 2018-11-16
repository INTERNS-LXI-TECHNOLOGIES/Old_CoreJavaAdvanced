package com.lxisoft.snakeNladder.model;

public class Player{
String name;

int score;

int playerId;

Coin coin;


public Player(int playerId){
	this.playerId = playerId;
	
}

public int getPlayerId(){
	return playerId;
	
}
public String getName() {
	return name;
	
}

public void setName(String name) {
	this.name = name;

}

public Coin getCoin() {
	return coin;
	
}

public void setCoin(Coin coin) {
	this.coin = coin;

}

public int getScore() {
	return score;
	
}

public void setScore(int score) {
	this.score= score;

}
}