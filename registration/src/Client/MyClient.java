package Client;

import java.net.*;

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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;  
class MyClient{  
	
	JPanel panel1;
	JFrame frame1 ;
	BufferedImage img,img2;
	
	boolean flag1=false,flag2=false;
	public MyClient()throws Exception{ 
		
		System.out.println("Welcome to client. Write stop for close");
		
		Socket s=new Socket("10.100.101.84",9995);  
		
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str="",str2="";
		
	
		
			
		frame1 = new JFrame();
		
		
		String accName2;
		String password;
		String balance;
		String accNum;
		String firstName;
		String lastName;
		String email;
		String gender;
		boolean cancel=false;
		
		
			
		TakingInput input=new TakingInput();
		while(!str.equals("stop")){ 
			
			boolean newAccount=false;
			while(true){ 
				accNum=input.accNum;
				firstName=input.firstName;
				lastName=input.lastName;
				accName2=input.userName;
				password=input.password;
				balance=input.Balance;
				email=input.email;
				cancel=input.cancel;
				gender=input.gender;
				newAccount=input.newAccount;
				System.out.println(str2+"username: "+accName2+" password "+password);
				if(accName2.length()!=0&&password.length()!=0&&input.login||newAccount==true||cancel)  break;
			}
			if(newAccount) {
				
				
				System.out.println("new accccccccccccccccccccccccccccccccc");
				dout.writeUTF("newAcc");
				dout.writeUTF(accNum+","+firstName+","+lastName+","+accName2+","+email+","+password+","+balance+","+gender);
				dout.flush();
			}
			else {
				
				dout.writeUTF(accName2);
				dout.writeUTF(password);
				dout.flush();
			
			
			System.out.println("azaz");
			
			if(accName2.length()!=0&&password.length()!=0) {
				
	
				
						System.out.println("hello client");
				
						str2=din.readUTF();  
						
						System.out.println(str2);
					
						
					
					
					
			
			
				if(str2.equals("congratulations")) {
					
					System.out.println("server says:"+str2+accName2+password);
					accName2=din.readUTF();
					password=din.readUTF();
					balance=din.readUTF();
					
					UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
					UIManager.put("OptionPane.minimumSize",new Dimension(500,300));
					JOptionPane.showMessageDialog(null,str2);
				
				
					frame1.setBounds(400, 50, 558,680);
					frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame1.setResizable(false);
					
					
					
					try
					{
						
						 img = ImageIO.read(getClass().getResourceAsStream("/images4.jpg"));
						 img2 = ImageIO.read(getClass().getResourceAsStream("/azaz17.jpg"));
						 
						panel1=new JPanel() {
							 
							 @Override
							    public void paintComponent(Graphics g){
							       
							        g.drawImage(img, 0, 0,  558,680, this);
							        g.drawImage(img2, 0, 0,  558,80, this);
							        
							    }
						 };
						 panel1.setBounds(0, 725, 488, 100);
						 panel1.setForeground(Color.GREEN);
						 
					
					}catch(IOException e) {
						e.printStackTrace();
						
					}
					
					
					frame1.getContentPane().add(panel1);
					
					panel1.setLayout(null);
					
					JLabel lblUsername = new JLabel("Account Name: ");
					lblUsername.setForeground(Color.GREEN);
					lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblUsername.setBounds(45, 115, 194, 34);
					panel1.add(lblUsername);
					
					JLabel accountname = new JLabel(accName2);
					accountname.setForeground(Color.GREEN);
					accountname.setFont(new Font("Tahoma", Font.BOLD, 20));
					accountname.setBounds(205, 115, 290, 34);
					panel1.add(accountname);
					
					
					
					
					JLabel passw1 = new JLabel("password: ");
					passw1.setForeground(Color.GREEN);
					passw1.setFont(new Font("Tahoma", Font.BOLD, 20));
					passw1.setBounds(95, 150, 124, 34);
					panel1.add(passw1);
					
					
					JLabel password2 = new JLabel(password);
					password2.setForeground(Color.GREEN);
					password2.setFont(new Font("Tahoma", Font.BOLD, 20));
					password2.setBounds(205, 150, 124, 34);
					panel1.add(password2);
					
					
					
					
					JLabel balance1= new JLabel("Balance: ");
					balance1.setForeground(Color.GREEN);
					balance1.setFont(new Font("Tahoma", Font.BOLD, 20));
					balance1.setBounds(105, 185, 124, 34);
					panel1.add(balance1);
					
					
					JLabel balance2= new JLabel(balance+"TK");
					balance2.setForeground(Color.GREEN);
					balance2.setFont(new Font("Tahoma", Font.BOLD, 20));
					balance2.setBounds(205, 185, 194, 34);
					panel1.add(balance2);
					
					JLabel choose= new JLabel("Select Your Work: ");
					choose.setForeground(Color.GREEN);
					choose.setFont(new Font("Tahoma", Font.BOLD, 20));
					choose.setBounds(45, 285, 444, 34);
					panel1.add(choose);
					
					JRadioButton withdraw=new JRadioButton("WithDraw");
					withdraw.setBounds(95, 335, 124, 28);
					withdraw.setForeground(Color.BLACK);
					withdraw.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel1.add(withdraw);
					
					JRadioButton deposit=new JRadioButton("Depsit");
					deposit.setBounds(95, 385, 124, 28);
					deposit.setForeground(Color.BLACK);
					deposit.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel1.add(deposit);
					
					
					JLabel amount= new JLabel("Amount: ");
					amount.setForeground(Color.GREEN);
					amount.setFont(new Font("Tahoma", Font.BOLD, 20));
					amount.setBounds(55, 455, 94, 34);
					panel1.add(amount);
					
					JTextField amount2= new JTextField();
					amount2.setForeground(Color.GREEN);
					amount2.setFont(new Font("Tahoma", Font.BOLD, 20));
					amount2.setBounds(155, 455, 214, 34);
					panel1.add(amount2);
					
					
					deposit.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							withdraw.setSelected(false);
						}
						
					});
					
					withdraw.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							deposit.setSelected(false);
						}
						
					});
					
					
					JButton btnNewButton_1 = new JButton("OK");
					btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
					btnNewButton_1.setBackground(Color.RED);
					btnNewButton_1.setForeground(Color.white);
					btnNewButton_1.setBounds(400, 590, 95, 36);
					panel1.add(btnNewButton_1);
					
					
					
					
						btnNewButton_1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							
							String am=amount2.getText();
							
							double amount=Double.parseDouble(am);
							
							if(am.length()!=0&&(withdraw.isSelected())) {
								
								
								
								System.out.println("withdraw amount: "+amount);
								
									System.out.println("hello withdraw");
									
									try {
										
										dout.writeUTF(amount+"");
										dout.writeUTF("withdraw");
										dout.flush();
										
										String currenrbalance1=din.readUTF();
										System.out.println(currenrbalance1);
										
										frame1.setVisible(true);
										UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18));
										UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
										UIManager.put("OptionPane.minimumSize",new Dimension(500,300));
										JOptionPane.showMessageDialog(null,currenrbalance1);
										
										
										System.out.println("Thank you.");
										
										
										dout.flush();
										/*din.close();  
										s.close();  
										s.close(); 
										dout.close();*/ 
										
										
										
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									
									
									flag1=true;  
									
								
								
								
							}
							else if(am.length()!=0&&(deposit.isSelected())){
								
								
									
									try {
										
										dout.writeUTF(amount+"");
										dout.writeUTF("deposit");
										dout.flush();
										
										System.out.println("hello deposit");
										String currenrbalance=din.readUTF();
										System.out.println(currenrbalance);
										
										frame1.setVisible(true);
										UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18));
										UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
										UIManager.put("OptionPane.minimumSize",new Dimension(500,300));
										JOptionPane.showMessageDialog(null,currenrbalance);
										
										dout.flush();
										/*din.close();  
										s.close();  
										s.close(); 
										dout.close();*/
										
										
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									
									
									
									flag2=true;  
									
								}
								
								
							
							
							
							
						}
						
					});
					frame1.setVisible(true);
						
						
					dout.writeUTF("0.0");
					dout.writeUTF("withdraw");
					dout.flush();
					
					
					break;
					
					
					
					
					
				}
				else {
					
					System.out.println(str2);
					
					UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
					UIManager.put("OptionPane.minimumSize",new Dimension(500,300));
					JOptionPane.showMessageDialog(null,str2);
					
				
					
					
				}
					
				
				
				
				
			
		
	
			}
	
		}
		}
		
		
		/*din.close();  
		s.close();  
		s.close(); 
		dout.close();*/
		
		
		
		
	
	}
	
	public static void main(String[] args) throws Exception {
		
		MyClient client=new MyClient();
	}
	
	
}  