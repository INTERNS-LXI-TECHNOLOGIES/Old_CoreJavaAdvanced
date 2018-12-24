package com.lxisoft.snakeNLadder.controller;
import com.lxisoft.snakeNLadder.model.*;

import java.util.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
import java.io.*;

public class PlayerController{

	Player player;
	String name,password,coinColour,playerName,regDate,lPlayerName,lPassword;
	Scanner scan = new Scanner(System.in);
	FileWriter fw = null;
    BufferedWriter bw = null;
	String[] s=new String[20];
	String password1="",playerName1="",line1="";
	int len,c1=0,count=0,current=0;
	char st;
	
    File playerRegister= new File("./PlayerRegister.txt");	

	public void playerRegestration(){
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
        String strDate = dateFormat.format(date);  
	 
	  System.out.println("Name::");
	  name = scan.nextLine();
	  System.out.println("Password::");
	  password = scan.nextLine();
	  System.out.println("Coin::");
	  coinColour = scan.nextLine();
	  addToFile(strDate,name,password);
	 
	}

    public void addToFile(String regDate,String name,String password){
	
	try{
	fw = new FileWriter(playerRegister,true);
    bw = new BufferedWriter(fw);
	
	bw.write(regDate+"|");
	
	bw.write(name);
	bw.write("|");
	bw.write(password);
	bw.newLine();
	}catch(IOException e){
			System.out.println("Error");	
		}finally{
			try{
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			
			}catch(IOException e){
				e.printStackTrace();
		}
		}
	}
	
	/*public void signUp(){
	  System.out.println("Name::");
	  lPlayerName = scan.nextLine();
	  System.out.println("Password::");
	  lPassword = scan.nextLine();
	  try
			{
				FileReader fr=new FileReader(playerRegister);
				BufferedReader br=new BufferedReader(fr);
				while((line=br.readLine())!=null)
				{
					System.out.println(line);
					
				}
				
	}
	catch(IOException e)
			{
				System.out.println("IOException");
			}
}*/
public void login(){
	
	
	  System.out.println("Name::");
	  lPlayerName = scan.nextLine();
	  System.out.println("Password::");
	  lPassword = scan.nextLine();
	  String line;
	  
	  try
			{
				FileReader fr=new FileReader(playerRegister);
				BufferedReader br=new BufferedReader(fr);
				while((line=br.readLine())!=null)
				{
		
			//System.out.println(line);
			len=line.length();
			//System.out.println(len);
			do{
				
				while((st=line.charAt(c1))!='|'){
					regDate+=st;
					c1++;
				}
				c1++;
				while((st=line.charAt(c1))!='|'){
					playerName1+=st;
					c1++;
				}
				c1++;
				
				while(c1<len){
					st=line.charAt(c1);
					password1+=st;
					
					
					c1++;
				}
				if(lPlayerName.equals(playerName1) && lPassword.equals(password1)){
					count++;
				}	
			}while(false);
			if(count>0){
				current=count;
				count=0;
				lPassword="";
				lPlayerName="";
				break;
			}
			playerName1="";
			password1="";
			c1=0;
			
		}
		if(current>0){
			System.out.println("\n\nLOGIN SUCCESSFUL");
			System.out.println("\n\n");
			System.out.println("BEST OF LUCK");
			System.out.println("\n\n");
		  
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
    }
}