package decoratorPattern;

import java.util.Comparator;

public class personComparator implements Comparator<Person>{
	
	private int index;
	private int previousSortIndex;
	
	public personComparator(int index, int prevIndex) {
		this.index = index;
		previousSortIndex = prevIndex;
		System.out.println("===PREVIOUS SORT INDEX: " + previousSortIndex + " CURRENT SORT INDEX: " + index + "===");
		//System.out.println();
	}

	@Override
	public int compare(Person p1, Person p2) {
		
		//int compValue = 0;
		//System.out.println(p1.attributes[index] + " " + p2.attributes[index]);
		
		if(previousSortIndex == -1) {			
			if (p1.attributes[index] < p2.attributes[index]) return -1; 
	        if (p1.attributes[index] > p2.attributes[index]) return 1; 
	        else return 0;
	        //return compValue;
		}
		else {			
			if(p1.attributes[previousSortIndex] == p2.attributes[previousSortIndex]) {
				
				if (p1.attributes[index] < p2.attributes[index]) return -1; 
		        if (p1.attributes[index] > p2.attributes[index]) return 1; 
		        else return 0;
		        //return compValue;
			}
			return 0;
		}
		
		//return (Integer) null;
	}

}
