package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ParserXSLT {

	public static void main(String[] args) {
		File xmlFile = new File("src/dataSources/listeFile.xml");
		File xsltFile = new File("src/dataSources/XSL_ListeUtilisateurs.xsl");
		//File xsltFile = new File("src/dataSources/XSL_ListeActivites.xsl");
		
		Source xmlSource = new StreamSource(xmlFile);
		Source xsltSource = new StreamSource(xsltFile);
		FileOutputStream sortie;
		
		try {
			sortie = new FileOutputStream("src/webContent/listeUtilisateurs.xml");
			Result result = new StreamResult(sortie);
			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer trans;
			trans = transFact.newTransformer(xsltSource);
			trans.transform(xmlSource, result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
