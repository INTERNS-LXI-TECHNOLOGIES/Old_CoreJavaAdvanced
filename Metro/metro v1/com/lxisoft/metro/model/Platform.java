package com.lxisoft.metro.model;
import java.io.*;

public class Platform implements Serializable{
 private int platformNumber;
 public Platform(int platformNumber){
		this.platformNumber=platformNumber;
	}
	
	public int  getPlatformNumber(){
		return platformNumber;
	}
public String toString(){ 
		return "Platform"+platformNumber;  
	}
	
}