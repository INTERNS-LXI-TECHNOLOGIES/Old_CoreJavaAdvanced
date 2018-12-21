package com.lxisoft.snakeNLadder.controller;
import java.util.*;
import java.io.*;

public class GameController{
	
	PlayerController playerControl = new PlayerController();
	
	Scanner scan= new Scanner(System.in);
	int noOfPlayers,i;
	String[] s=new String[20];
	String loginName,loginPassWord;
	String line,password1="",name1="",line1;
	int len,c1=0,count=0,current=0,agree;
	char st;
	public static final String file="./PlayerRegister.txt";
	public GameController(){
		System.out.println("\t\t\t\t----------WELCOME----------");
		System.out.println("[1.Player Login] [2.Player registration][3.Exit]");
		System.out.println("\n\n");
		
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
	//System.out.println(result);
		
		//String choice = scan.nextInt();
		switch(key){
			case 1: System.out.println("Enter Number of Players::");
					noOfPlayers = scan.nextInt();
					for(i=1;i<=noOfPlayers;i++){login();};break;
		    case 2: System.out.println("Enter Number of Players::");
					noOfPlayers = scan.nextInt();
					for(i=1;i<=noOfPlayers;i++){
					playerControl.playerRegestration();}
			break;
			case 3: System.exit(0);break;
		    default: System.out.println("YOU ENTERED A WRONG CHOICE");
		}
	}
	
	/*public void login(){
		/*System.out.println("ENTER THE USERNAME");
		username=System.console().readLine();
		System.out.println("ENTER THE PASSWORD");
		password=System.console().readLine();
			       
	System.out.println("Name::");
	loginName=scan.nextLine();
	System.out.println("Password::");
	loginPassWord=scan.nextLine();
	try{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while((line=br.readLine())!=null){
			len=line.length();
			do{
				while((st=line.charAt(c1))!='|'){
					name1+=st;
					c1++;
				}
				c1++;
				while(c1<len){
					st=line.charAt(c1);
					password1+=st;
					c1++;
				}
				if(loginName.equals(name1) && loginPassWord.equals(password1)){
					count++;
				}	
			}while(false);
			if(count>0){
				current=count;
				count=0;
				loginPassWord="";
				loginName="";
				break;
			}
			name1="";
			password1="";
			c1=0;
			
		}
		if(current>0){
			System.out.println("\n\nLOGIN SUCCESSFUL");
			System.out.println("\n\n");
			System.out.println("BEST OF LUCK....");
			}
		else
		{
			System.out.println("LOGIN UNSUCCESSFULL");
			System.out.println("\n\n");
			System.out.println("PLEASE RETRY...........  :|");
		}
	}catch(IOException e){
		  // System.out.println("//////");
			System.out.println("Error");	
		}

}*/
}