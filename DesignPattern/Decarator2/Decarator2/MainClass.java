package Decarator2;

import java.util.ArrayList;

public class MainClass {
	
	public static void main(String[] args) {
		
		PersonInfo[] list = PersonInfo.values();
		System.out.println(list[0]);
		
		ArrayList<Person> personList=new ArrayList<Person>();
		Person person=new Person("azaz",45.0,12.0,23);
		personList.add(person);
		person=new Person("babul",25.0,22.0,13);
		personList.add(person);
		person=new Person("babul",58.0,72.0,13);
		personList.add(person);
		person=new Person("babul",15.0,22.0,3);
		personList.add(person);
		person=new Person("babul",5.0,12.0,1);
		personList.add(person);
		
		
		Decorator decorator=new Decorator(new Decorator(new Decorator(null,2),1),0);
		System.out.println("Before Sort");
		for(Person person1:personList){
			
			System.out.println("Name:"+person1.name+" Age:"+person1.age+" weight:"+person1.weight+" height:"+person1.height);
		}
		decorator.sort(personList);
		System.out.println("After Sort");
		for(Person person1:personList){
			
			System.out.println("Name:"+person1.name+" Age:"+person1.age+" weight:"+person1.weight+" height:"+person1.height);
		}
		
	}

}
