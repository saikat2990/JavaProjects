package Knn;

import java.util.Comparator;

public class DistaseCompare implements Comparator<Distanse> {
	
	@Override
	public int compare(Distanse a, Distanse b) {
		return a.distance>b.distance ? -1 : a.distance==b.distance ? 0 : 1;
	}

	
}
