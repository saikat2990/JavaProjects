package flyWeight;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FlyWeight extends JFrame{

    private static final long serialVersionUID = 1L;

    JButton startDrawing1,startDrawing2,startDrawing3;

    int windowWidth = 1750;

    int windowHeight = 1000;

    Color[] shapeColor = {Color.orange, Color.red, Color.yellow,

            Color.blue, Color.pink, Color.cyan, Color.magenta,

            Color.black, Color.gray};

    public static void main(String[] args){

        new FlyWeight();
    }

    public FlyWeight(){

        this.setSize(windowWidth,windowHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Flyweight Test");
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        final JPanel  drawingPanel  = new JPanel();
        
        startDrawing1 = new JButton("Button 1");
        startDrawing2 = new JButton("Button 2");
        startDrawing3 = new JButton("Button 3");
        
        contentPane.add(drawingPanel,  BorderLayout.CENTER);
        contentPane.add(startDrawing1, BorderLayout.NORTH);
        contentPane.add(startDrawing2, BorderLayout.SOUTH);
        

        startDrawing1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                Graphics g = drawingPanel.getGraphics();

                long startTime = System.currentTimeMillis();

                for(int i=0; i < 500000; ++i) {

                    MyCircle circle = Circle.getCircle(getRandColor());

                    circle.draw(g, getRandX(), getRandY(),
                    		getRandWidth(),getRandHeight());
                   


/*
                    MyCircle circle = new MyCircle(getRandColor(), getRandX(), getRandY(), getRandX(), getRandY());

                    circle.draw(g);
*/
/*
                    g.setColor(getRandColor());
                    g.fillOval(getRandX(), getRandY(), getRandHeight(), getRandHeight());
*/
                    
                }

                long endTime = System.currentTimeMillis();

                System.out.println("That took " + (endTime - startTime) + " milliseconds");

             }

          });
        
        startDrawing2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                Graphics g = drawingPanel.getGraphics();

                long startTime = System.currentTimeMillis();

                for(int i=0; i < 500000; ++i) {
/*
                    MyCircle circle = Circle.getCircle(getRandColor());

                    circle.draw(g, getRandX(), getRandY(),
                            getRandX(), getRandY());
                     */


                    MyCircle circle = new MyCircle(getRandColor(), getRandX(), getRandY(), getRandWidth(), getRandHeight());

                    circle.draw1(g);

/*
                    g.setColor(getRandColor());
                    g.fillOval(getRandX(), getRandY(), getRandX(), getRandY());
*/
                }

                long endTime = System.currentTimeMillis();

                System.out.println("That took " + (endTime - startTime) + " milliseconds");

             }

          });

        this.add(contentPane);
        this.setVisible(true);
        
    }


    private int getRandX(){ return (int)(Math.random()*windowWidth); }

    private int getRandY(){ return (int)(Math.random()*windowHeight); }
    
    private int getRandWidth(){ return (int)(Math.random()*windowWidth); }

    private int getRandHeight(){ return (int)(Math.random()*windowHeight); }

    private Color getRandColor(){

        Random randomGenerator = new Random();

        int randInt = randomGenerator.nextInt(9);

        return shapeColor[randInt];

    }

}

