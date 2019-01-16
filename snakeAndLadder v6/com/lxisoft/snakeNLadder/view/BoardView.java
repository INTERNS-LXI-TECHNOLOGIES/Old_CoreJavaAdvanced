package com.lxisoft.snakeNLadder.view;
import com.lxisoft.snakeNLadder.model.*;
import java.util.*;
public class BoardView{
	public void  printSnakeReached(int playerScore,int snakeId){
		System.out.println("Falling to....."+playerScore+"Oooops.... Snake"+snakeId);
	}
	public void printLadderReached(int playerScore,int ladderId){
		System.out.println("jumbing to....."+playerScore+"Wow....Ladder"+ladderId);
	}
}