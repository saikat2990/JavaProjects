package client;
//package clientServer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Dat
{	
	
	
	private static  JFrame frame;
	private JPanel contentPane;
	private static  JTextField textFirstName;
	private static  JTextField textLastName;
	private static  JTextField textPassWord;
	private static  JButton btnOk_1;
	
	public static String info;
	
    PrintStream streamToServer;
    BufferedReader streamFromServer;
    Socket toServer;
    
    private static  void initialize() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dat window = new Dat();
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
					info = fname+","+lname+","+pass;
					
					System.out.println("print "+fname+lname+pass);
			}
		});
		
	}    

	
    public Dat()
    {
    	System.out.println("Welcome to Client");
    	

        connectToServer();
    }
    private void connectToServer()
    {
        try{
        
            String name;
            toServer = new Socket("localhost",1098);
            //while(true) {
            streamFromServer = new BufferedReader(new InputStreamReader((toServer.getInputStream())));
            streamToServer = new PrintStream(toServer.getOutputStream());
            
            System.out.println("Enter Connection Name");
            //
            streamToServer.println("saikat");

            
///////
            //initialize();
            //info = "saikat"+","+"sen"+","+"123";
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            name = reader.readLine();   
            streamToServer.println(info);
///////		
            String reply = streamFromServer.readLine();
            if(reply.equals("Done")) {
            		
            }
            /*while(true) {
            String str = streamFromServer.readLine();
            System.out.println("The Server Says "+str);
            
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            name = reader1.readLine();   
            streamToServer.println(name);
            }*/
            
        }
        catch(Exception e)
        {
                System.out.println("Exception "+e);
        }       
    }
    public static void main(String args[])
    {	
    	//tr1 tr = new tr1();
    	//tr.
    	initialize();
    	new Dat();
    }
}
