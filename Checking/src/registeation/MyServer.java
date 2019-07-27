package registeation;

import java.net.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;  
class MyServer { 
	
	
	JPanel panel1;
	readXml xml;
	public MyServer() throws Exception {
		
		
		
		ArrayList<Account> acc =new ArrayList<Account>();
		
		/*Account[] account=new Account[3];
		
		account[0]=new Account(1200.0,"azaz","123");
		account[1]=new Account(1300.0,"bablu","124");
		account[2]=new Account(1400.0,"atiq","234");*/
		
		xml=new readXml();
		xml.checkUserNameandPassword(acc);
		
		/*for(Account a:acc) {
			System.out.println("UserName: "+a.getAccName());
			System.out.println("Password: "+a.getPassword());
			System.out.println("Balance: "+a.getBalance());
			
		}*/
		
		
		
		System.out.println("welcome to server");
		
		ServerSocket ss=new ServerSocket(6689);  
		
		Socket s=ss.accept();  
		
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		
		boolean flag=false;  
		Account myacc=null;
		String str2="invalid username or password";  
	
	
		while(!str2.equals("stop")){  
			
			String str=din.readUTF(); 
			String password=din.readUTF(); 
			
			if(str.equals("newAcc")) {
				
				String[] items=password.split(",");
				
				CreateXmlFile createXml=new CreateXmlFile(items[0],items[1],items[2],items[3],items[4],items[5],items[6],items[7]);
				
				
				
			}
			else {
			
					for(Account a:acc) {
						
						if(a.getAccName().equals(str)&&a.getPassword().equals(password)) {
							
							str2="congratulations"; 
							myacc=a;
							break;
						}
					}
					
				
					System.out.println(str2);
					
					if(str2.equals("congratulations")) {
						
						dout.writeUTF(str2);
						dout.flush();
					/*	UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18));
						UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
						UIManager.put("OptionPane.minimumSize",new Dimension(500,300));
						JOptionPane.showMessageDialog(null,"UserName: "+str+"\n"+"Password: "+password+"\n");*/
						
						String 	UserName=myacc.getAccName();
						String Password=myacc.getPassword();
						double Balance=myacc.getBalance();
						
						dout.writeUTF(UserName);
						dout.writeUTF(Password);
						dout.writeUTF(Balance+"");
						
						
						String amount=din.readUTF();
						String workType=din.readUTF();
						
						 amount=din.readUTF();
						 workType=din.readUTF();
						
						System.out.println("server withdraw");
						double amount2=Double.parseDouble(amount);
						
						
						
						if(workType.equals("withdraw")) {
							
							myacc.withdraw(amount2);
							
							System.out.println(xml.updateXml(UserName, password,myacc.getBalance()+"") );
							dout.writeUTF(amount+"TK Withdraw successfully.\n"+" Your Current Balance: "+ myacc.getBalance()+"TK"+"\n Thank you");
							
							
						}
						else if(workType.equals("deposit")){
							
							myacc.deposit(amount2);
							
							System.out.println( xml.updateXml(UserName, password,myacc.getBalance()+"") );
							
							dout.writeUTF(amount+"TK Deposit successfully.\n"+" Your Current Balance: "+ myacc.getBalance()+"TK"+"\n Thank you");
						}
						
						
						
						System.out.println("hello server");
						
						dout.flush();
						din.close();  
						s.close();  
						ss.close();
						
						
						System.out.println("OK from Server");
						break;
					}
					else {
						
					
						
						dout.writeUTF(str2);
						dout.flush();
						
					}
						
				}
			
					
		
			
			
			 
		}
		
		
		
			
		
	}

		

	
	public static void main(String args[])throws Exception{
			
		
		
		MyServer myserver=new MyServer();
		
						
	}

	
			
}  
