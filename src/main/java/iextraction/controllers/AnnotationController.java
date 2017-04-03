package iextraction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import iextraction.services.AnnotationService;


@RestController
public class AnnotationController {
	
	@Autowired
	AnnotationService annotationService;
	
	@RequestMapping(value="/annotate", method=RequestMethod.POST)
	public String process(@RequestParam(value="document", required=true) MultipartFile file) {
		annotationService.init();
		String result = annotationService.analyzeDocument(file);
		return result;
	}

}
