package parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MainSAX {
	public static void main(String[] args){
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		parserFactory.setNamespaceAware(true);
		parserFactory.setValidating(true);
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			SAXParser parser = parserFactory.newSAXParser();
			DefaultHandler handler = new ParserFormulaire();
			parser.parse("src/dataSources/formulaire.xml", handler);
			
			((ParserFormulaire)handler).afficher();
			
			String filepath;
			Document doc;
			Traiter traiter;
			switch (((ParserFormulaire)handler).getTypeAction()) {
			case "inscrire" :
				filepath="src/dataSources/utilisateur.xml";
				doc = db.parse(filepath);
				traiter = new Traiter(((ParserFormulaire)handler).getParticipation());
				traiter.setUtilisateurDoc(doc);
				traiter.inscrire();				
				break;
			case "desinscrire" :
				filepath="src/dataSources/utilisateur.xml";
				doc = db.parse(filepath);
				traiter = new Traiter(((ParserFormulaire)handler).getParticipation());
				traiter.setUtilisateurDoc(doc);
				traiter.desinscrire();				
				break;			
			case "commenter" :
				filepath="src/dataSources/service.xml";
				doc = db.parse(filepath);
				traiter = new Traiter(((ParserFormulaire)handler).getParticipation());
				traiter.setServiceDoc(doc);
				traiter.commenter();				
				break;		
			case "noter" :
				filepath="src/dataSources/service.xml";
				doc = db.parse(filepath);
				traiter = new Traiter(((ParserFormulaire)handler).getParticipation());
				traiter.setServiceDoc(doc);
				traiter.noter();				
				break;		
			default:
				filepath="src/dataSources/utilisateur.xml";
				doc = db.parse(filepath);
				traiter = new Traiter(((ParserFormulaire)handler).getParticipation());
				traiter.setUtilisateurDoc(doc);
				traiter.inscrire();						
			}
					
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

			System.out.println("Done");				
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
}
