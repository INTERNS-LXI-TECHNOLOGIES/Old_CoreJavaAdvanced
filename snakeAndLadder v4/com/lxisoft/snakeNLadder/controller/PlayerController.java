package com.lxisoft.snakeNLadder.controller;
import com.lxisoft.snakeNLadder.model.*;

import java.util.*;
import java.io.*;

public class PlayerController{

	Player player;
	String name,password,coinColour,playerName;
	Scanner scan = new Scanner(System.in);
	FileWriter fw = null;
    BufferedWriter bw = null;

    private static final String file="./PlayerRegister.txt";	
	//boolean newFile=false;
	public void playerRegestration(){
		
	  Date date = new Date();
	  System.out.println("Date:"+ date.toString());
	  System.out.println("Name::");
	  name = scan.nextLine();
	  System.out.println("Password::");
	  password = scan.nextLine();
	  System.out.println("Coin::");
	  coinColour = scan.nextLine();
	  addToFile(name,password);
	 
}

public void addToFile(String name,String password){
	
   /* 
//create a new file and add data to it
   File file = new File("./PlayerRegister.txt");
	   //private static final String file="./PlayerRegister.txt";
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
			
            fr.write(name);
			fr.write("|");
			fr.write(password);
			
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
	try{
	fw = new FileWriter(file,true);
    bw = new BufferedWriter(fw);
	bw.write("\n");
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

}