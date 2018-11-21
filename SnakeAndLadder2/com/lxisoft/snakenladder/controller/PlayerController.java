package  com.lxisoft.snakenladder.controller;

import java.util.*;
import com.lxisoft.snakenladder.model.*;
public class PlayerController{

	BoardController board=new BoardController();
	Player player;
	DieController die;
	PlayerCoin coin;
	String name;
	int rollno;
	int point[]=new int[500];
	int playerno;
	Random ran=new Random();
	Scanner scan = new Scanner(System.in);
	public PlayerController(int id){

		playerno+=id;
		name="Player"+String.valueOf(id);
		player=new Player(name);
		coin=new PlayerCoin(id);
		System.out.println(player.getName()+":\t"+coin.getCoin());
	}

	public void startPlay(int k)
	{
		point[k]=player.getPoint();
		if(point[k]<100){
		System.out.println("Turn of :"+player.getName()+":\t"+coin.getCoin()+point[k]);
		rollDie(k);
	}
	}
	public void rollDie(int id)
	{
		System.out.println("Enter 1 to rolling the die");
		rollno=scan.nextInt();
		if(rollno==1)
		{
			die=new DieController();
			moveCoin(id);
			System.out.println(point[id]);
			if(point[id]<100){
			if(die.roll==1||die.roll==6){
				System.out.println("Roll again: "+player.getName());
				rollDie(id);
			}
			}
			else if(point[id]==100){

				System.out.println("You win...\n"+"Winner is....:  "+player.getName());
				System.exit(0);
			}
			
		}

	}
		public void moveCoin(int id1){
			if(point[id1]==0&&die.roll==1)
			{

				point[id1]=1;
				player.setPoint(point[id1]);
				
			}
			else if(point[id1]==0&&die.roll>=2)
			{
				point[id1]=0;
				player.setPoint(point[id1]);
				
			}
			else if(point[id1]>=1&&point[id1]<=94&&die.roll>=1){

				point[id1]+=die.roll;
				player.setPoint(point[id1]);
				//snakeCheck(id1);
				//ladderCheck(id1);	
			}
			else if(point[id1]>94&&point[id1]<=100){
				finalFinishing(id1);
					
			}
			else{
				point[id1]=0;
				player.setPoint(point[id1]);
				
			}
		

	}
/**	public void snakeCheck(int sid){
		snake.createSnake();
		if(point[sid]==snake.sh1)
		{
			point[sid]=snake.st1;
			player.setPoint(point[sid]);
			System.out.println("Snake1 Entry");
		}
		else if(point[sid]==snake.sh2){

			point[sid]=snake.st2;
			player.setPoint(point[sid]);
			System.out.println("Snake2 Entry");
		}
		else if(point[sid]==snake.sh3){

			point[sid]=snake.st3;
			player.setPoint(point[sid]);
			System.out.println("Snake3 Entry");
		}
		else if(point[sid]==snake.sh4){

			point[sid]=snake.st4;
			player.setPoint(point[sid]);
			System.out.println("Snake4 Entry");
		}

		
		

	}
	public void ladderCheck(int lid){
		ladder.createLadder();

		if(point[lid]==ladder.lh1)
		{
			point[lid]=ladder.lt1;
			player.setPoint(point[lid]);
			System.out.println("Ladder1 Entry");
			rollDie(lid);
		}
		else if(point[lid]==ladder.lh2){

			point[lid]=ladder.lt2;
			player.setPoint(point[lid]);
			System.out.println("Ladder2 Entry");
			rollDie(lid);
		}
		else if(point[lid]==ladder.lh3){

			point[lid]=ladder.lt3;
			player.setPoint(point[lid]);
			System.out.println("Ladder3 Entry");
			rollDie(lid);
		}
		else if(point[lid]==ladder.lh4){

			point[lid]=ladder.lt4;
			player.setPoint(point[lid]);
			System.out.println("Ladder4 Entry");
			rollDie(lid);
		}
		
	}*/
	public void finalFinishing(int id2){

	if(point[id2]==95&&die.roll<=5){
		point[id2]+=die.roll;
		player.setPoint(point[id2]);
		//snakeCheck(id2);
	}
	else if(point[id2]==96&&die.roll<=4){
		point[id2]+=die.roll;
		player.setPoint(point[id2]);
	//	snakeCheck(id2);

	}
	else if(point[id2]==97&&die.roll<=3){
		point[id2]+=die.roll;
		player.setPoint(point[id2]);
	//	snakeCheck(id2);
	}
	else if(point[id2]==99&&die.roll==1){
		point[id2]+=die.roll;
		player.setPoint(point[id2]);
	}


}
}