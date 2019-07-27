package Command;
import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Shape{
	
	public Circle(){
		
		
	}
	Color previousColor=Color.GREEN;
	int previousSize=23,prePositionX=234,prePositionY=234;
	
	public void resizer(int newSize, Graphics g) {
		previousSize=newSize;
		g.setColor(previousColor);
		g.fillOval(prePositionX, prePositionY, newSize, newSize);
		System.out.println("I am in circle resizer "+newSize);
	}


	public void recolor(Color newColor, Graphics g) {
		previousColor= newColor;
		g.setColor(previousColor);
		g.fillOval(prePositionX, prePositionY, previousSize, previousSize);
		System.out.println("I am in circle recolor "+newColor);
	}


	public void reposition(int newPositionX,int newPositionY,Graphics g) {
		prePositionX=newPositionX;
		prePositionY=newPositionY;
		g.setColor(previousColor);
		g.fillOval(prePositionX, prePositionY, previousSize, previousSize);
		System.out.println("I am in circle reposition "+newPositionX+" "+newPositionY);
	}

}
