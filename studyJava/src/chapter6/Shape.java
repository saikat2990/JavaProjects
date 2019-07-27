package chapter6;

public class Shape {
	double pi;
	
	Shape(double r){
		
		pi = 3.1416;
		
		System.out.println("area is "+r*r*pi); 
	}
	
	Shape(int r){
		
		pi = 3.1416;
		System.out.println("area is "+r*r*pi); 
	
	}
	
	public double area(double a) {
		
		return a*a;
	}
}
