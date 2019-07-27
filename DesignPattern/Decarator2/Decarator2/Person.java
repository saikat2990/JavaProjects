package Decarator2;
public class Person implements Comparable<Person>{
	
	
	public String name;
	public double weight;
	public double height;
	public double age;
	double[] persons=new double[3];
	public static int sortFactor;
	
	public Person(String name, double weight, double height, double age) {
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.age = age;
		persons[0]=weight;
		persons[1]=height;
		persons[2]=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public int getSortFactor() {
		return sortFactor;
	}
	public void setSortFactor(int sortFactor) {
		this.sortFactor = sortFactor;
	}
	public int compareTo(Person o) {
		
		
		if(this.persons[sortFactor]<o.persons[sortFactor]) {
			
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
	

}
