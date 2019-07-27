package chapter6;

public class CircleFactory extends ShapeMaker{
	
	public CircleFactory() {
		
		System.out.println("i am in CircleFactory class");
		
	}
	
	public Shape newShape() {
		
		
		Shape cr  = new Circle(2);
		((Circle)cr).p();
		return cr;
	
		
	} 

}
