package corPolice;

import java.util.*;
import java.util.ArrayList;

class Word{
	
	String name;
	int [] points = new int [500];
	String [] cardNumber = new String[500];
		
}

public class Points  {
	
	
	static ArrayList<Word> arrli = new ArrayList<Word>(4);
	 static int y;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		System.out.println("Enter the round Number");
		Scanner sc = new Scanner(System.in);
		y = sc.nextInt();
		//System.out.println("");
		
		Word wd1 = new Word();
		Word wd2 = new Word();
		Word wd3 = new Word();
		Word wd4 = new Word();
		
		wd1.name = "Saikat";
		arrli.add(wd1);

		wd2.name = "Suborno";
		arrli.add(wd2);
		
		wd3.name = "Rabbi";
		arrli.add(wd3);
		
		wd4.name = "Rakib";
		arrli.add(wd4);
		
		for(int i=0;i<y;i++) {
			
			String nm,card;
			int point,rn;
			
			for(int j=0;j<4;j++) {
				
				nm = sc.next();
				card = sc.next();
				point = sc.nextInt();
				rn = i+1;
				
				store(nm,point,rn,card);				
			}

			
		}
		
		for(int i=0;i<4;i++) {
			
			Word temp = new Word();
			temp = arrli.get(i);
			System.out.print(temp.name+" ");
			for(int j=0;j<y;j++) {
				System.out.print(temp.points[j]+" "+temp.cardNumber[j]+" ");
			}
			System.out.print("\n");
		}
		
	}
	
	public static void store(String name,int point,int rounderNumber, String card ) {
		
		System.out.println(name+" "+point+" "+card);
		
		for(int i=0;i<4;i++) {
			
			Word temp = new Word();
			temp = arrli.get(i);
			//1System.out.println(temp.name+" "+point+" "+card);
			
			if(temp.name.equals(name)) {
				
				
				arrli.remove(temp);
				temp.points[rounderNumber-1] = point;
				temp.cardNumber[rounderNumber-1] = card;
				arrli.add(temp);
				
			}
			
		}
		
		
	}

}


/*

 
 */


