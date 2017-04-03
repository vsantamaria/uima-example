package iextraction.annotators;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class DateTimeAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {

		//call Date and Time annotators process method to generate Date and Time annots
		DateAnnotator dateAnnotator = new DateAnnotator();
		dateAnnotator.process(aJCas);
		TimeAnnotator timeAnnotator = new TimeAnnotator();
		timeAnnotator.process(aJCas);
	}

}
