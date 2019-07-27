package bufferedImage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Test extends JPanel{
	
	public void paint(Graphics g) {
		
		Image img = createImageWithText();
		g.drawImage(img, 100, 200, this);
		
	}

	private Image createImageWithText() {
		
		BufferedImage bufferedImage = new BufferedImage(500,500,BufferedImage.TYPE_USHORT_GRAY);
		Graphics g = bufferedImage.getGraphics();
		g.drawString("www.tutorialspoint.com",40,60);
		g.drawString("www.tutorialspoint.com",30,120);
		g.drawString("www.tutorialspoint.com",20,160);
		g.drawImage(bufferedImage, WIDTH, WIDTH, WIDTH, HEIGHT, HEIGHT, HEIGHT, HEIGHT, HEIGHT, getParent());
		
		
		return bufferedImage;
	}
	
}
