package templeteInDesignPattern;
import java.util.Calendar;
import java.util.Scanner;

public class Grameen extends MobileOperator{
	
	double discountRate;
	double normalRate;
	double startTime;
	double endTime;
	double duration;
	
	public boolean checkPeakTime() {
		
    	Scanner input = new Scanner(System.in);
    	
    	System.out.print("start to press 1: ");
    	int number1,number2;
    	number1 = input.nextInt();

		long start = System.nanoTime();
		System.out.println(start);
		// ...
		
		System.out.print("end to press 2: ");
		number2 = input.nextInt();
		long finish = System.nanoTime();
		System.out.println(finish);
		long timeElapsed = finish - start;
		duration = timeElapsed;
		
		System.out.println("time duration   "+timeElapsed+"  nano sec");
		
		boolean peakOrNot = findtime();
		
		return peakOrNot;
		
	}
	
	public double peakTimeBill() {
		
		discountRate=0.9;
		
		double time = duration/(1000000000.0)/(59);
		double cost = time*(discountRate);
		return cost;
	}
	
	public double normalTimeBill() {
		
		normalRate=1.9;
		
		double time = duration/(1000000000.0)/(59);
		double cost = time*(normalRate);
		return cost;
	}
	
	public boolean findtime() {
		
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        
        if(hour>11 && hour<18) {
        	return true;
        }
        else return false;
	}
}
