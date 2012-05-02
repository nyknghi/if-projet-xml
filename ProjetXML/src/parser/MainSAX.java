package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
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
			
			String filepath, filepath2;
			Document doc, doc2;
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
				filepath2="src/dataSources/activite.xml";
				doc = db.parse(filepath);
				doc2 = db.parse(filepath2);
				traiter = new Traiter(((ParserFormulaire)handler).getParticipation());
				traiter.setServiceDoc(doc);
				traiter.setActiviteDoc(doc2);
				traiter.commenter();
				// write the content into xml file
				TransformerFactory transformerFactory2 = TransformerFactory.newInstance();
				Transformer transformer2 = transformerFactory2.newTransformer();				
				transformer2.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,"../grammaire/activite.dtd");
				DOMSource source2 = new DOMSource(doc2);
				StreamResult result2 = new StreamResult(new File(filepath2));
				transformer2.transform(source2, result2);					
				break;		
			case "noter" :
				filepath="src/dataSources/service.xml";
				filepath2="src/dataSources/activite.xml";
				doc = db.parse(filepath);
				doc2 = db.parse(filepath2);
				traiter = new Traiter(((ParserFormulaire)handler).getParticipation());
				traiter.setServiceDoc(doc);
				traiter.setActiviteDoc(doc2);
				traiter.noter();
				// write the content into xml file
				transformerFactory2 = TransformerFactory.newInstance();
				transformer2 = transformerFactory2.newTransformer();				
				transformer2.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,"../grammaire/activite.dtd");
				source2 = new DOMSource(doc2);
				result2 = new StreamResult(new File(filepath2));
				transformer2.transform(source2, result2);				
				break;		
			case "rechercher" :
				File xmlFile = new File("src/dataSources/listeFile.xml");
				File xsltFile = new File("src/dataSources/XSL_ResultatRecherche.xsl");
				FileOutputStream sortie;
				try {
					sortie = new FileOutputStream("src/webContent/resultatRecherche.xml");
					ParserXSLT.parser(xmlFile, xsltFile, sortie);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}	
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
