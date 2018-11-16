package com.lxisoft.snakeNladder.controller;

import com.lxisoft.snakeNladder.model.*;
import java.util.*;

public class PlayerController{
	
	Player[] player=new Player[20];
	Coin coin;
	Scanner scanner= new Scanner(System.in);
	
	
	int i,users;
	
	
		public void createPlayer(int users){
		
		for(i =1;i<=users;i++){
			player[i] = new Player(i);
			System.out.println("Name::");
			player[i].setName(scanner.nextLine());
			coin = new Coin(i);
			System.out.println("Select coin::");
			
			
		}
		for(i=1;i<=users;i++){
			showPlayerList();
		}
		}
	
	public void showPlayerList(){
		
	System.out.println("Player "+player[i].getPlayerId()+":\nName::"+player[i].getName()+"Coin"+player[i].getCoin());
		
	}
	public void selectCoin(int id){
		String key;
		System.out.println(">>>[] [1.Green] [2.Blue] [3.Red] [4.Yellow] [5.Rose] [6.Violet] [7.Black] [8.White] [9.Brown] ");
		key=scanner.nextLine();
		int num = Integer.parseInt(key);			

		/* switch(num){
				 case 1:player[i].setCoin("Green\n");
				 break;
				 case 2:player[i].setCoin("Blue\n");
				 break;
				 case 3:player[i].setCoinColour("Red\n");
				 break;
				 case 4:player[i].setCoinColour("Yellow\n");
				 break;
				 default:System.out.println("Invalied");
			 }*/
}