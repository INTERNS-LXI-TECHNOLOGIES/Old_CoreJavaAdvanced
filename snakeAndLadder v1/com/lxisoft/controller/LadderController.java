package com.lxisoft.controller;

import com.lxisoft.model.*;

public class LadderController{
		Ladder[] ladder= new Ladder[10];
		
		 int start1,start2,start3,start4,end1,end2,end3,end4,cellNumber;

public void constructLadderPosition() {
			ladder[1] = new Ladder(10,22);
			ladder[2] = new Ladder(4,44);
			ladder[3] = new Ladder(26,60);
			ladder[4] = new Ladder(32,88);
			
			
			start1 = ladder[1].getStartPosition();
			end1 = ladder[1].getEndPosition();
			
			start2 = ladder[2].getStartPosition();
			end2 = ladder[2].getEndPosition();
			
			start3 = ladder[3].getStartPosition();
			end3 = ladder[3].getEndPosition();
			
			start4 = ladder[4].getStartPosition();
			end4 = ladder[4].getEndPosition();

	}

		
}