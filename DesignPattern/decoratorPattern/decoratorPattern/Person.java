package decoratorPattern;

public class Person implements InterfacePerson{
	
	public double attributes[] = new double[4];
	
	// GENDER : 1 -> Male | 2 -> Female
	public Person(int gender, double height, double weight, double age) {
		attributes[0] = gender;
		attributes[1] = height;
		attributes[2] = weight;
		attributes[3] = age;
	}


	public void getGenderGroup() {
		System.out.println("Gender group: " + attributes[0]);
	}
	

	public void getHeight() {
		System.out.println("Height: " + attributes[1]);
	}


	public void getWeight() {
		System.out.println("Weight: " + attributes[2]);
	}


	public void getAge() {
		System.out.println("Age: " + attributes[3]);
	}


}
