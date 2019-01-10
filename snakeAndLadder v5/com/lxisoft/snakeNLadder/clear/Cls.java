package com.lxisoft.snakeNLadder.clear;
import java.io.IOException;

/** Represents a Cls.
 * @author Deepthi E
 */

public class Cls
{
	/**
	* Method to clear Screen.
	*/
public void cls() throws IOException,InterruptedException

{
new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

}
} 