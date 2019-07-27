package CompositePattern;

import java.util.ArrayList;
import java.util.HashMap;

public class Marraige implements CommandforMarraige{
	
	ArrayList<String> list = new ArrayList<String>();
	HashMap<String,String>Couple = new HashMap<String , String>();
	HashMap<String,String>Marraige = new HashMap<String , String>();
	
	public Marraige() {
		
		list.add("x");
		list.add("y");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		
		System.out.println(" person List ");
		
		for(String s:list) {
			System.out.print(s+" ");
		}
		
		Couple.put("x", "y");
		Couple.put("y", "x");
		Couple.put("a", "b");
		Couple.put("b", "a");
		Couple.put("c", "d");
		Couple.put("d", "c");
		Couple.put("e", "f");
		Couple.put("e", "f");
		
	}
	
	
	@Override
	public void doMarraige(String person1,String person2) {
		// TODO Auto-generated method stub
		Marraige.put(person1, person2);
		Marraige.put(person2, person1);
	}

	public boolean checkCouple(String person1,String person2) {
		// TODO Auto-generated method stub
		boolean b;
		System.out.println("I am in checking func()");
		if(person1.equals(Couple.get(person2))) {
			b=true;
		}else b=false;
		
		System.out.println(b);
		return b;
	}

	@Override
	public void pressUndo(String person1,String person2) {
		// TODO Auto-generated method stub
		Marraige.remove(person2);
		Marraige.remove(person1);
	}

}
