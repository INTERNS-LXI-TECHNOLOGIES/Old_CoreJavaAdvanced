package com.lxisoft.snakeNLadder.model;

public class Coins{
String coinColour;

public Coins(String coinColour){
	this.coinColour=coinColour;}

public String getCoinColour() {
	return coinColour;}

public String toString(){ 
  return coinColour+" ";  
 }  
}