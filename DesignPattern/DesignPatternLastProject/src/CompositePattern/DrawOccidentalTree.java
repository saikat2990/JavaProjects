package CompositePattern;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawOccidentalTree {

	public DrawOccidentalTree(Graphics g, Color randColor, Color randColor2, int width, int height) {
		// TODO Auto-generated constructor stub
        Graphics2D g2d = (Graphics2D) g.create();


        g2d.setColor(new Color(139, 69, 19));
        g2d.fillRect((width / 2) - 20, height / 2, 40, height / 2);

        g2d.setColor(Color.GREEN);
        int radius = 60;
        g2d.fillOval((width / 2) - radius, (height / 2) - (radius * 2), radius * 2, radius * 2);
        g2d.fillOval((width / 2) - radius, (height / 2) - radius, radius * 2, radius * 2);
        g2d.fillOval((width / 2) - (radius * 2), (height / 2) - radius, radius * 2, radius * 2);
        g2d.fillOval((width / 2), (height / 2) - radius, radius * 2, radius * 2);
        g2d.dispose();
		
	}

}
