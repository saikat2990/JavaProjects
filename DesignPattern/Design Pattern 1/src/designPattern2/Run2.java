package designPattern2;

public class Run2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buy p = new Buy();
		p.payNotify = new Sms();
		
		Buy q = new Buy();
		q.payNotify=  new Email();
		
		p.payNotify.notifyUser();
		q.payNotify.notifyUser();
		
		
	}

}
