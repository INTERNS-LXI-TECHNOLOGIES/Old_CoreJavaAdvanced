package com.lxisoft.snakeNLadder.controller;

import java.util.*;
import java.io.*;
import com.lxisoft.snakeNLadder.model.Coins;

public class CoinController{
	Coins coin;
	String coinColour;
	int i;
	Scanner scan= new Scanner(System.in);
	
	public Coins selectCoin(int i){
			System.out.println("Player"+i+" Select coin ::");
			System.out.println(">>>[1.Green][2.Blue][3.Red][4.Yellow][5.Rose][6.Violet][7.Black][8.White][9.Brown] ");
			coinColour=scan.nextLine();
			
			int key=Integer.parseInt(coinColour);
			if(key==1){
			coin=new Coins("Green");}
			else if(key==2){
			coin = new Coins("Blue");}
			else if(key==3){
			coin = new Coins("Red");}
			else if(key==4){
			coin = new Coins("Yellow");}
			else if(key==5){
			coin =new Coins("Rose");}
			else if(key==6){
			coin = new Coins("Violet");}
			else if(key==7){
			coin = new Coins("Black");}
			else if(key==8){
			coin = new Coins("White");}
			else if(key==9){
			coin =new Coins("Brown");}	
		return coin;
	}
}
	