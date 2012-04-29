package parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MainSAX {
	public static void main(String[] args){
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		parserFactory.setNamespaceAware(true);
		parserFactory.setValidating(true);
		try {
			SAXParser parser = parserFactory.newSAXParser();
			DefaultHandler handler = new ParserFormulaire();
			parser.parse("src/dataSources/formulaire.xml", handler);
			
			((ParserFormulaire)handler).afficher();
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
