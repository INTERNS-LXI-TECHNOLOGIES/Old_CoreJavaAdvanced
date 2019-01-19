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
	
}