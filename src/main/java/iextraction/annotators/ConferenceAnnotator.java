package iextraction.annotators;

import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import iextraction.annotations.Conference;
import iextraction.annotations.Date;
import iextraction.annotations.Room;
import iextraction.annotations.Time;

public class ConferenceAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {

		// get room, date and time annotations

		FSIndex<Room> roomAnnots = aJCas.getAnnotationIndex(Room.type);
		FSIndex<Date> dateAnnots = aJCas.getAnnotationIndex(Date.type);
		FSIndex<Time> timeAnnots = aJCas.getAnnotationIndex(Time.type);

		// store end position of last conference we identified, to prevent multiple
		// annotations over same span
		int lastConferenceAnnotEnd = -1;

		// iterate over all combinations
		Iterator<Date> dateIter = dateAnnots.iterator();
		while (dateIter.hasNext()) {
			Date date = (Date) dateIter.next();

			Iterator<Time> timeIter = timeAnnots.iterator();
			while (timeIter.hasNext()) {
				Time time = (Time) timeIter.next();

				Iterator<Room> roomIter = roomAnnots.iterator();
				while (roomIter.hasNext()) {
					Room room = (Room) roomIter.next();
					
					// compute the begin and end of the span
					int minBegin = Math.min(time.getBegin(), Math.min(date.getBegin(), room.getBegin()));
					int maxEnd = Math.max(time.getEnd(), Math.max(date.getEnd(), room.getEnd()));

					// span must not overlap the last annotation we made
					if (minBegin > lastConferenceAnnotEnd) {
						
						//find title info
						String textContainingTheTitle = aJCas.getDocumentText().substring(date.getEnd(), time.getBegin()); 
						String title = findTitle(textContainingTheTitle);
						
						// create conference annotation
						String roomValue = room.getBuilding() + " " + room.getCoveredText();
						String dateTime = date.getCoveredText() + " " + time.getCoveredText();
						Conference conference = new Conference(aJCas, minBegin, maxEnd, title, roomValue, dateTime);
						conference.addToIndexes();
						lastConferenceAnnotEnd = maxEnd;
					}
				}
			}
		}
	}

	private String findTitle(String text) {
		String title = "";
		text = text.replaceAll("\\n"," ");
		title = text.replaceAll("^.+( -|:) ", "");
		title = title.replaceAll("\\(.+$", "");
		return title;
		
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
