package Command;

import java.awt.Graphics;

public class CircleSizer implements Command{

	int previousSize,newSize=0;

	
	Shape circle=new Circle();
	
	public CircleSizer(Shape circle){
		this.circle=circle;
	}
	
	public void getSize(int newSize) {
		previousSize=this.newSize;
		this.newSize=newSize;
	}
	public void execute(Graphics g) {
		
		
		circle.resizer(newSize,g);
		
	}

	public void undo(Graphics g) {
		
		circle.resizer(previousSize,g);
		
	}

}
