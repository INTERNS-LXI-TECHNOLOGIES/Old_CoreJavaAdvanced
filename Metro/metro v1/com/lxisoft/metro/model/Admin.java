package com.lxisoft.metro.model;

public class Admin{
	private String userName;
	private String passWord;
	
	
	public void setUserName(String userName){
		this.userName=userName;	
	}
	
	public String  getUserName(){
		return userName;
	}

	public void setPassWord(String passWord){
		this.passWord=passWord;	
	}
	

	public String getPassWord(){
		return passWord;
	}

}