package iextraction.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import iextraction.annotations.Date;

public class DateAnnotator extends JCasAnnotator_ImplBase {

	String monthRegex = "(January|February|March|April|May|June|July|August|September|October|November|December)";
	String dayRegex = "(0?[1-9]|[12]\\d|3[01])";
	String yearRegex = "2\\d{3}";

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		String document = aJCas.getDocumentText();
		
		//find occurrences of pattern: month day, year (eg. August 26, 2003)
		String dateRegex =  "\\b" + monthRegex + "\\s+" + dayRegex + "[^a-z]?\\s+" + yearRegex + "\\b";
		Pattern datePattern = Pattern.compile(dateRegex);
		Matcher dateMatcher = datePattern.matcher(document);
		while (dateMatcher.find()) {		
			//create the Date annotation
			Date dateAnnot = new Date(aJCas);
			dateAnnot.setBegin(dateMatcher.start());
			dateAnnot.setEnd(dateMatcher.end());
			dateAnnot.addToIndexes();
		}
	}

	
	/*
	 * UIMA Summer School
	 * 
	 * August 26, 2003 UIMA 101 - The New UIMA Introduction (Hands-on Tutorial)
	 * 9:00AM-5:00PM in HAW GN-K35
	 * 
	 * August 28, 2003 FROST Tutorial 9:00AM-5:00PM in HAW GN-K35
	 * 
	 * September 15, 2003 UIMA 201: UIMA Advanced Topics (Hands-on Tutorial)
	 * 9:00AM-5:00PM in HAW 1S-F53
	 * 
	 * September 17, 2003 The UIMA System Integration Test and Hardening Service
	 * The "SITH" 3:00PM-4:30PM in HAW GN-K35
	 * 
	 */	
}
