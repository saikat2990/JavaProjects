package Client;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Registration {

	private JFrame frame;
	BufferedImage img;
	JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
				
				
				frame = new JFrame();
				frame.setBounds(100, 100, 494, 761);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				
				
				try
				{
					
					 img = ImageIO.read(getClass().getResourceAsStream("/images12.png"));
					 
					 panel=new JPanel() {
						 
						 @Override
						    public void paintComponent(Graphics g){
						       
						        g.drawImage(img, 0, 0, 494, 761, this);
						        
						    }
					 };
					 panel.setBounds(0, 725, 488, 1);
					 panel.setForeground(Color.GREEN);
					 
				
				}catch(IOException e) {
					e.printStackTrace();
					
				}
				
				
				frame.getContentPane().add(panel);
				frame.setVisible(true);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("First Name:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel.setForeground(Color.GREEN);
				lblNewLabel.setBounds(55, 121, 94, 34);
				panel.add(lblNewLabel);
				
				JLabel lblLastName = new JLabel("Last Name:");
				lblLastName.setForeground(Color.GREEN);
				lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblLastName.setBounds(55, 186, 94, 34);
				panel.add(lblLastName);
				
				JLabel lblUsername = new JLabel("UserName:");
				lblUsername.setForeground(Color.GREEN);
				lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblUsername.setBounds(55, 255, 94, 34);
				panel.add(lblUsername);
				
				JLabel lblPassword = new JLabel("Password:");
				lblPassword.setForeground(Color.GREEN);
				lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblPassword.setBounds(55, 330, 94, 34);
				panel.add(lblPassword);
				
				JLabel lblComfirmPass = new JLabel("Comfirm Pass:");
				lblComfirmPass.setForeground(Color.GREEN);
				lblComfirmPass.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblComfirmPass.setBounds(30, 402, 123, 34);
				panel.add(lblComfirmPass);
				
				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setForeground(Color.GREEN);
				lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblEmail.setBounds(95, 475, 59, 34);
				panel.add(lblEmail);
				
				JTextField textField = new JTextField();
				textField.setFont(new Font("Tahoma", Font.BOLD, 16));
				textField.setBounds(165, 117, 226, 38);
				panel.add(textField);
				textField.setColumns(10);
				
				JTextField textField_1 = new JTextField();
				textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				textField_1.setColumns(10);
				textField_1.setBounds(165, 185, 226, 38);
				panel.add(textField_1);
				
				JTextField textField_2 = new JTextField();
				textField_2.setFont(new Font("Tahoma", Font.BOLD, 16));
				textField_2.setColumns(10);
				textField_2.setBounds(165, 254, 226, 38);
				panel.add(textField_2);
				
				JTextField textField_3 = new JTextField();
				textField_3.setFont(new Font("Tahoma", Font.BOLD, 16));
				textField_3.setColumns(10);
				textField_3.setBounds(165, 329, 226, 38);
				panel.add(textField_3);
				
				JTextField textField_4 = new JTextField();
				textField_4.setFont(new Font("Tahoma", Font.BOLD, 16));
				textField_4.setColumns(10);
				textField_4.setBounds(165, 401, 226, 38);
				panel.add(textField_4);
				
				JTextField textField_5 = new JTextField();
				textField_5.setFont(new Font("Tahoma", Font.BOLD, 16));
				textField_5.setColumns(10);
				textField_5.setBounds(164, 474, 226, 38);
				panel.add(textField_5);
				
				JButton btnNewButton = new JButton("New button");
				btnNewButton.setBounds(70, 610, 97, 25);
				panel.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("New button");
				btnNewButton_1.setBounds(271, 610, 97, 25);
				panel.add(btnNewButton_1);
				
				JLabel label = new JLabel("");
				label.setBounds(132, 151, 56, 16);
				frame.getContentPane().add(label);
				
				
				
				
				
				
				
	}
}
