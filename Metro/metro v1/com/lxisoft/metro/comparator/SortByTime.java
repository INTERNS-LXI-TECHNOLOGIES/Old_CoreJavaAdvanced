package com.lxisoft.metro.comparator;
import java.util.*;
import com.lxisoft.metro.model.Train;

public class SortByTime implements Comparator<Train>{
	
	public int compare(Train a, Train b){ 
        return a.getArraivalTime().compareTo(b.getArraivalTime()); 
    } 
	
}   