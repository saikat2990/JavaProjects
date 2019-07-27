package templeteInDesignPattern;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

public class Main1{
    public static void main1(String[] args) {
    	
    	System.out.println("call in teletalk press tel: ");
    	System.out.println("call in grameenphone press gp: ");
    	System.out.println("call in bangalink press bg: ");
    	String ch;
    	
    	Scanner input = new Scanner(System.in);
    	ch = input.nextLine();
    	
    	if(ch.equals("tel")) {
    		
    		MobileOperator mobileOperator = new Teletalk();
    		System.out.println("bill is "+mobileOperator.getBill());
    	}else if(ch.equals("gp")) {
    		
    		MobileOperator mobileOperator = new Grameen();
    		System.out.println("bill is "+mobileOperator.getBill());
    	}else  {
    		
    		MobileOperator mobileOperator = new Bangalink();
    		System.out.println("bill is "+mobileOperator.getBill());
    	}    
    
	}

}
