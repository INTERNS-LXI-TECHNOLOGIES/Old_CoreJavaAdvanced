package com.lxisoft.metro.comparator;

import java.util.*;
import com.lxisoft.metro.model.Train;

public class SortByDestination implements Comparator<Train>{

	public int compare(Train train1,Train train2){

		return train1.getDestinationPoint().compareTo(train2.getDestinationPoint());
	}
}