package com.lxisoft.model;

public class Player {
	
private String name;

private int position;

private int playerId;

private String coinColour;


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

public int getPosition() {
	return position;
	
}

public void setPosition(int position) {
	this.position = position;

}
}