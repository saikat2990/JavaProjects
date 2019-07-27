package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	
	List<Menu>menuList = new ArrayList();
	double cost=0;
	public void addMenu(Menu menu) {
		menuList.add(menu);
	}
	
	public double totalCost() {
		for(Menu m:menuList) {
			cost+=m.getCost();
		}
		return cost;
	}


}
