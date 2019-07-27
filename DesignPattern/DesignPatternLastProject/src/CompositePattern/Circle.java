package CompositePattern;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements HutBuilder{
	
	int x;
	int y;
	int radius;
	Graphics g;
	public Circle(Graphics g,int x,int y,int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
		this.g=g;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" I am in circle draw class");
		g.setColor(Color.RED);
		g.fillOval(x, y, radius, radius);
		
		
	}

}
