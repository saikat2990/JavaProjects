package chapter6;

/*public class PaymentInImple {
	public static void main(String[] args) {
		
		//Bkash bkash = new Bkash();
		Payment bkash = new Bkash();
		Oncash oncash = new Oncash();
		
		PaymentIngine piBkash = new PaymentIngine(bkash);
		PaymentIngine piOncash = new PaymentIngine(oncash);
		
	}
}
*/
import java.util.Random;

public class MySameSequenceWithRange {
 
    public void generateSequence(){
        Random rnd = new Random(123);
        for(int i=0;i<5;i++){
            System.out.println(rnd.nextInt(20));
        }
    }
     
    public static void main(String a[]){
        MySameSequenceWithRange mss = new MySameSequenceWithRange();
        mss.generateSequence();
        System.out.println("====================");
        mss.generateSequence();
        System.out.println("====================");
        mss.generateSequence();
    }
}