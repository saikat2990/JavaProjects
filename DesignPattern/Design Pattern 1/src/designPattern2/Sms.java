package designPattern2;

public class Sms implements Notify{
	
	Sms(){
		System.out.println("hey i am in sms");
	}
	public void notifyUser() {
		System.out.println("here you have to notify in Sms");
	}
	
}
