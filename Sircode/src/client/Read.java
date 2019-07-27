package client;


import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Read {
	
	int namelistNum,personNum;
	public String[][] read() {
		
		
		String infoData[][] = null;
		
		int namelistNum,personNum;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("file.xml");
			NodeList personlist = doc.getElementsByTagName("user");
			infoData = new String [100][100];
			personNum = personlist.getLength();
			for(int i=0;i<personlist.getLength();i++) {
				Node p = personlist.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element person = (Element)p;
					//String id = person.getAttribute("id");
					NodeList nameList = person.getChildNodes();
					namelistNum = nameList.getLength();
					for(int j=0;j<nameList.getLength();j++) {
						Node n = nameList.item(j);
						if(n.getNodeType()==Node.ELEMENT_NODE) {
							Element name = (Element) n;
							infoData[i][j] =name.getTextContent();
							System.out.println(name.getTagName()+" == "+infoData[i][j]);
						}
					}
					
						
					}
				}
			
			
			/*for(int i=0;i<personlist.getLength();i++) {
				for(int j=0;j<4;j++) {
					System.out.print(infoData[i][j]+"  ");
				}
				System.out.println("");
			}*/
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infoData; 
	
	}
	public int getperson() {
		return personNum;
	}

}
