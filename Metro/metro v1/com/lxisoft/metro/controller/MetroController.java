package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.*;
import com.lxisoft.metro.view.*;
import java.util.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

public class MetroController{
	Metro metro=new Metro();
	MetroView metroView= new MetroView();
	Scanner scan= new Scanner(System.in);
	Date date=new Date();
	
	public void homePage(){	
	dateFormating();
	metroView.printHomeView(date);
	
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
		switch(key){
		case 1: adminLogin();	
		break;
		default: System.exit(0);
		
	}
	}
	private void dateFormating(){
	String strDate;
	date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
    strDate = dateFormat.format(date);

	}
	
	public void adminLogin(){
		String userName,passWord;
		metroView.enterUserName();userName=scan.next();
		metroView.enterPassWord();passWord=scan.next();
		if(userName.equals("AdminLog") && passWord.equals("admin")){
			metroView.loginSucceed();
		}else {
			metroView.loginFailed();
		}
		
	}
	
	
	
	
	
	
	
	
	
}