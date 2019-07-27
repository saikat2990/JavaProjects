package CompositePattern;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class DrawOrientalTree {

	
	public DrawOrientalTree(Graphics g,Color colorLeaf,Color colorShoot,int x,int y) {
		
	    int [] arrayX= {x,x+100,x-100};
	    int [] arrayY = {y,y+50,y+50};
	    
	    Polygon ploy = new Polygon(arrayX, arrayY, 3);
	    Graphics2D g2D = (Graphics2D) g;
	    g2D.setColor(colorLeaf);
	    g2D.fill(ploy);
	    
	    
	    g.setColor(colorShoot);
	    g.fillRect(x-25, y+50, 50, 180);
	}
}
