package com.lxisoft.snakenladder.model;

public class PlayerCoin{

	String coin[]={"Red","Blue","Yellow","Green","white","black","orange","brown","purple","violet","pink","rose",""};
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