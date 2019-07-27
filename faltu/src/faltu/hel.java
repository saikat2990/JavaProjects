package faltu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.Font;

public class hel {

	private JFrame frame;
	
	private JPanel contentPane;
	private JPanel LogIn;
	private JPanel Choice;
	private JButton btnUsername;
	private JButton btnPassword;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnDeposite;
	private JButton btnWithdraw;
	private JPanel Deposite;
	private JPanel WithDraw;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnOk;
	
    PrintStream streamToServer;
    BufferedReader streamFromServer;
    Socket toServer;
	String info;
	private JButton btnNewButton;
	 String Username,pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hel window = new hel();
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
	public hel() {
		initialize2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize2() {
		

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		LogIn = new JPanel();
		frame.getContentPane().add(LogIn, "name_611137767090972");
		LogIn.setLayout(null);
		LogIn.setVisible(true);
		
		Choice = new JPanel();
		frame.getContentPane().add(Choice, "name_611140802432168");
		Choice.setLayout(null);
		Choice.setVisible(false);
		
		Deposite = new JPanel();
		frame.getContentPane().add(Deposite, "name_612017168842522");
		Deposite.setLayout(null);
		Deposite.setVisible(false);
		
		WithDraw = new JPanel();
		frame.getContentPane().add(WithDraw, "name_612020306206885");
		WithDraw.setLayout(null);
				
		btnUsername = new JButton("UserName");
		btnUsername.setBounds(61, 82, 130, 44);
		LogIn.add(btnUsername);
		
		btnPassword = new JButton("PassWord");
		btnPassword.setBounds(61, 184, 119, 44);
		LogIn.add(btnPassword);
		
		textField = new JTextField();
		textField.setBounds(221, 82, 130, 44);
		LogIn.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(221, 171, 130, 44);
		LogIn.add(textField_1);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(135, 284, 130, 44);
		LogIn.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogIn.setVisible(false);
				Choice.setVisible(true);
				
				try{
			        
		            String name;
		            
		            toServer = new Socket("localhost",1068);
		            streamFromServer = new BufferedReader(new InputStreamReader((toServer.getInputStream())));
		            streamToServer = new PrintStream(toServer.getOutputStream());		            
		            System.out.println("Enter Connection Name");
		            //streamToServer.println("saikat");    
		            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		            //name = reader.readLine();   
		           
		            Username  = textField.getText();
		            pass = textField_1.getText();
		            info = Username+","+pass;
		            System.out.println(info);
		            streamToServer.println(info);	
		            
		            String reply = streamFromServer.readLine();  
		            
		            if(reply.equals("Done")) {
		        		
		        		btnDeposite = new JButton("Deposite");
		        		btnDeposite.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				Deposite.setVisible(true);
		        				Choice.setVisible(false);
		        			}
		        		});
		        		
		        		btnDeposite.setBounds(126, 109, 133, 50);
		        		Choice.add(btnDeposite);
		        		
		        		btnWithdraw = new JButton("WithDraw");
		        		btnWithdraw.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				WithDraw.setVisible(true);
		        				Choice.setVisible(false);
		        			}
		        		});
		        		btnWithdraw.setBounds(126, 211, 133, 50);
		        		Choice.add(btnWithdraw);
		        		

		        		//WithDraw.setVisible(false);
		        		
		        		textField_2 = new JTextField();
		        		textField_2.setBounds(188, 119, 195, 64);
		        		Deposite.add(textField_2);
		        		textField_2.setColumns(10);
		        		
		        		JTextPane txtpnEnterYourDeposite = new JTextPane();
		        		txtpnEnterYourDeposite.setFont(new Font("Tahoma", Font.PLAIN, 18));
		        		txtpnEnterYourDeposite.setText("Enter your deposite");
		        		txtpnEnterYourDeposite.setBounds(23, 119, 142, 64);
		        		Deposite.add(txtpnEnterYourDeposite);
		        		

		        		
		        		JTextPane txtpnEnterYourWithdraw = new JTextPane();
		        		txtpnEnterYourWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        		txtpnEnterYourWithdraw.setText("Enter Your WithDraw");
		        		txtpnEnterYourWithdraw.setBounds(29, 135, 126, 59);
		        		WithDraw.add(txtpnEnterYourWithdraw);
		        		
		        		textField_3 = new JTextField();
		        		textField_3.setBounds(202, 135, 147, 59);
		        		WithDraw.add(textField_3);
		        		textField_3.setColumns(10);
		        		
		        		btnNewButton = new JButton("Okay");
		        		btnNewButton.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				String value;
		        				value = textField_3.getText();
		        				//value=value+","+Username+","+pass;
		        				streamToServer.println(value);
		        			}
		        		});
		        		btnNewButton.setBounds(154, 279, 89, 23);
		        		WithDraw.add(btnNewButton);
		        		
		        		btnNewButton = new JButton("Okay");
		        		btnNewButton.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				String value;
		        				value = textField_2.getText();
		        				//value=value+","+Username+","+pass;
		        				streamToServer.println(value);
		        			}
		        		});
		        		btnNewButton.setBounds(154, 279, 89, 23);
		        		Deposite.add(btnNewButton);
		            }
		            
		            
		            
		        }
		        catch(Exception e1)
		        {
		                System.out.println("Exception "+e1);
		        }       
				
			}
		});


	}
}
