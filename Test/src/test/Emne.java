package test;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class Emne extends JFrame{
		
	private JDesktopPane jd = new JDesktopPane();
	
	public Emne(){
		
		setTitle("Saikat");
		setInternalFrame(jd,"SaikatDaDa",41,23);
		setInternalFrame(jd, "RabbiDaDa", 441, 290);
		setSize(800,800);
		add(jd);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void setInternalFrame(JDesktopPane jd,String name,int xaxis,int yaxis) {
		
		JInternalFrame jn = new JInternalFrame(name,true,true,true,true);
		jn.setLayout(new FlowLayout());
		jn.setSize(400,300);
		jn.setLocation(xaxis, yaxis);
		jn.add(new JButton("MAMA"));
		jn.setVisible(true);
		jd.add(jn);
	}
	
}
