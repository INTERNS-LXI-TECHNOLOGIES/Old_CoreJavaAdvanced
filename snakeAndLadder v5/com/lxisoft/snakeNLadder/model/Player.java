package com.lxisoft.snakeNLadder.model;
/** Represents a Player.
 * @author Deepthi E
*/
public class Player{
	
	private	String name;
	private	int id;
	private	int score;
	private	String password;
	private	String regDate;
	private	Coin coin;
	
 /**
   * Creates a  player with player's id, player's name and player's password.
   * @param id This is the first paramter to the constructor.
   * @param name  This is the second parameter to the constructor.
   * @param password  This is the third parameter to the constructor.
   */
	
	public Player(int id,String name,String password){
		this.id=id;
		this.name=name;
		this.password=password;
		}
		
/** Gets the player's name.
  * @return A String representing The player's name.
  */
	public String getName() {
		return name;
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
		return "Player Name::"+name+" "+" Coin::"+coin+" ";  
		}  
}