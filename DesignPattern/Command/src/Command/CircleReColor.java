package Command;

import java.awt.Color;
import java.awt.Graphics;

public class CircleReColor implements Command{
	
	Color previousColor,newColor;
	Shape circle=new Circle();
	
	public CircleReColor(Shape circle){
		this.circle=circle;
	}
	
	public void getColor(Color newColor) {
		previousColor=this.newColor;
		this.newColor=newColor;
	}
	public void execute(Graphics g) {
		
		circle.recolor(newColor,g);
		
	}

	public void undo(Graphics g) {
		
		circle.recolor(previousColor,g);
		
	}

}
