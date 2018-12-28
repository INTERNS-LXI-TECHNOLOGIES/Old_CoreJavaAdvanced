package com.lxisoft.game.controller;

import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;
import com.lxisoft.game.model.Player;


public class PlayerController{

	Player players=new Player();
	Scanner input=new Scanner(System.in);
	String email,pass;
	public void playersRegistration(int limit){

		try{

			File playersDetails=new File("./com/lxisoft/game/playersDetails.txt");
			FileWriter details=new FileWriter(playersDetails);
			for(int j=1;j<=limit;j++){
				details.write("Players"+j+"Details"+";");
				System.out.println("*******<<<<<<<REGISTER>>>>>>>>*******");
				System.out.println("Full Name:");
				players.setPlayersName(input.nextLine());
				details.write(players.getPlayersName()+";");
				System.out.println("Phone Number:");
				validatePhone();
				details.write(players.getPlayersPhNo()+";");
				System.out.println("Email Id:");
				validateEmail();
				details.write(players.getPlayersEmailId()+";");
				System.out.println("Password");
				players.setPlayersPassword(input.nextLine());
				details.write(players.getPlayersPassword()+"\n");
				System.out.println("Registered Successfully");
				
			}
			details.close();
			System.out.println("Please Login.....any one player\n");
			playersLogin();

		}
		catch(Exception e){

			e.printStackTrace();
		}

	}
	public void playersLogin(){

		System.out.println("*******<<<<<<<<LOGIN>>>>>>>******* ");
		System.out.println("Email Id:");
		email=input.nextLine();
		System.out.println("Password");
		pass=input.nextLine();
		loadFile();
	}
	public void loadFile()
	{
		
		try
		{
			FileReader fr=new FileReader("./com/lxisoft/game/playersDetails.txt");
			BufferedReader br=new BufferedReader(fr);
			String line,data1,data2;
			
			while((line=br.readLine())!=null)
			{
				String data[]=line.split(";");
				data1=data[3];
				data2=data[4];
				checkLogin(data1,data2);
			}	
			
		}	
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void checkLogin(String uName,String pwd){

			if(uName.equals(email)&&pwd.equals(pass)){

				System.out.println("login Success");
			}
	
	}
	private void validateEmail() {
		String MAIL_REGEX="\\b[\\w.%-]+@[A-Za-z]+\\.[A-Za-z]{2,3}";
		String email=input.nextLine();
		boolean validmail=Pattern.matches(MAIL_REGEX, email);
		if(validmail==true)
		{
			players.setPlayersEmailId(email);
			
		}
		else
		{
			System.out.println("Email format is incorrect.....\n Re-Enter the email");
			validateEmail();
			
		}
		
	}
	private void validatePhone() {
		
		String PH_REGEX="[6789][0-9]{9}";
		String phno=input.nextLine();
		boolean validph=Pattern.matches(PH_REGEX,phno);
		if(validph==true)
		{
			players.setPlayersPhNo(phno);
		}
		else
		{
			System.out.println("Phone Number format is incorrect.....\n Re-Enter the Phone Number");
			validatePhone();
			
		}
		
	}
}