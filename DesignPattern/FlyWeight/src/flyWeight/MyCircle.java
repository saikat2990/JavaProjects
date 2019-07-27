package flyWeight;
import java.awt.*;

public class MyCircle{

   private Color color = Color.black;

   private int x, y, x2, y2;

    

   public MyCircle(Color color) {

       this.color = color;
   }

   

   public void draw(Graphics g, int upperX, int upperY, int lowerX, int lowerY) {

          g.setColor(color);

          g.fillOval(upperX, upperY, lowerX, lowerY);

   }

    

   // Original forces creation of a rectangle every time

      

   public MyCircle(Color color, int upperX, int upperY, int lowerX, int lowerY) {

      this.color = color;

      this.x = upperX;  

      this.y = upperY;

      this.x2 = lowerX;

      this.y2 = lowerY;

   }

   public void draw1(Graphics g) {

      g.setColor(color);

      g.fillOval(x, y, x2, y2);

   }

   

}
