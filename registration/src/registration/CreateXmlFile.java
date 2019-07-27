package registration;



import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXmlFile {
	
	public CreateXmlFile(String accNum,String firstName,String lastName,String UserName,String Email,String password,String balance,String gender) throws Exception  {
		
		String[] elementValue= {firstName,lastName,UserName,Email,password,balance,gender};
		String[] elementName= {"firstNmae","lastName","userName","Email","password","balance","gender"};
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		
		Document document=db.parse(new File("azaz.xml"));
		
		Element element=document.getDocumentElement();
		
		
		
		Element account=document.createElement("Account");
		element.appendChild(account);
		
		Attr attr=document.createAttribute("id");
		attr.setValue(accNum);
		account.setAttributeNode(attr);
		
		for(int i=0;i<elementValue.length;i++) {
			
			Element elmt=createNewElement(document,elementName[i],elementValue[i]);
			account.appendChild(elmt);
			
		}
		
		element.appendChild(account);
		
		
		
		
		
		
		/*Element element2=document.createElement("userName");
		element2.appendChild(document.createTextNode(UserName));
		element.appendChild(element2);
		
		Element element3=document.createElement("Email");
		element3.appendChild(document.createTextNode(Email));
		element.appendChild(element3);
		
		Element element4=document.createElement("password");
		element4.appendChild(document.createTextNode(password));
		element.appendChild(element4);
		
		Element element5=document.createElement("gender");
		element5.appendChild(document.createTextNode(gender));
		element.appendChild(element5);*/
		
		addNewAttribute(document);
		
		
		
		
	}
	public CreateXmlFile() {
		
	}
	
	private Element createNewElement(Document document,String elementName,String elementValue) {
		
		Element element=document.createElement(elementName);
		
		element.setTextContent(elementValue);
		
		return element;
	}
	
	private void addNewAttribute(Document document) throws TransformerException {
		
		
		TransformerFactory tf=TransformerFactory.newInstance();
		
		Transformer transfer=tf.newTransformer();
		
		DOMSource source=new DOMSource(document);
		StreamResult sr=new StreamResult(new File("azaz.xml"));
		
		transfer.setOutputProperty(OutputKeys.INDENT, "yes");
		transfer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
		
		transfer.transform(source,sr);
		
		
	}
	
	
	

}
