package com.lxisoft.snakeNLadder.controller;

import com.lxisoft.snakeNLadder.model.*;
import java.util.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
import java.io.*;
import java.util.regex.*;


/** Represents a PlayerController.
 * @author Deepthi E
*/

public class PlayerController{
	Player player;
	ArrayList<Player> playerList= new ArrayList<Player>();
	Scanner scan = new Scanner(System.in);
	FileWriter fw = null;
    BufferedWriter bw = null;
	int[] score = new int[100];
	String name,password,playerName,regDate,lPlayerName,lPassword;
	String password1="",playerName1="",line1="";
	int len,c1=0,count=0,current=0;
	boolean validate;
	
    File playerRegister= new File("./PlayerRegister.txt");	
	public void playerRegestration(int id)throws InterruptedException{
		
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
        String strDate = dateFormat.format(date);
		
		System.out.println(id);
		System.out.println("Name::"); name = scan.nextLine();
		System.out.println("Enter a Strong password ...\n# Must contains one lowercase characters.\n# Must contains one digit from 0-9.\n# Must contains one uppercase characters.\n\n# Must contains one special symbols in the list(@#$%) \n# Length at least 6 characters and maximum of 10 ");
		System.out.println("Password::");
		password=passwordValidation();
		addToFile(id,strDate,name,password); 
	}

	public String passwordValidation(){
		
		
  /**
	*(# Start of group
    *(?=.*\\d) # Must contains one digit from 0-9.
    *(?=.*[a-z]) # Must contains one lowercase characters.
    *(?=.*[A-Z]) # Must contains one uppercase characters.
    *(?=.*[@#$%]) # Must contains one special symbols in the list "@#$%".
             	# Match anything with previous condition checking
    *{6,20}	#Length at least 6 characters and maximum of 20	
    *) # End of group*/	
		
	String password_Regex="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10}"; 	
	String pass=scan.nextLine();
	validate=Pattern.matches(password_Regex, pass);
	if(validate==true){
		return pass;	
	}
	else{
		System.out.println("Re-enter the password:");
		passwordValidation();	}
		return pass;
	}
	
    public void addToFile(int id,String regDate,String name,String password)throws InterruptedException{
	try{
		fw = new FileWriter(playerRegister,true);
		bw = new BufferedWriter(fw);
		
		bw.write(regDate+",");
		bw.write(name+",");
		bw.write(password);
		bw.newLine();
		
		player = new Player(id,name,password);
		playerList.add(player);
		System.out.println("Register Successfully......");
		Thread.sleep(1000);
	}catch(IOException e){
			System.out.println("Error");	
		}finally{
			try{
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			}catch(IOException e){
				e.printStackTrace();}
		}
	}
	
	

	public void login()throws InterruptedException{
		
	  System.out.println("Name::"); lPlayerName = scan.nextLine();
	  System.out.println("Password::"); lPassword = scan.nextLine();
	  String line; 
		try{
				FileReader fr=new FileReader(playerRegister);
				BufferedReader br=new BufferedReader(fr);
				while((line=br.readLine())!=null);
				do{
					String[] data = line.split(",");
					regDate=data[0];
					playerName1=data[1];
					password1=data[2];
				if(lPlayerName.equals(playerName1) && lPassword.equals(password1)){
					count++;}	
			}while(false);
			if(count>0){
				current=count;
				count=0;
				lPassword="";lPlayerName="";
				//break;
				}
			playerName1="";password1="";
			c1=0;
		if(current>0){
			System.out.println("\n\nLOGIN SUCCESSFUL\n");
			System.out.println("BEST OF LUCK\n");
			System.out.println("Details of Registration-->>"+line);
			Thread.sleep(1000);
			}
		else{
			System.out.println("LOGIN UNSUCCESSFULL\n");
			System.out.println("PLEASE RETRY.............!!");
			Thread.sleep(1000);}
	}catch(IOException e){
			System.out.println("Error");}
}
}	