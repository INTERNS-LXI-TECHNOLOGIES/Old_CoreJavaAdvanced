package com.lxisoft.snakenladder.controller;

import com.lxisoft.snakenladder.model.*;

public class LadderController{

	Ladder ladder1;
	Ladder ladder2;
	Ladder ladder3;
	Ladder ladder4;
	int lh1,lh2,lh3,lh4,lt1,lt2,lt3,lt4;


	public void createLadder(){
		ladder1=new Ladder(57,86);
		ladder2=new Ladder(40,81);
		ladder3=new Ladder(36,65);
		ladder4=new Ladder(16,43);

		lh1=ladder1.getLadderStart();
		lt1=ladder1.getLadderEnd();

		lh2=ladder2.getLadderStart();
		lt2=ladder2.getLadderEnd();

		lh3=ladder3.getLadderStart();
		lt3=ladder3.getLadderEnd();

		lh4=ladder4.getLadderStart();
		lt4=ladder4.getLadderEnd();
	}

}