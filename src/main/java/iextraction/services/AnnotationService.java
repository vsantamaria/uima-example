package iextraction.services;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASRuntimeException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import iextraction.helpers.AnnotationServiceHelper;

@Service
public class AnnotationService {

	private AnalysisEngine analysisEngine;
	private CAS cas;
	private boolean serviceInitialized = false;

	@Value("${uima.descriptor}")
	private String descriptorPath;

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@PostConstruct
	public void init() {
		if (!serviceInitialized) {
			XMLInputSource conferenceDescriptor;
			try {
				//load aggregate AE
				URL descriptorUrl = AnnotationService.class.getResource(descriptorPath);
				conferenceDescriptor = new XMLInputSource(descriptorUrl);
				ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(conferenceDescriptor);
				
				// create Analysis Engine here
				analysisEngine = UIMAFramework.produceAnalysisEngine(specifier);
				cas = analysisEngine.newCAS();
				serviceInitialized = true;
			} catch (IOException | InvalidXMLException | ResourceInitializationException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	//annotate document
	//Assumes some other part of a multi-threaded application could call this method on different threads, asynchronously	
	public synchronized String analyzeDocument(MultipartFile document) {
		String text = AnnotationServiceHelper.getTextFromMultipartFile(document);
		StringBuilder result = new StringBuilder();
		try {			
			cas.setDocumentText(text);
			analysisEngine.process(cas);
			AnnotationServiceHelper.appendAnnotationsToResult(result, cas);
			cas.reset();
			
		} catch (AnalysisEngineProcessException | CASRuntimeException e) {
			LOGGER.error(e.getMessage());
		}
		return result.toString();
		
	}

	
	
}
