package com.lxisoft.snakeNladder.controller;

import com.lxisoft.snakeNladder.model.*;
import java.util.*;

public class PlayerController{
	
	Player[] player=new Player[20];
	Coin coin;
	Scanner scanner= new Scanner(System.in);
	
	
	int users,i,key;
	String k;
	String  Orange,Green,Blue,Red,Yellow,Rose,Violet,Black,White,Brown;
	
	public void createPlayer(int users){
		
		for(i =1;i<=users;i++){
			player[i] = new Player(i);
			System.out.println("Name::");
			player[i].setName(scanner.nextLine());
			
			System.out.println("Select coin::");
			coin=selectCoin(i);
			player[i].setCoin(coin);
			
		}
		for(i=1;i<=users;i++){
			showPlayerList();
		}
	}
	
	public void showPlayerList(){
		
	System.out.println("Player "+player[i].getPlayerId()+":\nName::"+player[i].getName()+"\tCoin::"+player[i].getCoin().getCoinColour());
		
	}
	
	public Coin selectCoin(int i){
		
			System.out.println(">>>[0.Orange] [1.Green] [2.Blue] [3.Red] [4.Yellow] [5.Rose] [6.Violet] [7.Black] [8.White] [9.Brown] ");
			k=scanner.nextLine();
			int key=Integer.parseInt(k);
			if(key==0){
			coin = new Coin(i,"Orange");}
			else if(key==1){
			coin=new Coin(i,"Green");}
			else if(key==2){
			coin = new Coin(i,"Blue");}
			else if(key==3){
			coin = new Coin(i,"Red");}
			else if(key==4){
			coin= new Coin(i,"Yellow");}
			else if(key==5){
			coin=new Coin(i,"Rose");}
			else if(key==6){
			coin= new Coin(i,"Violet");}
			else if(key==7){
			coin= new Coin(i,"Black");}
			else if(key==8){
			coin= new Coin(i,"White");}
			else if(key==9){
			coin=new Coin(i,"Brown");}
			
			return coin;
			
	}
}