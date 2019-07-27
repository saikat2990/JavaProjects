package CompositePattern;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Flag implements HutBuilder{
	
	int x;
	int y;
	int height;
	int width;
	int radius;
	
	ArrayList array = new ArrayList();
	
	public Flag(Graphics g,int x,int y,int height,int width,int radius) {
		
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.radius = radius;
				
		array.add(new Rectangle(g,x,y,height,width));
		array.add(new Circle(g,x+(width/3),y+(height/3),radius));
	}

	public void draw() {
		
		Iterator it = array.iterator();
		while(it.hasNext()) {
			HutBuilder sh = (HutBuilder) it.next();
			sh.draw();
		}
		
	}
}
