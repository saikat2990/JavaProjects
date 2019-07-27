package Command;

import java.awt.Color;
import java.awt.Graphics;

public interface Shape {
	public void resizer(int newSize,Graphics g);
	public void recolor(Color newColor,Graphics g);
	public void reposition(int newPositionX,int newPositionY,Graphics g);
}
