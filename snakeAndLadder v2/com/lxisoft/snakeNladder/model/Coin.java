package com.lxisoft.snakeNladder.model;

public class Coin{
String coinColour;
int playerId;
public Coin(int playerId){
this.playerId=playerId;

}

public String getCoinColour() {
	return coinColour;
	
}

public void setCoinColour(String coinColour) {
	this.coinColour = coinColour;

}
}