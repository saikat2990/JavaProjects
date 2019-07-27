package decoratorPattern;

import java.util.List;
import java.util.ArrayList;

public class ComparisonTest {

	public static void main(String[] args) {

		List <Person> list = new ArrayList <Person> (); 
		list.add(new Person(1, 1.65, 72, 26));
        list.add(new Person(1, 1.5, 72, 33)); 
        list.add(new Person(1, 1.57, 75, 30)); 
        list.add(new Person(2, 1.57, 67, 19));
        list.add(new Person(2, 1.71, 82.3, 42));
        list.add(new Person(1, 1.57, 72, 30)); 
        list.add(new Person(1, 1.706, 86, 33));
        list.add(new Person(2, 1.49, 77, 42));
        
        DecoratorSortPersons dec = new DecoratorSortPersons(list);
        list = dec.SortThePersonArray(1);
        //System.out.println(list);
        
        for (Person p: list) { 
            System.out.println("Gender: " + p.attributes[0]
            				+" Height: " + p.attributes[1] 
            				+ " Weight: " + p.attributes[2]
            				+ " Age: " + p.attributes[3]);
        }
        System.out.println();
        
        list = dec.SortThePersonArray(3);
        for (Person p: list) { 
            System.out.println("Gender: " + p.attributes[0]
            				+" Height: " + p.attributes[1] 
            				+ " Weight: " + p.attributes[2]
            				+ " Age: " + p.attributes[3]);
        }
        System.out.println();
        
        list = dec.SortThePersonArray(2);
        for (Person p: list) { 
            System.out.println("Gender: " + p.attributes[0]
            				+" Height: " + p.attributes[1] 
            				+ " Weight: " + p.attributes[2]
            				+ " Age: " + p.attributes[3]);
        }
        System.out.println();
      
	}    

}
