package ar.edu.itba.it.paw.horoscope.domain.horoscope;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class FileHoroscopeManager implements HoroscopeManager{

	private Map<String, Horoscope> signs = new HashMap<String, Horoscope>();

	public FileHoroscopeManager(String fileName) {
		processSigns(fileName);
	}
	
	public Horoscope getHoroscope(String sign){
		if (signs.containsKey(sign.toUpperCase())) {
			return signs.get(sign.toUpperCase());
		} else {
			return null;
		}
	}
	
	private void processSigns(String fileName){
		try {
			File file = new File(fileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList nodeLst = doc.getElementsByTagName("sign");

			for (int s = 0; s < nodeLst.getLength(); s++) {
				Node node = nodeLst.item(s);
			    if (node.getNodeType() == Node.ELEMENT_NODE) {
			  
			    	Element signNode = (Element) node;
			    	NodeList signNodeNames = signNode.getElementsByTagName("sign-name");
			    	Element nameNode = (Element) signNodeNames.item(0);
			    	NodeList theNames = nameNode.getChildNodes();
		    		NodeList signNodeMsgs = signNode.getElementsByTagName("sign-message");
			    	Element msgNode = (Element) signNodeMsgs.item(0);
			    	NodeList theMsgs = msgNode.getChildNodes();
			    	signs.put(((Node) theNames.item(0)).getNodeValue(), 
			    				new Horoscope (((Node) theNames.item(0)).getNodeValue(), ((Node) theMsgs.item(0)).getNodeValue()));
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
