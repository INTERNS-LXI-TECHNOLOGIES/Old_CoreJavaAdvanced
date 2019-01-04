package com.lxisoft.game.model;

public class Player{

	private String playersName;
	private String playersPhNo;
	private String playersEmailId;
	private String playersPassword;
	private int playersScore=0;

	public void setPlayersName(String playersName){

		this.playersName=playersName;
	}
	public String getPlayersName(){

		return playersName;
	}
	public void setPlayersPhNo(String playersPhNo){

		this.playersPhNo=playersPhNo;
	}
	public String getPlayersPhNo(){

		return playersPhNo;
	}
	public void setPlayersEmailId(String playersEmailId){

		this.playersEmailId=playersEmailId;
	}
	public String getPlayersEmailId(){

		return playersEmailId;
	}
	public void setPlayersPassword(String playersPassword){

		this.playersPassword=playersPassword;
	}

	public String getPlayersPassword(){

		return playersPassword;
	}
	public void setPlayersScore(int playersScore){

		this.playersScore=playersScore;
	}
	public int getPlayersScore(){

		return playersScore;
	}

}