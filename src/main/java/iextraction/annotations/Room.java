
/* First created by JCasGen Sun Apr 02 23:27:56 CEST 2017 */
package iextraction.annotations;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;

/** 
 * Updated by JCasGen Mon Apr 03 02:46:46 CEST 2017
 * XML source: uima/src/main/resources/desc/room.xml
 * @generated */
public class Room extends Annotation {
	/**
	 * @generated
	 * @ordered
	 */
	@SuppressWarnings("hiding")
	public final static int typeIndexID = JCasRegistry.register(Room.class);
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
	protected Room() {/* intentionally empty block */}
    
	/**
	 * Internal - constructor used by generator
	 * 
	 * @generated
	 * @param addr
	 *            low level Feature Structure reference
	 * @param type
	 *            the type of this Feature Structure
	 */
	public Room(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
	/**
	 * @generated
	 * @param jcas
	 *            JCas to which this Feature Structure belongs
	 */
	public Room(JCas jcas) {
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
	public Room(JCas jcas, int begin, int end) {
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
	// * Feature: building

	/**
	 * getter for building - gets
	 * 
	 * @generated
	 * @return value of the feature
	 */
	public String getBuilding() {
    if (Room_Type.featOkTst && ((Room_Type)jcasType).casFeat_building == null)
      jcasType.jcas.throwFeatMissing("building", "iextraction.annotations.Room");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Room_Type)jcasType).casFeatCode_building);}
    
	/**
	 * setter for building - sets
	 * 
	 * @generated
	 * @param v
	 *            value to set into the feature
	 */
	public void setBuilding(String v) {
    if (Room_Type.featOkTst && ((Room_Type)jcasType).casFeat_building == null)
      jcasType.jcas.throwFeatMissing("building", "iextraction.annotations.Room");
    jcasType.ll_cas.ll_setStringValue(addr, ((Room_Type)jcasType).casFeatCode_building, v);}    
  }
