package com.lxisoft.snakeNLadder.model;
/** Represents a Player.
 * @author Deepthi E
 */
public class Player{
	
	private	String name;
	//private	int id;
	private	int score=0;
	private	String password;
	private	String regDate;
	private	Coin coin;
	
	
	public Player(){
		
	}
	public Player(String name){
		this.name= name;
	}
	
	
	
/** Sets the player's name.
  * @param name The player's name.
  */
	public void setPlayerName(String name){

		this.name=name;
	}

/** Gets the player's name.
  * @return A String representing The player's name.
  */
	public String getName() {
		return name;
		}
		
/** Sets the player's password.
  * @param password The player's password.
  */
public void setPassword(String password){

		this.password=password;
	}	
	
/** Gets the player's password.
  * @return A String representing The player's password.
  */
	public String getPassword() {
		return password;
		}
	
/** Sets the player's coin.
  * @param coin The player's coin.
  */
	public void setCoins(Coin coin) {
		this.coin= coin;
		}
		
/** Gets the player's coin.
  * @return A Coin representing the player's coin.
  */
	public Coin getCoin() {
		return coin;
		}
		
/** Gets the player's score.
  * @return An Integer representing the player's score
  */
	public int getScore() {
		return score;
		}

/** Sets the player's score.
  * @param score The player's score.
  */
	public void setScore(int score) {
		this.score= score;
		}
	
	
	public String toString(){ 
		return "Player Name::"+name+" "+coin+" ";  
		}  
}