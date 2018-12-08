 package com.lxisoft.snakenladder.controller;

import com.lxisoft.snakenladder.model.Die;
import java.util.*;

public class DieController{

	Die die;
	Random ran = new Random();
	public int roll;
	public DieController(){

		roll=ran.nextInt(7-1)+1;
		die=new Die(roll);
		System.out.println("\nYou get :"+die.getRollDie());
	}
	
}