package registration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class readXml {
	
	
	
	public boolean flag;
	public NodeList list;
	Element element;
	
	public readXml() throws ParserConfigurationException, SAXException, IOException {
		
		
		
		
		
		
		
		//System.out.println("list:"+list);
		
	}
		
	

	public boolean	checkUserNameandPassword(ArrayList<Account> acc) throws ParserConfigurationException, SAXException, IOException{
		
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document du=db.parse(new File("azaz.xml"));
		
		 element= du.getDocumentElement();
		
			
			list=element.getChildNodes();
			String UserNameFromXml;
			String PasswordFromXml;
			String balance;
			String email;
			String gender;
			
			System.out.println(list.getLength());
			for(int i=0;i<list.getLength();i++) {
				
				Node node=list.item(i);
				
				
			
				if(node.getNodeType()==Node.ELEMENT_NODE) {
					
					Element element1=(Element) node;
					
					
					
					UserNameFromXml=element1.getElementsByTagName("userName").item(0).getTextContent();
					PasswordFromXml=element1.getElementsByTagName("password").item(0).getTextContent();
					balance=element1.getElementsByTagName("balance").item(0).getTextContent();
					email=element1.getElementsByTagName("Email").item(0).getTextContent();
					gender=element1.getElementsByTagName("gender").item(0).getTextContent();
					
					double balance2=Double.parseDouble(balance);
					
					Account a=new Account(balance2,UserNameFromXml,PasswordFromXml,email,gender);
					
					System.out.println(a.getAccName());
					
					//if(a==null) break;
					acc.add(a);
					
					
					/*System.out.println("Account id:"+element1.getAttribute("id"));
					System.out.println("userName:"+element1.getElementsByTagName("userName").item(0).getTextContent());
					System.out.println("email:"+element1.getElementsByTagName("Email").item(0).getTextContent());
					System.out.println("password:"+element1.getElementsByTagName("password").item(0).getTextContent());
					System.out.println("gender:"+element1.getElementsByTagName("gender").item(0).getTextContent());
					
					System.out.println();*/
					
					
					/*if(UserNameFromXml.equals(userName)&&PasswordFromXml.equals(password)&&password.length()!=0&&userName.length()!=0) {
						
						return true;
						
					}*/
					
					
					
					
				}
				
				
			}
			
			
				
			return true;
					
			
		}
			
		public boolean matchPassword(String password) {
			
			
			
			String PasswordFromXml;
			
		
			for(int i=0;i<list.getLength();i++) {
				
				Node node=list.item(i);
				
				
			
				if(node.getNodeType()==Node.ELEMENT_NODE) {
					
					Element element1=(Element) node;
					
					
					
					
					PasswordFromXml=element1.getElementsByTagName("password").item(0).getTextContent();
					
					
					
					
					
					
					if(PasswordFromXml.equals(password)&&password.length()!=0) {
						
						return true;
						
					}
					
					
					
					
				}
				
			
			}
			return false;
		
		}
		
		
		
		public boolean matchUserName(String userName) {
			
			
			
			String UserNameFromXml;
			
		
			for(int i=0;i<list.getLength();i++) {
				
				Node node=list.item(i);
				
				
			
				if(node.getNodeType()==Node.ELEMENT_NODE) {
					
					Element element1=(Element) node;
					
					
					
					
					UserNameFromXml=element1.getElementsByTagName("userName").item(0).getTextContent();
					
					
					System.out.println(UserNameFromXml);
					
					
					
					if(UserNameFromXml.equals(userName)&&userName.length()!=0) {
						
						return true;
						
					}
					
					
					
					
				}
				
			
			}
			return false;
		
		}
		
		
		
		public boolean updateXml(String userName,String password,String balance) throws ParserConfigurationException, SAXException, IOException, TransformerException {
			
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document du=db.parse(new File("azaz.xml"));
			
			 element= du.getDocumentElement();
			 
			
				
				list=element.getChildNodes();
				String UserNameFromXml;
				String PasswordFromXml;
				String balanceFromXml;
				String email;
				String gender;
				
				System.out.println(list.getLength());
				for(int i=0;i<list.getLength();i++) {
					
					Node node=list.item(i);
					
					
				
					if(node.getNodeType()==Node.ELEMENT_NODE) {
						
						Element element1=(Element) node;
						
						UserNameFromXml=element1.getElementsByTagName("userName").item(0).getTextContent();
						PasswordFromXml=element1.getElementsByTagName("password").item(0).getTextContent();
						balanceFromXml=element1.getElementsByTagName("balance").item(0).getTextContent();
						email=element1.getElementsByTagName("Email").item(0).getTextContent();
						gender=element1.getElementsByTagName("gender").item(0).getTextContent();
						
						if(UserNameFromXml.equals(userName)&&PasswordFromXml.equals(password)) {
							
							element1.getElementsByTagName("balance").item(0).setTextContent(balance);
							

							TransformerFactory transformerFactory = TransformerFactory.newInstance();
				            Transformer transformer = transformerFactory.newTransformer();
				            DOMSource source = new DOMSource(du);
				            StreamResult result = new StreamResult(new File("azaz.xml"));
				            transformer.transform(source, result);
							
							return true;
						}
						
						
					
						
						
					}
				}
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(du);
	            StreamResult result = new StreamResult(new File("azaz.xml"));
	            transformer.transform(source, result);
		
			return false;
		}

}
