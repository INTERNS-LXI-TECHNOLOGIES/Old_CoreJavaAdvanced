package com.lxisoft.game.model;
/**Represents a Ladder
*@author Sumi G
*/

public class Ladder{

	private int ladderHead;
	private int ladderTail;

	/**Creates a Ladder with the head and tail
	*@param ladderHead The ladder's head
	*@param ladderTail The ladder's tail
	*/
	public Ladder(int ladderHead,int ladderTail){

		this.ladderHead=ladderHead;
		this.ladderTail=ladderTail;
	}
	/**Gets the ladder's head
	*@return A int representing ladder's head
	*/
	public int getLadderHead(){

		return ladderHead;
	}
	/**Gets the ladder's tail
	*@return A int representing ladder's tail
	*/
	public int getLadderTail(){

		return ladderTail;
	}
}