package com.lxisoft.model;

public class Player {
	
private String name;
//private button;
int playerId;


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
}