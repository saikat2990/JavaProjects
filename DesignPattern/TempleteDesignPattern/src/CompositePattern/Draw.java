package CompositePattern;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics.*;
import java.awt.color.*;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Draw  extends JFrame{
	
	int x1,y1,x2,y2;
	
	public Draw() {
		
		setTitle("Tutorial");
		setSize(1500,1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	public void paint(Graphics g) {
		
		//g.setColor(Color.red);
		//g.drawLine(x1, y1, x2, y2);
		Flag flag = new Flag(g,100,200,100,200,50);
		flag.draw();
		
	}
	
	public void setVariable(int x1,int y1,int x2,int y2) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
	
}
