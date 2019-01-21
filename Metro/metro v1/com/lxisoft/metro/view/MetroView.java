package com.lxisoft.metro.view;
import java.util.*;

public class MetroView{
	
	public void printHomeView(Date date){
		System.out.println("---------------------------");
		System.out.println(">>>>>>>>>>>METRO<<<<<<<<<<<<");
		System.out.println("---------------------------");
		System.out.println(date);
		System.out.println("1.Admin ");
		
	}
	public void enterUserName(){
		System.out.println("******ADMIN LOGIN******");
		
		System.out.println("UserName");
	}
	
	public void enterPassWord(){
		System.out.println("Password::");
		
	}
	public void loginSucceed(){
		
		System.out.println("Login Successfull......");
	}
	public void loginFailed(){
		
		System.out.println("Login Unsuccessfull......");
	}
	
	public void enterTrainName(){
		System.out.println("Train Name::");
	}
	public void enterTrainNum(){
		System.out.println("Train Number::");
	}
	public void enterArraivalTime(){
		System.out.println("Arraival Time::");
	}
	public void enterDepartureTime(){
		System.out.println("Departure Time::");
	}
	public void enterStartPoint(){
		System.out.println("Starting point::");
	}
	public void enterDestination(){
		System.out.println("Destination::");
	}
	public void enterOption(){
		System.out.println("Do you want to continue?  [1.Continue]  [0.Exit] ");
	}
}