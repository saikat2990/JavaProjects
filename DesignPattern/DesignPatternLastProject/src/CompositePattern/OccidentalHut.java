package CompositePattern;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class OccidentalHut implements HutBuilder{
	
	int x;
	int y;
	int height;
	int width;
	int radius;
	
	ArrayList array = new ArrayList();
	
	public OccidentalHut(Graphics g,int x,int y,int height,int width) {
		
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.radius = radius;
				
		array.add(new Rectangle(g,x,y,height,width));
		array.add(new Trapezium(g,x,y,height/4,width));
		array.add(new Rectangle(g,x+width/3+15,y+height/2,height/2,width/5));
		
		array.add(new Rectangle(g,x+width/10,y+height/2,height/5,width/10));
		
		array.add(new Rectangle(g,x+width/10,y+height/2-10,height/5,width/10));
		
		array.add(new Rectangle(g,x+width-width/5,y+height/2,height/5,width/10));
		
		array.add(new Rectangle(g,x+width-width/5,y+height/2-10,height/5,width/10));
	}

	public void draw() {
		
		Iterator it = array.iterator();
		while(it.hasNext()) {
			
			HutBuilder sh = (HutBuilder) it.next();
			System.out.println("saikat");
			sh.draw();
		}
		
	}
}
