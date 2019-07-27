package LastAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public final class Tsc {
	
	private static Tsc instance;
	
	HashMap<String,Festivals> festival = new  HashMap<String,Festivals>();
	HashMap<String,FestBridge> festBridge = new  HashMap<String,FestBridge>();
	static ArrayList<String> Time = new ArrayList<String>(); 
	
	private Tsc(){
		System.out.println("heeyyyyyy i am here");
		Time.add("2016/11/16 12:08:43");
	}
	
	public static Tsc getInstance(){
		System.out.println("heeyyyyyy i am here getIntance() method");
		//System.out.println(Time.get(0));
		if(instance==null) {
			instance = new Tsc();
		}
		return instance;
		
	}
	
	public boolean isFree(String time) {
		
		if(Time.contains(time)) {
			return false;
		}
		else return true;
	}
	
	public void setFestival(Festivals f,String time) {
		festival.put(time, f);	
		Time.add(time);
	}
	
	public void setFestBridge(FestBridge f,String time) {
		festBridge.put(time, f);
		Time.add(time);
	}
	
	public void removeFestival(Festivals f,String time) {
		festival.remove(time);
		Time.add(time);
	}
	
	public void removeFestBridge(FestBridge f,String time) {
		festBridge.remove(time);	
		Time.add(time);
	}
}
