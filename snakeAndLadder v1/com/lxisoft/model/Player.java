package com.lxisoft.model;

public class Player {
	
String name;

int score;

int playerId;

String coinColour;


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

public String getCoinColour() {
	return coinColour;
	
}

public void setCoinColour(String coinColour) {
	this.coinColour = coinColour;

}

public int getScore() {
	return score;
	
}

public void setScore(int score) {
	this.score= score;

}
}