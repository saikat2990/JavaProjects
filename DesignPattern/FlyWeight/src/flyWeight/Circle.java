package flyWeight;

import java.util.HashMap;

import java.awt.Color;

public class Circle {

     
    // The HashMap uses the color as the key for every

    // rectangle it will make up to 8 total

     

    private static final HashMap<Color, MyCircle> circlesByColor = new HashMap<Color, MyCircle>();

    

    public static MyCircle getCircle(Color color) {

    	MyCircle circle = (MyCircle)circlesByColor.get(color);

        if(circle == null) {

        	circle = new MyCircle(color);

            circlesByColor.put(color, circle);

          

        }

        return circle;

    }

}
