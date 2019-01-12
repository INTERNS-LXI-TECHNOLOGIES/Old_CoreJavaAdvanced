package com.lxisoft.game.model;
/**Represents a Player
* @author Sumi G
*/

public class Player{

	private String playersName;
	private String playersPhNo;
	private String playersEmailId;
	private String playersPassword;
	private int playersScore=0;
	
	/**Sets the player's name
	*@param playersName A String containing the player's name
	*/

	public void setPlayersName(String playersName){

		this.playersName=playersName;
	}
	/**Gets the player's name
	*@return A String representing player's name
	*/
	public String getPlayersName(){

		return playersName;
	}
	/**Sets the player's phone number
	*@param playersPhNo A String containing the player's phone number
	*/
	public void setPlayersPhNo(String playersPhNo){

		this.playersPhNo=playersPhNo;
	}
	/**Gets the player's phonenumber
	*@return A String representing player's phonenumber
	*/
	public String getPlayersPhNo(){

		return playersPhNo;
	}
	/**Sets the player's emailid
	*@param playersEmailId A String containing the player's emailid
	*/
	public void setPlayersEmailId(String playersEmailId){

		this.playersEmailId=playersEmailId;
	}
	/**Gets the player's emailid
	*@return A String representing player's emailid
	*/
	public String getPlayersEmailId(){

		return playersEmailId;
	}
	/**Sets the player's password
	*@param playersPassword A String containing the player's password
	*/
	public void setPlayersPassword(String playersPassword){

		this.playersPassword=playersPassword;
	}
	/**Gets the player's password
	*@return A String representing player's password
	*/
	public String getPlayersPassword(){

		return playersPassword;
	}
	/**Sets the player's score
	*@param playersScore A String containing the player's score
	*/
	public void setPlayersScore(int playersScore){

		this.playersScore=playersScore;
	}
	/**Gets the player's score
	*@return A String representing player's score
	*/
	public int getPlayersScore(){

		return playersScore;
	}

}