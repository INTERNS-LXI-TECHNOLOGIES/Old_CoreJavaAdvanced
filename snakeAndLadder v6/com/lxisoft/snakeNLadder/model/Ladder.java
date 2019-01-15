package com.lxisoft.snakeNLadder.model;
/** Represents a Ladder.
 * @author Deepthi E
*/
public class Ladder {
	private	int ladderStart;
	private	int ladderEnd;

/** Creates a Ladder with specified ladderStart and ladderEnd.
  * @param ladderStart The ladder's starting position.
  * @param ladderEnd The ladder's ending position.
  */
	public Ladder(int ladderStart,int ladderEnd){
		this.ladderStart=ladderStart;
		this.ladderEnd=ladderEnd;
	}

/** Gets the Ladder's ladderStart .
  * @return An Integer representing the ladder's starting.
  */
	public int getLadderStart() {
	return ladderStart;
	}
	
/** Gets the ladder's ladderEnd.
  * @return An Integer representing the ladder's ending.
  */
	public int getLadderEnd() {
	return ladderEnd;
	}

	
	
}