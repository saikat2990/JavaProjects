package CompositePattern;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class OccidentalFouna implements Founa{

	
	int x;
	int y;
	int height;
	int width;
	int radius;
	
	ArrayList array = new ArrayList();
	
	public OccidentalFouna(Graphics g,int x,int y) {
		
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.radius = radius;
				
//		array.add(new Rectangle(g,x,y,height,width));
//		array.add(new Triangle(g,x,y,height/4,width));
//		array.add(new Rectangle(g,x+width/3+15,y+height/2,height/2,width/5));
//		
//		array.add(new Rectangle(g,x+width/10,y+height/2,height/5,width/10));
//		
//		array.add(new Rectangle(g,x+width/10,y+height/2-10,height/5,width/10));
//		
//		array.add(new Rectangle(g,x+width-width/5,y+height/2,height/5,width/10));
//		
//		array.add(new Rectangle(g,x+width-width/5,y+height/2-10,height/5,width/10));
		
		array.add(new FaceCreate(g,76, 45, 250, 300)); // face

		array.add(new FaceCreate(g,126, 250, 152, 60)); // mouth

		array.add(new FaceCreate(g,140, 150, 30, 30)); // left eye

		array.add(new FaceCreate(g,240, 150, 30, 30)); // right eye

		array.add(new FaceCreate(g,175, 345, 50, 50)); // neck
	}

	public void draw() {
		
		Iterator it = array.iterator();
		while(it.hasNext()) {
			
			HutBuilder sh = (HutBuilder) it.next();
			System.out.println("saikat");
			sh.draw();
		}
		
	}


	@Override
	public void selectFouna() {
		// TODO Auto-generated method stub
		
	}


}
