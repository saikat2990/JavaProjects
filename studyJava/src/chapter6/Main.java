package chapter6;

public class Main {

	public static void main(String[] args) {
		
		Circle cr = new Circle(2.1415);
		CircleFactory cr1 = new CircleFactory();
		cr1.newShape();
		
		//cr.p();
		String name = cr.getClass().getSimpleName();
		System.out.println(name);
	}

}
