package chapter6;

public class ShapeMaker {
	
	ShapeMaker(){
		
		System.out.println("i am in ShapeMaker class");
		
	}
	
	public Shape newShape() {
		Shape ch = new Shape(2);
		ch.pi = 9.0001;
		return ch;
	}
}
