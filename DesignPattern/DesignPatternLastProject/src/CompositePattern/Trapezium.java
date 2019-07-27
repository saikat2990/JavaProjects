package CompositePattern;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Trapezium implements HutBuilder{
	
	ArrayList array = new ArrayList();
	
	int x;
	int y;
	int height;
	int width;
	Graphics g;
	
	public Trapezium(Graphics g,int x, int y, int height, int width) {
		
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.g=g;
		
		array.add(new Line(g,x,y,x+width/10,y-height));
		array.add(new Line(g,x+width/10,y-height,x+(width/10)*9,y-height));
		array.add(new Line(g,x+(width/10)*9,y-height,x+(width/10)*10,y));

	}


	public void draw() {
		
		System.out.println("I am in rectangle draw ");
		Iterator it =  array.iterator();
		
		while(it.hasNext()) {
			HutBuilder sh = (HutBuilder) it.next();
			sh.draw();
		}
	}
	


}
