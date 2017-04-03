package iextraction.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import iextraction.annotations.Room;

public class RoomAnnotator extends JCasAnnotator_ImplBase {

	private Pattern[] roomPatterns;

	private String[] locations;

	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);

		// Get config. parameter values
		String[] roomRegexes = (String[]) aContext.getConfigParameterValue("Patterns");
		locations = (String[]) aContext.getConfigParameterValue("Locations");

		// compile patternStrings
		roomPatterns = new Pattern[roomRegexes.length];
		for (int i = 0; i < roomRegexes.length; i++) {
			roomPatterns[i] = Pattern.compile(roomRegexes[i]);
		}
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {

		String document = aJCas.getDocumentText();
		for (int i = 0; i < roomPatterns.length; i++) {
			Pattern pattern = roomPatterns[i];
			Matcher matcher = pattern.matcher(document);
			while (matcher.find()) {
				Room annotation = new Room(aJCas);
				annotation.setBegin(matcher.start());
				annotation.setEnd(matcher.end());
				annotation.setBuilding(locations[i]);
				annotation.addToIndexes(aJCas);
			}

		}
	}

}
