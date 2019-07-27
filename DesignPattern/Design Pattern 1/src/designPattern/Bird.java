package designPattern;

public class Bird extends Animal{
	
	Bird(){
		
		System.out.println("this is bird");
		flyingAbility = new CannotFly();
		
	}
}
