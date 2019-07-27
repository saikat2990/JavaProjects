package Client;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class readXml {
	
	
	
	public boolean flag;
	public NodeList list;
	
	
	public readXml() throws ParserConfigurationException, SAXException, IOException {
		
		
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document du=db.parse(new File("azaz.xml"));
		
		Element element= du.getDocumentElement();
		
		list=element.getChildNodes();
		
		
		//System.out.println("list:"+list);
		
	}
		
	

	public boolean	checkUserNameandPassword(String password,String userName){
			
			String UserNameFromXml;
			String PasswordFromXml;
			
		
			for(int i=0;i<list.getLength();i++) {
				
				Node node=list.item(i);
				
				
			
				if(node.getNodeType()==Node.ELEMENT_NODE) {
					
					Element element1=(Element) node;
					
					
					
					UserNameFromXml=element1.getElementsByTagName("userName").item(0).getTextContent();
					PasswordFromXml=element1.getElementsByTagName("password").item(0).getTextContent();
					
					
					System.out.println("Account id:"+element1.getAttribute("id"));
					System.out.println("userName:"+element1.getElementsByTagName("userName").item(0).getTextContent());
					System.out.println("email:"+element1.getElementsByTagName("Email").item(0).getTextContent());
					System.out.println("password:"+element1.getElementsByTagName("password").item(0).getTextContent());
					System.out.println("gender:"+element1.getElementsByTagName("gender").item(0).getTextContent());
					
					System.out.println();
					
					
					if(UserNameFromXml.equals(userName)&&PasswordFromXml.equals(password)&&password.length()!=0&&userName.length()!=0) {
						
						return true;
						
					}
					
					
					
					
				}
				
				
			}
			
			
				
			return false;
					
			
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


}
