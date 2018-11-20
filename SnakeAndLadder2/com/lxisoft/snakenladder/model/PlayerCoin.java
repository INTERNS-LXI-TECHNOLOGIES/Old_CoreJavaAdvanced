package com.lxisoft.snakenladder.model;

public class PlayerCoin{

	String coin[]={"Red","Blue","Yellow","Green","pink","orange","black","brown","rose","violet",""};
	int val;
	public PlayerCoin(int value){
		val=value;
		for(int i=1;i<=val;i++){
		
			this.coin[i]=coin[i];
		}
	}
	public String getCoin(){
		return coin[val];

	}

}