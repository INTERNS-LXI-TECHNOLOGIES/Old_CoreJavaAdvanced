package com.lxisoft.metro.model;

public class Admin{
	private String userName;
	private String passWord;
	
	
	public Admin(String userName,String passWord){
		this.userName=userName;
		this.passWord=passWord;
	}
	
	public String  getUserName(){
		return userName;
	}
	
	public String getPassWord(){
		return passWord;
	}

}