package client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class tr1 {

	JFrame frame;
	private JPanel contentPane;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textPassWord;
	private JButton btnOk_1;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		

		
	}*/

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public tr1() {
		

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tr1 window = new tr1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFirstname = new JButton("FirstName");
		btnFirstname.setBounds(42, 106, 89, 23);
		frame.getContentPane().add(btnFirstname);
		
		JButton btnLastname = new JButton("LastName");
		btnLastname.setBounds(42, 152, 89, 23);
		frame.getContentPane().add(btnLastname);
		
		JButton btnPassword = new JButton("PassWord");
		btnPassword.setBounds(42, 198, 89, 23);
		frame.getContentPane().add(btnPassword);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(177, 107, 123, 20);
		frame.getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setBounds(177, 153, 123, 23);
		frame.getContentPane().add(textLastName);
		textLastName.setColumns(10);
		
		textPassWord = new JTextField();
		textPassWord.setColumns(10);
		textPassWord.setBounds(177, 199, 123, 23);
		frame.getContentPane().add(textPassWord);
		
		btnOk_1 = new JButton("ok");
		btnOk_1.setBounds(117, 270, 89, 23);
		frame.getContentPane().add(btnOk_1);
		btnOk_1.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e){
		
					String fname,lname,pass;
					fname=textFirstName.getText();
					lname = textLastName.getText();
					pass= textPassWord.getText();
					System.out.println("print "+fname+lname+pass);
			}
		});
		
	}
}
