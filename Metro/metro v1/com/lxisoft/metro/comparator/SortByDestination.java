package com.lxisoft.metro.comparator;
import java.util.*;
import com.lxisoft.metro.model.Train;

public class SortByDestination implements Comparator<Train>{
	
/*	public int compare(Train a, Train b){ 
        return a.getDestination().compareTo(b.getDestination()); 
    } 
	*/
	public int compare(Train train1,Train train2 ){
		if(train1.getStartPoint().equals(train2.getStartPoint())&&train1.getDestination().equals(train2.getDestination())){
			return 0;
		}
		else{return -1;}
	}
	
}
