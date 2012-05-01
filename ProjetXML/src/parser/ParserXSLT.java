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

	public static void parser(File xmlFile, File xsltFile, FileOutputStream sortie){
		Source xmlSource = new StreamSource(xmlFile);
		Source xsltSource = new StreamSource(xsltFile);
		try {
			Result result = new StreamResult(sortie);
			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer trans;
			trans = transFact.newTransformer(xsltSource);
			trans.transform(xmlSource, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		File xmlFile = new File("src/dataSources/listeFile.xml");
		File xsltFile = new File("src/dataSources/XSL_ResultatRecherche.xsl");
		//File xsltFile = new File("src/dataSources/XSL_ListeActivites.xsl");
		FileOutputStream sortie;
		try {
			sortie = new FileOutputStream("src/webContent/resultatRecherche.xml");
			ParserXSLT.parser(xmlFile, xsltFile, sortie);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
