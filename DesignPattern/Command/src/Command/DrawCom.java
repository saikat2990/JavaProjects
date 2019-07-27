package Command;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics.*;
import java.awt.color.*;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class DrawCom  extends JFrame{
	
	Graphics g;
	public DrawCom() {
		
		setTitle("Draw");
		setSize(1200,1600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public Graphics getPencil() {
		g = getGraphics();
		return g;
	}
	public void paint(Graphics g) {
		super.paint(g);
		Circle circle =new Circle();
		
		CircleSizer circleSizer = new CircleSizer(circle);
		circleSizer.getSize(283);
		Selection selection =new Selection(circleSizer);
		selection.press(g);
		
		circleSizer.getSize(32);
		selection.press(g);
		
		selection.pressUndo(g);
		
		circleSizer.getSize(52);
		selection.press(g);
		
		selection.pressUndo(g);
		
		CircleReColor circleColor = new CircleReColor(circle);
		circleColor.getColor(Color.black);
		selection =new Selection(circleColor);
		selection.press(g);
		
		circleColor.getColor(Color.BLUE);
		selection.press(g);
		
		selection.pressUndo(g);
		
		circleColor.getColor(Color.WHITE);
		selection.press(g);
		
		selection.pressUndo(g);
		
		CircleReposition circleReposition = new CircleReposition(circle);
		circleReposition.getPosition(100,200);
		
		selection =new Selection(circleReposition);
		selection.press(g);
		
		circleReposition.getPosition(350,450);
		selection.press(g);
		
		selection.pressUndo(g);
		
		circleReposition.getPosition(550,650);
		selection.press(g);
		
		selection.pressUndo(g);
		
	}
	
	
}
