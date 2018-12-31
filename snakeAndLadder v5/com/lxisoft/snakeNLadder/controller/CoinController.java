package com.lxisoft.snakeNLadder.controller;

import java.util.*;
import java.io.*;
import com.lxisoft.snakeNLadder.model.*;

public class CoinController{
	Coin[] coin= new Coin[10];
	String coinColour;
	int i;
	//int coinCount,coinNumber=0;
	
	Scanner scan= new Scanner(System.in);
	
	public CoinController (){
		initCoin();
	}
	
	
	public void initCoin(){
		coin[1]=new Coin("Green");
		coin[2]=new Coin("Blue");
		coin[3]=new Coin("Red");
		coin[4]=new Coin("Yellow");
		coin[5]=new Coin("Rose");
		coin[6]=new Coin("Violet");
		coin[7]=new Coin("Black");
		coin[8]=new Coin("White");
		coin[9]=new Coin("Brown");
		//coin[0]=new Coin("Orange");
	}
	public Coin selectCoin(int i){
		System.out.println("Player"+i+" Select coin ::");			
		printCoinList();
		coinColour=scan.nextLine();
		int key=Integer.parseInt(coinColour);
		for( i = key-1; i<coin.length; i++) {
			
			coin[i-1] =coin[i];
			//return coin[key];
		}
		//coinNumber = coinCount -1;
	
			return coin[key-1];	
	}
		

	public void printCoinList(){
		for( i=1;i<10;i++) {
			System.out.println(i + ": " + coin[i]);
		}
}		
}	