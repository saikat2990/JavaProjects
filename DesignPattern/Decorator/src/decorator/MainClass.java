package decorator;

import java.util.ArrayList;

public class MainClass {
	
	public static void main(String[] args) {

		ArrayList<Person> personList=new ArrayList<Person>();
		Person person=new Person("saikat",45.0,12.0,23);
		personList.add(person);
		person=new Person("sam",25.0,22.0,13);
		personList.add(person);
		person=new Person("Arya",58.0,72.0,13);
		personList.add(person);
		person=new Person("Jhon",15.0,22.0,3);
		personList.add(person);
		person=new Person("Cerci",5.0,12.0,1);
		personList.add(person);
		
		
		Decorator decorator=new Decorator(new Decorator(new Decorator(null,0),2),1);
		System.out.println("Before War");
		for(Person person1:personList){
			
			System.out.println("Name-"+person1.name+"Age-"+person1.age+"weight-"+person1.weight+"height-"+person1.height);
		}
		decorator.sort(personList);
		System.out.println("After War");
		for(Person person1:personList){
			
			System.out.println("Name-"+person1.name+"Age-"+person1.age+" weight-"+person1.weight+" height-"+person1.height);
		}
		
	}

}
