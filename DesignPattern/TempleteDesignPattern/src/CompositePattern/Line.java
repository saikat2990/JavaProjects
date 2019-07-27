package CompositePattern;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Line implements Shape{
	
	int x;
	int y;
	int x2;
	int y2;
	Graphics g;
	
	public Line(Graphics g,int x, int y, int x2, int y2) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.x2 = x2;
		this.y2 = y2;
		this.y = y;
		this.g=g;
	}
	

	@Override
	public void draw() {
		
		//Draw d = new Draw();
		System.out.println("I am in Line Draw point "+x+","+y+"  to  "+x2+","+y2);
		//d.setVariable(x, y, x2, y2);
		//draw.paint(g, x, y, x2, y2);
		g.drawLine(x, y, x2, y2);
		
		
	}

}
