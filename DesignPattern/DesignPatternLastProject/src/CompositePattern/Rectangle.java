package CompositePattern;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Rectangle implements HutBuilder{
	
	ArrayList array = new ArrayList();
	
	int x;
	int y;
	int height;
	int width;
	Graphics g;
	
	public Rectangle(Graphics g,int x, int y, int height, int width) {
		
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.g=g;
		
		array.add(new Line(g,x,y,x+width,y));
		array.add(new Line(g,x+width,y,x+width,y+height));
		array.add(new Line(g,x,y,x,y+height));
		array.add(new Line(g,x,y+height,x+width,y+height));
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
