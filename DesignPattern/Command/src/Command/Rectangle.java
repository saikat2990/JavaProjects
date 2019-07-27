package Command;

public class Rectangle {
	int previousSize,previousColor,prePositionX,prePositionY;
	
	public void resizer(int newSize) {
		previousSize=newSize;
		System.out.println("I am in rectangle resizer");
	}


	public void recolor(int newColor) {
		previousColor=newColor;
		System.out.println("I am in rectangle recolor");
	}


	public void reposition(int newPositionX,int newPositionY) {
		prePositionX=newPositionX;
		prePositionY=newPositionY;
		System.out.println("I am in rectangle reposition");
	}

}
