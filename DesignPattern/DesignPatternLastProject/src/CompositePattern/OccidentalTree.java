package CompositePattern;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class OccidentalTree implements Flora{
	   Color[] shapeColor = {Color.orange, Color.red, Color.yellow,

	            Color.blue, Color.pink, Color.cyan, Color.magenta,

	            Color.black, Color.gray,Color.GREEN,Color.lightGray,Color.DARK_GRAY};
	    
		
	    int []x = {1150,900,1000,700,820,980,560,345};
	    int []y = {1180,920,1110,790,920,910,590,472};
	    
		public OccidentalTree(Graphics g) {
			
			//flyweight
			
			buildFlora(g);

			
//		    
//		    int [] x1 = {450,450,550,550};
//		    int [] y1 = {150,250,150,250};
//		    
//		    Polygon ploy1 = new Polygon(x1, y1, 4);
//		    Graphics2D g2D1 = (Graphics2D) g;
//		    g2D1.setColor(Color.DARK_GRAY);
//		    g2D1.fill(ploy1);
		    
//		    int [] x1 = {900,1000,800};
//		    int [] y1 = {100,150,150};
//		    
//		    Polygon ploy1 = new Polygon(x1, y1, 3);
//		    Graphics2D g2D1 = (Graphics2D) g;
//		    g2D1.setColor(Color.GREEN);
//		    g2D1.fill(ploy1);
		    
		    
		}
		
		private int getIndex() {
			
	        Random randomGenerator = new Random();

	        int randInt = randomGenerator.nextInt(8);

	        return randInt;
			
		}
		
	    private Color getRandColor(){

	        Random randomGenerator = new Random();

	        int randInt = randomGenerator.nextInt(12);

	        return shapeColor[randInt];

	    }

		@Override
		public void buildFlora(Graphics g) {
			// TODO Auto-generated method stub
			for(int i=0;i<70;i++) {
				
				int index = getIndex();
				DrawOccidentalTree drawTree = new 
						DrawOccidentalTree(g, getRandColor(), getRandColor(), 
								x[index], y[index]);
				
			}
			
		}
	}
