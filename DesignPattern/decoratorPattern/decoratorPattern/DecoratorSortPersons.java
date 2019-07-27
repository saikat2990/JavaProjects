package decoratorPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import compositePattern.IShape;

public class DecoratorSortPersons implements InterfacePerson{
	
	private List <Person> personList = new ArrayList <Person> ();
	private List <Person> sortedPersonList = new ArrayList <Person> ();
	
	private int previousSortIndex = -1;
	InterfacePerson person;
	
	public DecoratorSortPersons(List<Person> sentPersonList) {
		personList = sentPersonList;
	}


	public void getGenderGroup() {
		person.getGenderGroup();
	}


	public void getHeight() {
		person.getHeight();
	}


	public void getWeight() {
		person.getWeight();
	}


	public void getAge() {
		person.getAge();
	}
	
	public void provideInfo() {
		
		for(InterfacePerson human: personList) {
			person = human;
			person.getGenderGroup();
			person.getHeight();
			person.getWeight();
			person.getAge();
		}
	}
	
	public List<Person> SortThePersonArray(int attrIndex){
		
		Collections.sort(personList, new personComparator(attrIndex, previousSortIndex));
		previousSortIndex = attrIndex;
		
		/*
		for (Person p: personList) { 
            System.out.println("Gender: " + p.attributes[0]
            				+" Height: " + p.attributes[1] 
            				+ " Weight: " + p.attributes[2]
            				+ " Age: " + p.attributes[3]);
        }
		System.out.println();
		*/
		
		return  personList;
	}
}
