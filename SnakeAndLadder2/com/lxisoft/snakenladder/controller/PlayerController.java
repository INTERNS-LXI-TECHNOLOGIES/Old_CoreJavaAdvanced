package  com.lxisoft.snakenladder.controller;

import java.util.*;
import com.lxisoft.snakenladder.model.*;
public class PlayerController{
	Player player;
	DieController die;
	PlayerCoin coin;
	String name;
	int rollno;
	int point[]=new int[500];
	int playerno,dieno;
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
		
		rollDie(k);
	}
	}
	public void rollDie(int id)
	{
		System.out.println("Turn of :"+player.getName()+":\t"+coin.getCoin()+point[id]);
		System.out.println("Enter 1 to rolling the die");
		rollno=scan.nextInt();
		if(rollno==1)
		{
			die=new DieController();
			dieno=die.roll;
		}

	}
	public void setPoint(int id2,int points){
		player.setPoint(points);
	}
	public void rollAgain(int id1){


		//System.out.println(player.getPoint());
		System.out.println("Roll again: "+player.getName());
		rollDie(id1);

	/**	if(point[id1]>1&&point[id1]<100){
		point[id1]+=dieno;
		player.setPoint(point[id1]);
		
	}*/
		//setPoint(point[id1]);
		

	}
			
}
		
