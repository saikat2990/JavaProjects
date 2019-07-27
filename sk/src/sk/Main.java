package sk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Em obj = new Em();
		
		System.out.println(obj.a);
		System.out.println(obj.m1());
		System.out.println(obj.m2());*/
		
	      String line = "tusar0805iitdu";
	    	      String pattern ="[a-z]+";
	    	      int count = 0;

	    	Pattern r = Pattern.compile(pattern);
	    	Matcher m = r.matcher(line);
	    		
	    	while(m.find()) {
	    	          count++;
	    	          System.out.println("Match number "+count);
	    	          System.out.println("start(): "+m.start());
	    	          System.out.println("end(): "+m.end());
	    	          System.out.println(line);
	    	       }

		
	}

}
