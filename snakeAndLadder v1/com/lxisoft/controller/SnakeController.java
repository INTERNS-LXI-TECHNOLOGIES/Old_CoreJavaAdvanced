package com.lxisoft.controller;

import com.lxisoft.model.*;

public class SnakeController{
	
	Snake[] snake=new Snake[10]; 
	
	int head1,head2,head3,head4,tail1,tail2,tail3,tail4;
		public void constructSnakePosition(){

			snake[1] = new Snake(40,2);
			snake[2] = new Snake(56,24);
			snake[3] = new Snake(61,29);
			snake[4] = new Snake(92,34);
			
			head1 = snake[1].getHeadPosition();
			tail1 = snake[1].getTailPosition();
			
			head2 = snake[2].getHeadPosition();
			tail2 = snake[2].getTailPosition();
			
			head3 = snake[3].getHeadPosition();
			tail3 = snake[3].getTailPosition();
			
			head4 = snake[4].getHeadPosition();
			tail4 = snake[4].getTailPosition();
		
	}
}