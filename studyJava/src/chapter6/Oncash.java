package chapter6;

public class Oncash implements Payment{

	@Override
	public long getMoney() {
		System.out.println("I am in Oncash");
		return 100;
	}
	
	
}
