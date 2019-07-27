package updateXml;

import java.io.File;
import java.io.IOException;

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

import registration.Account;

public class MainClass {
	
	public boolean flag;
	public NodeList list;
	Element element;
	public MainClass() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document du=db.parse(new File("data.xml"));
		
		 element= du.getDocumentElement();
		 //NodeList element2=du.getElementsByTagName("userName");
		
			
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
						
					if(UserNameFromXml.equals("rabbi")&&PasswordFromXml.equals("888")) {
						element1.getElementsByTagName("balance").item(0).setTextContent("1000");
					}
					
					
					
					
					
				
					
					
				/*	System.out.println("Account id:"+element1.getAttribute("id"));
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
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(du);
            StreamResult result = new StreamResult(new File("data.xml"));
            transformer.transform(source, result);
	
		
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// TODO Auto-generated method stub
		
		MainClass m=new MainClass();

	}

}
