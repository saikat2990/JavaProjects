package CompositePattern;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;
 
public class DrawPolygon extends JPanel {
 
  public void paintComponent(Graphics g) {
	  
    int [] x = {50,50,90,90,150,90,90};
    int [] y = {55,85,85,110,70,30,55};
    
    //g.drawPolygon();
    
    Polygon ploy = new Polygon(x, y, 7);
    Graphics2D g2D = (Graphics2D) g;
    g2D.fill(ploy);
  }
 
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Draw Polygon");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.white);
    frame.setSize(300, 200);
 
    DrawPolygon panel = new DrawPolygon();
 
    frame.add(panel);
 
    frame.setVisible(true);
  }
}