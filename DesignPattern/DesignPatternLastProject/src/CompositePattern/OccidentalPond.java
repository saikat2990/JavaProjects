package CompositePattern;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class OccidentalPond implements Pond{
	
	ArrayList array = new ArrayList();
	

	Graphics g;
	public OccidentalPond(Graphics g, int x, int y) {
		// TODO Auto-generated constructor stub
		
		array.add(new Line(g,x,y,x+100,y+100));
		array.add(new Line(g,x+100,y+100,x+200,y+100));
		array.add(new Line(g,x+200,y+100,x+300,y));
		
		array.add(new Line(g,x+10,y+10,x+20,y+10));
		array.add(new Line(g,x+30,y+10,x+40,y+10));
		array.add(new Line(g,x+50,y+10,x+60,y+10));
		array.add(new Line(g,x+70,y+10,x+80,y+10));
		array.add(new Line(g,x+90,y+10,x+100,y+10));
		array.add(new Line(g,x+110,y+10,x+120,y+10));
		array.add(new Line(g,x+130,y+10,x+140,y+10));
		array.add(new Line(g,x+150,y+10,x+160,y+10));
		array.add(new Line(g,x+170,y+10,x+180,y+10));
		array.add(new Line(g,x+190,y+10,x+200,y+10));
		array.add(new Line(g,x+210,y+10,x+220,y+10));
		array.add(new Line(g,x+230,y+10,x+240,y+10));
		array.add(new Line(g,x+250,y+10,x+260,y+10));
		array.add(new Line(g,x+270,y+10,x+280,y+10));
		
		

		array.add(new Line(g,x+30,y+30,x+40,y+30));
		array.add(new Line(g,x+50,y+30,x+60,y+30));
		array.add(new Line(g,x+70,y+30,x+80,y+30));
		array.add(new Line(g,x+90,y+30,x+100,y+30));
		array.add(new Line(g,x+110,y+30,x+120,y+30));
		array.add(new Line(g,x+130,y+30,x+140,y+30));
		array.add(new Line(g,x+150,y+30,x+160,y+30));
		array.add(new Line(g,x+170,y+30,x+180,y+30));
		array.add(new Line(g,x+190,y+30,x+200,y+30));
		array.add(new Line(g,x+210,y+30,x+220,y+30));
		array.add(new Line(g,x+230,y+30,x+240,y+30));
		array.add(new Line(g,x+250,y+30,x+260,y+30));

		
		

		array.add(new Line(g,x+50,y+50,x+60,y+50));
		array.add(new Line(g,x+70,y+50,x+80,y+50));
		array.add(new Line(g,x+90,y+50,x+100,y+50));
		array.add(new Line(g,x+110,y+50,x+120,y+50));
		array.add(new Line(g,x+130,y+50,x+140,y+50));
		array.add(new Line(g,x+150,y+50,x+160,y+50));
		array.add(new Line(g,x+170,y+50,x+180,y+50));
		array.add(new Line(g,x+190,y+50,x+200,y+50));
		array.add(new Line(g,x+210,y+50,x+220,y+50));
		array.add(new Line(g,x+230,y+50,x+240,y+50));


		array.add(new Line(g,x+70,y+70,x+80,y+70));
		array.add(new Line(g,x+90,y+70,x+100,y+70));
		array.add(new Line(g,x+110,y+70,x+120,y+70));
		array.add(new Line(g,x+130,y+70,x+140,y+70));
		array.add(new Line(g,x+150,y+70,x+160,y+70));
		array.add(new Line(g,x+170,y+70,x+180,y+70));
		array.add(new Line(g,x+190,y+70,x+200,y+70));
		array.add(new Line(g,x+210,y+70,x+220,y+70));

		

	}
	public void draw() {
		

		Iterator it =  array.iterator();
		
		while(it.hasNext()) {
			HutBuilder sh = (HutBuilder) it.next();
			sh.draw();
		}
	}
	@Override
	public int getWater() {
		// TODO Auto-generated method stub
		return array.size();
	}
	


}
