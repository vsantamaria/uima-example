
/* First created by JCasGen Mon Apr 03 17:22:17 CEST 2017 */
package iextraction.annotations;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;
import org.apache.uima.jcas.tcas.Annotation;

/** 
 * Updated by JCasGen Mon Apr 03 18:09:10 CEST 2017
 * XML source: uima/src/main/resources/desc/conference.xml
 * @generated */
public class Conference extends Annotation {
	/**
	 * @generated
	 * @ordered
	 */
	@SuppressWarnings("hiding")
	public final static int typeIndexID = JCasRegistry.register(Conference.class);
	/**
	 * @generated
	 * @ordered
	 */
	@SuppressWarnings("hiding")
	public final static int type = typeIndexID;

	/**
	 * @generated
	 * @return index of the type
	 */
	@Override
	public int getTypeIndexID() {return typeIndexID;}
 
	/**
	 * Never called. Disable default constructor
	 * 
	 * @generated
	 */
	protected Conference() {/* intentionally empty block */}
    
	/**
	 * Internal - constructor used by generator
	 * 
	 * @generated
	 * @param addr
	 *            low level Feature Structure reference
	 * @param type
	 *            the type of this Feature Structure
	 */
	public Conference(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
	/**
	 * @generated
	 * @param jcas
	 *            JCas to which this Feature Structure belongs
	 */
	public Conference(JCas jcas) {
    super(jcas);
    readObject();   
  } 

	/**
	 * @generated
	 * @param jcas
	 *            JCas to which this Feature Structure belongs
	 * @param begin
	 *            offset to the begin spot in the SofA
	 * @param end
	 *            offset to the end spot in the SofA
	 */
	public Conference(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

	/**
	 * <!-- begin-user-doc --> Write your own initialization here <!--
	 * end-user-doc -->
	 *
	 * @generated modifiable
	 */
	private void readObject() {
		/* default - does nothing empty block */}

	// *--------------*
	// * Feature: room

	/**
	 * getter for room - gets
	 * 
	 * @generated
	 * @return value of the feature
	 */
	public String getRoom() {
    if (Conference_Type.featOkTst && ((Conference_Type)jcasType).casFeat_room == null)
      jcasType.jcas.throwFeatMissing("room", "iextraction.annotations.Conference");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Conference_Type)jcasType).casFeatCode_room);}
    
	/**
	 * setter for room - sets
	 * 
	 * @generated
	 * @param v
	 *            value to set into the feature
	 */
	public void setRoom(String v) {
    if (Conference_Type.featOkTst && ((Conference_Type)jcasType).casFeat_room == null)
      jcasType.jcas.throwFeatMissing("room", "iextraction.annotations.Conference");
    jcasType.ll_cas.ll_setStringValue(addr, ((Conference_Type)jcasType).casFeatCode_room, v);}    
   
    
	// *--------------*
	// * Feature: date

	/**
	 * getter for date - gets
	 * 
	 * @generated
	 * @return value of the feature
	 */
	public String getDate() {
    if (Conference_Type.featOkTst && ((Conference_Type)jcasType).casFeat_date == null)
      jcasType.jcas.throwFeatMissing("date", "iextraction.annotations.Conference");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Conference_Type)jcasType).casFeatCode_date);}
    
	/**
	 * setter for date - sets
	 * 
	 * @generated
	 * @param v
	 *            value to set into the feature
	 */
	public void setDate(String v) {
    if (Conference_Type.featOkTst && ((Conference_Type)jcasType).casFeat_date == null)
      jcasType.jcas.throwFeatMissing("date", "iextraction.annotations.Conference");
    jcasType.ll_cas.ll_setStringValue(addr, ((Conference_Type)jcasType).casFeatCode_date, v);}    
   
    
	// *--------------*
	// * Feature: title

	/**
	 * getter for title - gets
	 * 
	 * @generated
	 * @return value of the feature
	 */
	public String getTitle() {
    if (Conference_Type.featOkTst && ((Conference_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "iextraction.annotations.Conference");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Conference_Type)jcasType).casFeatCode_title);}
    
	/**
	 * setter for title - sets
	 * 
	 * @generated
	 * @param v
	 *            value to set into the feature
	 */
	public void setTitle(String v) {
    if (Conference_Type.featOkTst && ((Conference_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "iextraction.annotations.Conference");
    jcasType.ll_cas.ll_setStringValue(addr, ((Conference_Type)jcasType).casFeatCode_title, v);}    
  	// additional constructor
	public Conference(JCas jcas, int begin, int end, String title, String room, String date) {
		this(jcas, begin, end);
		this.setTitle(title);
		this.setRoom(room);
		this.setDate(date);
		readObject();
	}

}