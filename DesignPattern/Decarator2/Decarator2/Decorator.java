package Decarator2;

import java.util.ArrayList;
import java.util.Collections;

public class Decorator {
	
	int factor;
	Decorator decorator;
	public Decorator(Decorator decorator,int factor) {
		
		this.decorator=decorator;
		this.factor=factor;
	}
	
	public void sort(ArrayList<Person> personList) {
		
		Person.sortFactor=factor;
		Collections.sort(personList);
		if(decorator!=null) decorator.sort(personList);
		
	}

}
