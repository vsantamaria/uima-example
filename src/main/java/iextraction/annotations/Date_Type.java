
/* First created by JCasGen Sun Apr 02 23:30:08 CEST 2017 */
package iextraction.annotations;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Apr 03 15:44:08 CEST 2017
 * @generated */
public class Date_Type extends Annotation_Type {
	/** @generated */
	@SuppressWarnings("hiding")
	public final static int typeIndexID = Date.typeIndexID;
	/**
	 * @generated
	 * @modifiable
	 */
	@SuppressWarnings("hiding")
	public final static boolean featOkTst = JCasRegistry.getFeatOkTst("iextraction.annotations.Date");

	/**
	 * initialize variables to correspond with Cas Type and Features
	 * 
	 * @generated
	 * @param jcas
	 *            JCas
	 * @param casType
	 *            Type
	 */
	public Date_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

  }
}
