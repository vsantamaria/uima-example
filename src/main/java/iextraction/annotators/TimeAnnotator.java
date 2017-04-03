package iextraction.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import iextraction.annotations.Time;

public class TimeAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		String document = aJCas.getDocumentText();
		//find occurrences of d?d:dd +no whitespace characters until AM or PM (eg 9:00AM-5:00PM)
		String timeRegex = "([1-9]|1[012]):[0-5]\\d[^\\s]+[AP]M";
		Pattern pattern = Pattern.compile(timeRegex);
		Matcher matcher = pattern.matcher(document);
		while(matcher.find()) {
			//create the Time annotation
			Time annotation = new Time(aJCas);
			annotation.setBegin(matcher.start());
			annotation.setEnd(matcher.end());
			annotation.addToIndexes();
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
