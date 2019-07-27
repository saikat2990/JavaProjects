package client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
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
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class WriteXml {
	
	
	
	//static String infoData[][];
	
	
	private static void writeProductsXML(String infoData[][],int personNum) throws TransformerException {
	    
		int element;
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			infoData = new String [100][100];
			//infoData[0][0]="rabbi";
			//infoData[0][1]= "123";
			//infoData[0][2]="2000";
			Element root = doc.createElement("UserList");
			personNum=1;
			for(int i=0;i<personNum;i++) {
				
				
				Element user = doc.createElement("user");
				
				Element username = doc.createElement("username");
				Text name = doc.createTextNode(infoData[i][0]);
				username.appendChild(name);
				
				Element password = doc.createElement("userPassword");
				Text pass = doc.createTextNode(infoData[i][1]);
				password.appendChild(pass);
				
				Element balance = doc.createElement("Balance");
				Text bal = doc.createTextNode(infoData[i][2]);
				balance.appendChild(bal);
				
				user.appendChild(username);
				user.appendChild(password);
				user.appendChild(balance);	
				root.appendChild(user);
			}
			//doc.appendChild(root);

			
			doc.appendChild(root);
			
			DOMSource source = new DOMSource(doc);
			File f = new File("file.xml");
			Result result = new StreamResult(f);
			
			  TransformerFactory transformerFactory = TransformerFactory.newInstance();
			  Transformer transformer = transformerFactory.newTransformer();
			  transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			  transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			  //transformer.transform(source, result);
			  
			  
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public static void main(String argv[]) throws TransformerException {
		    Read rd = new Read();
			String info[][] = rd.read();
			int personNum = rd.getperson();
			 writeProductsXML(info,personNum);

	}
}
