package bufferedImage;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class JDesptoppanetest extends JFrame{
	
	private JDesktopPane jd = new JDesktopPane();
	
	public JDesptoppanetest() {
		
		setTitle("JInternalFrame");
		setJInternalFrame(jd,"InternalFrame1",30,60);
		setJInternalFrame(jd,"InternalFrame2",500,60);
		setJDesktopPane();
		setSize(600,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	private void setJDesktopPane() {
		// TODO Auto-generated method stub
		add(jd);
	}

	void setJInternalFrame(JDesktopPane jd,String name,int loc1,int loc2) {
		
		JInternalFrame jn = new JInternalFrame(name,true,true,true,true);
		jn.setLayout(new FlowLayout());
		jn.setSize(120,100);
		jn.add(new JButton("fuck off"));
		jn.setLocation(loc1,loc2);
		jn.setVisible(true);
		jd.add(jn);
		
		
	}
}
