package Thrd;

public class Thd {
	
	static int a = 11;
	public static void main(String [] args) {
		
		Process1 p1 = new Process1();
		Process2 p2 = new Process2();
		Process3 p3 = new Process3();
		
		Thread t1 = new Thread(p1);
		t1.start();
		
		Thread t2 = new Thread(p2);
		t2.start();
		
		Thread t3 = new Thread(p3);
		t3.start();	
	  	
	}
}



