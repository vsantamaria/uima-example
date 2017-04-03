package iextraction.helpers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.tcas.Annotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import iextraction.annotations.Conference;

public class AnnotationServiceHelper {

	private static Logger LOGGER = LoggerFactory.getLogger(AnnotationServiceHelper.class);
	

	public static String getTextFromMultipartFile(MultipartFile file) {
		String text = "";
		try {
			ByteArrayInputStream stream = new ByteArrayInputStream(file.getBytes());
			text = IOUtils.toString(stream, "UTF-8");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return text;
	}

	
	
	public static void appendAnnotationsToResult(StringBuilder result, CAS cas) {
		try {
			// append conference annots
			FSIndex<Conference> conferenceAnnots = cas.getJCas().getAnnotationIndex(Conference.type);
			result.append("==== Conferences ==== \n\n");
			for (Conference conference : conferenceAnnots) {
				result.append(conference.getType().getShortName() + "\n");
				result.append("\ttitle: " + conference.getTitle() + "\n");
				result.append("\tdate: " + conference.getDate() + "\n");
				result.append("\troom: " + conference.getRoom() + "\n");
				// result.append("\ttext: \"" + conference.getCoveredText().replaceAll("\\n|\\t", " ") + "\"\n");
				result.append("\n");
			}

			// append document text
			result.append("\n==== Document ==== \n\n");
			result.append(cas.getDocumentText());

			// append all annots
			result.append("\n\n==== Annotations ==== \n\n");
			FSIndex<Annotation> annots = cas.getAnnotationIndex();
			Iterator<Annotation> annotsIter = annots.iterator();
			while (annotsIter.hasNext()) {
				Annotation annot = (Annotation) annotsIter.next();
				StringBuffer sb = new StringBuffer();
				annot.prettyPrint(0, 2, sb, true);
				result.append(sb.toString() + "\n");
			}
		} catch (CASException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
