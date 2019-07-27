package Command;

import java.awt.Graphics;

public class CircleReposition implements Command{
	
	int previousPositionX,previousPositionY;
	int newPositionX,newPositionY;
	
	Shape circle=new Circle();
	
	public CircleReposition(Shape circle){
		this.circle=circle;
	}
	
	public void getPosition(int newPositionX,int newPositionY) {
		previousPositionX=this.newPositionX;
		previousPositionY=this.newPositionY;
		
		this.newPositionX=newPositionX;
		this.newPositionY=newPositionY;
	}
	
	public void execute(Graphics g) {
		

		circle.reposition(newPositionX,newPositionY,g);
		
	}

	public void undo(Graphics g) {
		
		circle.reposition(previousPositionX,previousPositionY,g);
		
	}
}
