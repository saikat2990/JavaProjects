package Blpus;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class BanglaDic {
	
	Font banglaFont=new Font("Arial Unicode MS", Font.BOLD,15);
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	int numberOfPointer;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanglaDic window = new BanglaDic();
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
	public BanglaDic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSearch = new JButton("   SEARCH");
		btnSearch.setBackground(new Color(153, 102, 102));
		btnSearch.setBounds(59, 196, 103, 35);
		frame.getContentPane().add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(232, 131, 103, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("numberOfPointers");
		btnNewButton.setForeground(new Color(153, 51, 51));
		btnNewButton.setBounds(59, 131, 140, 35);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(232, 199, 133, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 294, 166, 55);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		

		
		//numberOfPointer= Integer.parseInt(pointer);
		Insert2 is = new Insert2();
		
		btnNewButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	        		String pointer  = textField.getText();
	                //System.out.println(pointer);
	                numberOfPointer= Integer.parseInt(pointer);
	                System.out.println(numberOfPointer);
	                try {
						is.made(numberOfPointer);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }

	     });
		
		//System.out.println("hello ji");
		
		btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
        		String strin  = textField_1.getText();
                System.out.println(strin);
                
                if(is.srch(strin))textField_2.setText("FOUND");
                else textField_2.setText("NOT FOUND");
            }

        });
	    
	}
}
