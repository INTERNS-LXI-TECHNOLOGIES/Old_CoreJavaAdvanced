package  com.lxisoft.snakenladder.controller;

import java.util.*;
import com.lxisoft.snakenladder.model.*;
public class PlayerController{

	Player player;
	DieController die;
	PlayerCoin coin;
	String name;
	int rollno;
	int point[]=new int[20];
	int playerno;
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
		do{
		System.out.println("Turn of :"+player.getName()+":\t"+coin.getCoin()+player.getPoint());
		rollDie(k);
	}while(player.getPoint()==100);
	}
	public void rollDie(int id)
	{

		System.out.println("Enter 1 to rolling the die");
		rollno=scan.nextInt();
		if(rollno==1)
		{
			die=new DieController();
			moveCoin(id);
			System.out.println(player.getPoint());
			if(die.roll==1||die.roll==6){

				System.out.println("Roll again: ");
				rollDie(id);
			}
			
		}

	}
		public void moveCoin(int id1){
		
			if(point[id1]==0&&die.roll==1)
			{

				point[id1]=1;
				player.setPoint(point[id1]);
				//	startPlay(id1);
			}
			else if(point[id1]>0&&die.roll>=1){

				point[id1]+=die.roll;
				player.setPoint(point[id1]);
					//	startPlay(id1);
			}
			else if(point[id1]==0)
			{
				point[id1]=0;
				player.setPoint(point[id1]);
						//startPlay(id1);
			}
			
			else{
				point[id1]=0;
				player.setPoint(point[id1]);
					
			}
		

	}
}