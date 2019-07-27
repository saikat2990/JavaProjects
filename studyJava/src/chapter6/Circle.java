package chapter6;

public class Circle extends Shape{
	
	Circle(double r) {
		
		super(r);
		
	}
	Circle(int a){
		
		super(a);
		int ans,b;
		b=90;
		ans = b-a;
		System.out.println("i am in CIrcle class "+ans);
		
	}
	
	public void p() {
		
		System.out.println("hello "+super.area(2.1));
	}
	
}
