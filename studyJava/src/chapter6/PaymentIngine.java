package chapter6;

public class PaymentIngine {
	
	public PaymentIngine(Payment payment) {
		
		System.out.println("cash received "+payment.getMoney());
	}
	
	public PaymentIngine(Bkash bkash) {
		
		System.out.println("cash received in bkash "+bkash.getMoney());
	}
}
