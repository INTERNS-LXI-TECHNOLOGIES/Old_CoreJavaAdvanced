package com.lxisoft.metro.comparator;
import java.util.*;
import com.lxisoft.metro.model.Train;

public class SortByDestination implements Comparator<Train>{
	
	public int compare(Train train1,Train t2 ){
		if(train1.getStartPoint().equals(t2.getStartPoint())&&train1.getDestination().equals(t2.getDestination())){
			return 0;
		}
		else{return -1;}
	}
	
}
