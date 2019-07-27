package LastAssignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Mediator {
	
	
	ArrayList<Festivals> festival = new ArrayList<Festivals>();
	
	ArrayList<FestBridge> festBridge = new ArrayList<FestBridge>();
	Observer observer;
	
	public Mediator() {
		
		//InfoTransferAll();
	}
	
	private void InfoTransferAll() {
		// TODO Auto-generated method stub
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43
		
		for(Festivals f : festival) {
			if(f.Time.equals(dateFormat.format(cal))) {
				infoPass(f.getFestivalName());
			}
		}
		
		for(FestBridge f : festBridge) {
			
			if(f.Time.equals(dateFormat.format(cal))) {
				infoPass(f.getFestivalName());
			}
		}
	}

	private void infoPass(String festName) {
		// TODO Auto-generated method stub
		for(Festivals f : festival) {
			
			f.alamForFest(festName);
		}
		
		for(FestBridge f : festBridge) {
			
			f.alamForFest(festName);
			
		}
		
	}

	public void setFestObserver(Festivals fest, String observerName) {
		
		if(observerName.equals("Radio")) {
			observer = new Radio(fest);
		}else {
			observer = new Tv(fest);
		}
		fest.setObserver(observer);
		festival.add(fest);
	}
	
	public void setFestBridgeObserver(FestBridge fest, String observerName) {
		
		System.out.println("hey i am in setFestBridgeObserver");
		if(observerName.equals("Radio")) {
			System.out.println("hey i am in setFestBridgeObserver");
			observer = new Radio(fest);
		}else {
			observer = new Tv(fest);
		}
		fest.setObserver(observer);
		festBridge.add(fest);
	}
	
}
