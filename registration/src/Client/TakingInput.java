package Client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;



public class TakingInput {
	
	private JFrame frame,frame1;
	BufferedImage img;
	JPanel panel,panel1;
	
	
	boolean newAccount=false;
	
	public String userName="",password="",email,gender,Balance,accNum,firstName,lastName;
	public boolean login=false;
	
	
	public boolean userNameflag=true,passwordflag=true,emailflag=true,cancel=false;
	
	
	
	public TakingInput() {
		Signin();
		
	}
	
	public void Signin() {
		
		frame1 = new JFrame();
		frame1.setBounds(600, 200, 558,380);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setResizable(false);
		
		
		
		try
		{
			
			 img = ImageIO.read(getClass().getResourceAsStream("/images4.jpg"));
			 
			 panel1=new JPanel() {
				 
				 @Override
				    public void paintComponent(Graphics g){
				       
				        g.drawImage(img, 0, 0,  558,380, this);
				        
				    }
			 };
			 panel1.setBounds(0, 725, 488, 1);
			 panel1.setForeground(Color.GREEN);
			 
		
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
		frame1.getContentPane().add(panel1);
		
		panel1.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setForeground(Color.GREEN);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(75, 95, 94, 34);
		panel1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.GREEN);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(75, 170, 94, 34);
		panel1.add(lblPassword);
		
		JTextField textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(175, 95,195, 33);
		panel1.add(textField_3);
		
		JPasswordField textField_4 = new JPasswordField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(175, 170,195, 33);
		panel1.add(textField_4);
		
		
		JButton btnNewButton = new JButton("cancel");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(Color.red);
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBounds(120, 260, 90, 35);
		panel1.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				cancel=true;
				frame1.setVisible(false);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			
			
			
		});
		
		
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.green);
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setBounds(281, 260, 95, 36);
		panel1.add(btnNewButton_1);
		
		btnNewButton_1 .addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				System.out.println("hello azaz");
				
				File file=new File("input.txt");
				boolean flag=false;
				login=true;
				
				
				
				
				try {
					String s1,s2;
					password=String.valueOf(textField_4.getPassword());
					userName=textField_3.getText();
					BufferedReader read = new BufferedReader(new FileReader(file));
				    String s;
				    
				    
				    frame1.setVisible(false);
				    
				   
				}catch(IOException l) {
					
				}
				
			}
			

		});
		
		
		
		
		
		
		
		JLabel newAcc = new JLabel("Create new account");
		newAcc.setForeground(Color.GREEN);
		newAcc.setFont(new Font("Tahoma", Font.BOLD, 16));
		newAcc.setBounds(145, 305, 224, 34);
		panel1.add(newAcc);
		
		newAcc.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				frame1.setVisible(false);
				initialize();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			
			
			
		});
		
		
		
		
		frame1.setVisible(true);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(500, 50, 494, 761);
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
		lblNewLabel.setBounds(55, 81, 94, 34);
		panel.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.GREEN);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(55, 146, 94, 34);
		panel.add(lblLastName);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setForeground(Color.GREEN);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(55, 215, 94, 34);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.GREEN);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(55, 290, 94, 34);
		panel.add(lblPassword);
		
		JLabel lblComfirmPass = new JLabel("Comfirm Pass:");
		lblComfirmPass.setForeground(Color.GREEN);
		lblComfirmPass.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblComfirmPass.setBounds(30, 362, 123, 34);
		panel.add(lblComfirmPass);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.GREEN);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(95, 435, 59, 34);
		panel.add(lblEmail);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(165, 77, 226, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(165, 145, 226, 38);
		panel.add(textField_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(165, 214, 226, 38);
		panel.add(textField_2);
		
		textField_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				File file=new File("input.txt");
				userNameflag=true;
				
				
				try {
					String s1;
					s1=textField_2.getText();
					
					
					
					
					String line=s1;
					
					String pattern="((?=.*[A-Z]).{6,14})";
					
					Pattern r=Pattern.compile(pattern);
					
					Matcher m=r.matcher(line);
					
					
					if(!m.find()) {
						UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
						UIManager.put("OptionPane.minimumSize",new Dimension(200,100));
						JOptionPane.showMessageDialog(textField_2, "Invalid userName");
						userNameflag=false;
					}
					else {
					
					BufferedReader read = new BufferedReader(new FileReader(file));
					
					
					readXml xml=new readXml();
					
				    
				   boolean  flag= xml.matchUserName(s1);
				   System.out.println(flag+" "+s1);
				    
					String s;
					//while((s=read.readLine())!=null) {
						
						
						if(flag==true) {
							
							 String speaktext;
								
							/*	try
								{
									
									VoiceManager voiceManager=VoiceManager.getInstance();
									Voice voices=voiceManager.getVoice("kevin16");
									Voice voices1[]=voiceManager.getVoices();
									
									System.out.println("Available Voices");
									
									for(int i=0;i<voices1.length;i++)
										
										System.out.println(voices1[i].getName());
									
									/*Voice sp=null;
									if(voices!=null)
									{
										sp=voices; 
									}
									else
									{
										System.out.println("No Voice Available");
									}
									sp.allocate();
									sp.speak("This UserName already exist");
									sp.deallocate();
								}
								catch(Exception a)
								{
									
										a.printStackTrace();
									
								}*/
							
							
							UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
							UIManager.put("OptionPane.minimumSize",new Dimension(200,100));
							JOptionPane.showMessageDialog(textField_2, "This UserName already exist");
							textField_2.setText("");
							
						}
					}
						
					//}
				}
				catch(IOException j) {
					
					j.printStackTrace();
					
					
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
			
			
		});
		
		
		
		
		
		JPasswordField textField_3 = new JPasswordField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(165, 289, 226, 38);
		panel.add(textField_3);
		
		textField_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				File file=new File("input.txt");
				passwordflag=true;
				
				
				try {
					String s1,s2;
					s1=String.valueOf(textField_3.getPassword());
					
					
					String line=s1;
					
					String pattern="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,14})";
					
					Pattern r=Pattern.compile(pattern);
					
					Matcher m=r.matcher(line);
					
					
					if(!m.find()) {
						UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
						UIManager.put("OptionPane.minimumSize",new Dimension(200,100));
						JOptionPane.showMessageDialog(textField_3, "Invalid password");
						passwordflag=false;
					}
					else {
					
					BufferedReader read = new BufferedReader(new FileReader(file));
					
					String s;
					//while((s=read.readLine())!=null) {
						
					readXml xml=new readXml();
				    
				    boolean flag= xml.matchPassword(s1);
				    
						
						if(flag==true) {
							
							 String speaktext;
								
								/*try
								{
									
									VoiceManager voiceManager=VoiceManager.getInstance();
									Voice voices=voiceManager.getVoice("kevin16");
									Voice voices1[]=voiceManager.getVoices();
									
									System.out.println("Available Voices");
									
									for(int i=0;i<voices1.length;i++)
										
										System.out.println(voices1[i].getName());
									
									Voice sp=null;
									if(voices!=null)
									{
										sp=voices; 
									}
									else
									{
										System.out.println("No Voice Available");
									}
									sp.allocate();
									sp.speak("This password already exist");
									sp.deallocate();
								}
								catch(Exception a)
								{
									
										a.printStackTrace();
									
								}*/
							
							
							UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
							UIManager.put("OptionPane.minimumSize",new Dimension(200,100));
							JOptionPane.showMessageDialog(textField_3, "This password already exist");
							
							textField_3.setText("");
						}
						
						
					//}
					}
				}
				catch(IOException j) {
					
					j.printStackTrace();
					
					
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
			
			
		});
		
		JPasswordField textField_4 = new JPasswordField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(165, 361, 226, 38);
		panel.add(textField_4);
		
		
		textField_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str1 ,str2;
				
				
				str1=String.valueOf(textField_4.getPassword());
				str2=String.valueOf(textField_3.getPassword());
				
				
				if(!str1.equalsIgnoreCase(str2)) {
					//System.out.println(str1+" "+str2);
					 String speaktext;
						
						/*try
						{
							
							VoiceManager voiceManager=VoiceManager.getInstance();
							Voice voices=voiceManager.getVoice("kevin16");
							Voice voices1[]=voiceManager.getVoices();
							
							System.out.println("Available Voices");
							
							for(int i=0;i<voices1.length;i++)
								
								System.out.println(voices1[i].getName());
							
							Voice sp=null;
							if(voices!=null)
							{
								sp=voices; 
							}
							else
							{
								System.out.println("No Voice Available");
							}
							sp.allocate();
							sp.speak("Wrong Confirm password");
							sp.deallocate();
						}
						catch(Exception a)
						{
							
								a.printStackTrace();
							
						}*/
					
					
					
					
					
					
					
					
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
					UIManager.put("OptionPane.minimumSize",new Dimension(100,50));
					JOptionPane.showMessageDialog(textField_4, "Wrong Confirm password");
					
					
					
				}
				
				
				
			}
			
			
		});
		
		
		
		
		JTextField textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(164, 434, 226, 38);
		panel.add(textField_5);
		
		textField_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				emailflag=true;
				String line=textField_5.getText();
				
				String pattern="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
				
				Pattern r=Pattern.compile(pattern);
				
				Matcher m=r.matcher(line);
				
				
				if(!m.find()) {
					
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
					UIManager.put("OptionPane.minimumSize",new Dimension(100,50));
					JOptionPane.showMessageDialog(textField_4, "Invalid Email ID");
					
					emailflag=false;
				
				}
				
			}
			
			
		}); 
		
		
		
		JButton btnNewButton = new JButton("cancel");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(Color.red);
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBounds(100, 650, 90, 35);
		panel.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
						cancel=true;
						frame.setVisible(false);
						
					}
		
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
		
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
		
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
		
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
		
					
					
					
					
		});
				
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.green);
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setBounds(291, 650, 95, 36);
		panel.add(btnNewButton_1);
		
		JLabel balance = new JLabel("Init Balance:");
		balance.setForeground(Color.GREEN);
		balance.setFont(new Font("Tahoma", Font.BOLD, 16));
		balance.setBounds(38, 500, 265, 34);
		panel.add(balance);
		
		JTextField textBalance = new JTextField();
		textBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		textBalance.setColumns(10);
		textBalance.setBounds(165,  500, 226, 38);
		panel.add(textBalance);
		
		
		
		JRadioButton rd1 = new JRadioButton("Male");
		
		rd1.setBounds(301,580,100,40);
		rd1.setBackground(new Color(30,51,25));
		rd1.setForeground(Color.GREEN);
		
		
		panel.add(rd1);
		
		JRadioButton rd2 = new JRadioButton("Female");
		
		rd2.setBounds(171,580,100,40);
		rd2.setBackground(new Color(30,51,25));
		rd2.setForeground(Color.GREEN);
		panel.add(rd2);
		
		
		rd1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rd2.setSelected(false);
				gender="male";
				
			}
			
			
		});
		
		rd2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rd1.setSelected(false);
				gender="female";
				
				
			}
			
			
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
				if(textField.getText().length()==0||textField_1.getText().length()==0||String.valueOf(textField_3.getPassword()).length()==0||textField_5.getText().length()==0||
				  (rd1.isSelected()==false&&rd2.isSelected()==false)||userNameflag==false||passwordflag==false||emailflag==false	) {
					
					 String speaktext;
						
						/*try
						{
							
							VoiceManager voiceManager=VoiceManager.getInstance();
							Voice voices=voiceManager.getVoice("kevin16");
							Voice voices1[]=voiceManager.getVoices();
							
							System.out.println("Available Voices");
							
							for(int i=0;i<voices1.length;i++)
								
								System.out.println(voices1[i].getName());
							
							Voice sp=null;
							if(voices!=null)
							{
								sp=voices; 
							}
							else
							{
								System.out.println("No Voice Available");
							}
							sp.allocate();
							sp.speak("Please fill up all required fields");
							sp.deallocate();
						}
						catch(Exception a)
						{
							
								a.printStackTrace();
							
						}*/
					
					
					
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
					UIManager.put("OptionPane.minimumSize",new Dimension(100,50));
					JOptionPane.showMessageDialog(textField_2, "Please fill up all required fields");
				
				}
				else {
					
					

					String str1 ,str2;
					
					
					str1=String.valueOf(textField_4.getPassword());
					str2=String.valueOf(textField_3.getPassword());
					
					if(!str1.equalsIgnoreCase(str2)) {
						//System.out.println(str1+" "+str2);
						 String speaktext;
							
							/*try
							{
								
								VoiceManager voiceManager=VoiceManager.getInstance();
								Voice voices=voiceManager.getVoice("kevin16");
								Voice voices1[]=voiceManager.getVoices();
								
								System.out.println("Available Voices");
								
								for(int i=0;i<voices1.length;i++)
									
									System.out.println(voices1[i].getName());
								
								Voice sp=null;
								if(voices!=null)
								{
									sp=voices; 
								}
								else
								{
									System.out.println("No Voice Available");
								}
								sp.allocate();
								sp.speak("Wrong Confirm password");
								sp.deallocate();
							}
							catch(Exception a)
							{
								
									a.printStackTrace();
								
							}*/
						
						
						
						
						
						
						
						
						UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
						UIManager.put("OptionPane.minimumSize",new Dimension(100,50));
						JOptionPane.showMessageDialog(textField_4, "Wrong Confirm password");
						
						
						
					}
					
					else{
						int AccNo=0;
					
					try {
						
						
						BufferedReader read = new BufferedReader(new FileReader(new File("input.txt")));
						
						/*String s;
						while((s=read.readLine())!=null) {
							
							AccNo++;
							
					
						}*/
					}catch(IOException a) {
						
						
					}
					
					
					
					String s=(AccNo+1)+","+textField_2.getText()+","+textField_5.getText()+","+String.valueOf(textField_3.getPassword())+","+gender;
					
					try{
						
						accNum=(AccNo+1)+"";
						firstName=textField.getText();
						lastName=textField_1.getText();
						userName=textField_2.getText();
						email=textField_5.getText();
						password=String.valueOf(textField_3.getPassword());
						Balance=textBalance.getText();
						
						//CreateXmlFile createXml=new CreateXmlFile(AccNo+1+" ",textField.getText(),textField_1.getText(),textField_2.getText(),textField_5.getText(),String.valueOf(textField_3.getPassword()),gender);
						
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					File file=new File("input.txt");
					/*try {
						
						
						/*BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
						writer.write(s);
						writer.newLine();
						
						
						writer.close();
						
						
					}catch(IOException x) {
						
						x.printStackTrace();
					}*/
					
					 String speaktext;
						
						/*try
						{
							
							VoiceManager voiceManager=VoiceManager.getInstance();
							Voice voices=voiceManager.getVoice("kevin16");
							Voice voices1[]=voiceManager.getVoices();
							
							System.out.println("Available Voices");
							
							for(int i=0;i<voices1.length;i++)
								
								System.out.println(voices1[i].getName());
							
							Voice sp=null;
							if(voices!=null)
							{
								sp=voices; 
							}
							else
							{
								System.out.println("No Voice Available");
							}
							sp.allocate();
							sp.speak("Sign up successfully");
							sp.deallocate();
						}
						catch(Exception a)
						{
							
								a.printStackTrace();
							
						}*/
					
						
					newAccount=true;
					
					
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
					UIManager.put("OptionPane.minimumSize",new Dimension(200,100));
					JOptionPane.showMessageDialog(textField_2, "Sign up successfully");
					frame.setVisible(false);
					
				}
				
				//Table table=new Table();
				
				
			}
			}
			
		
				
			
			
		});
		
		
		
		
		JLabel lb1 = new JLabel("Gender:");
		lb1.setForeground(Color.GREEN);
		lb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb1.setBounds(82, 582, 65, 34);
		panel.add(lb1);
		
		
		
		
		
		JLabel label = new JLabel("Please fillup all the requirements.");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(25, 25, 400, 16);
		panel.add(label);
		
		
		
		
	}
}
