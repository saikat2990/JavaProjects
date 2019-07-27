package CompositePattern;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class OrientalFouna implements Founa{
	int x;
	int y;
	int height;
	int width;
	int radius;
	
	ArrayList array = new ArrayList();
	
	public OrientalFouna(Graphics g) {
		
		g.fillOval(90, 90, 250, 300);
		
		g.setColor(Color.darkGray);
		g.fillOval(165, 250, 100, 70);
		
		g.setColor(Color.RED);
		g.fillOval(150, 150, 30, 30);
		
		g.setColor(Color.RED);
		g.fillOval(250, 150, 30, 30);
	}

	public void draw() {

		
	}

	@Override
	public void selectFouna() {
		// TODO Auto-generated method stub
		
	}

}
