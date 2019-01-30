package com.lxisoft.metro.comparator;

import java.util.*;
import com.lxisoft.metro.model.Train;

public class SortByDest implements Comparator<Train>{


	public int compare(Train train1,Train train2){

		if(train1.getDestinationPoint().equals(train2.getDestinationPoint())){

			return 0;
		}
		else{
			return -1;
		}
		
	}
}
