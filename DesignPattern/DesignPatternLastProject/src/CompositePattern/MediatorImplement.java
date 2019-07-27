package CompositePattern;

import java.util.ArrayList;
import java.util.HashMap;

public class MediatorImplement implements Mediator{
	
	//HashMap<Envirment,String> list = new HashMap<Envirment,String>();
	HashMap<String,String> list = new HashMap<String,String>();
	
	MediatorImplement(){
		
		list.put("Occidental","nothing");
		list.put("Oriental","nothing");
		
	}
	
	public void conditionSet(String s,String condition) {
		list.put(s, condition);
	}
	
	public String conditionGet(String s) {
		return list.get(s);
	}
	@Override
	public String send(Envirment e) {
		// TODO Auto-generated method stub
		return list.get(e);
	}

}
