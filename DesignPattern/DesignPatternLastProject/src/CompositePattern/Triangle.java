package CompositePattern;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Triangle implements HutBuilder{

	ArrayList array = new ArrayList();
	
	int x;
	int y;
	int height;
	int width;
	Graphics g;
	
	public Triangle(Graphics g, int x, int y, int height,int width) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.g=g;
		
		array.add(new Line(g,x,y,x+width/2,y-height));
		array.add(new Line(g,x+width/2,y-height,x+width,y));
	}
	
	public void draw() {
		
		System.out.println("I am in triangle draw ");
		Iterator it =  array.iterator();
		
		while(it.hasNext()) {
			HutBuilder sh = (HutBuilder) it.next();
			sh.draw();
		}
	}
}
