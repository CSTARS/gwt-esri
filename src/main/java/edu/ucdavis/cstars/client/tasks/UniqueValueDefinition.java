package edu.ucdavis.cstars.client.tasks;

/**
 * Class added v2.6
 * Define a unique value classification scheme used by the GenerateDataTask to generate a renderer that 
 * groups values based on a unique combination of one or more fields. Typically features are rendered 
 * based on the unique values of one attribute field. However up to three fields can be combined to 
 * generate a unique value.
 * 
 * @author Justin Merz
 */
public class UniqueValueDefinition extends ClassificationDefinition {
	
	protected UniqueValueDefinition() {}

	/**
	 * Creates a new UniqueValueDefinition object.
	 * 
	 * @return UniqueValueDefinition
	 */
	public static native UniqueValueDefinition create() /*-{
		return new $wnd.esri.tasks.UniqueValueDefinition();
	}-*/;
	
	/**
	 * The name of the field that contains unique values.
	 * 
	 * @return String
	 */
	public final native String getAttributeField() /*-{
		return this.attributeField
	}-*/;
	
	/**
	 * Set the attributeField parameter.
	 * 
	 * @param attributeField - The name of the field that contains unique values.
	 */
	public final native void setAttributeField(String attributeField) /*-{
		this.attributeField = attributeField;
	}-*/;
	
	/**
	 * The name of the field that contains unique values when combined with the values specified by attributeField.
	 * 
	 * @return String
	 */
	public final native String getAttributeField2() /*-{
		return this.attributeField2
	}-*/;
	
	/**
	 * Set the attributeField2 parameter.
	 * 
	 * @param attributeField2 - The name of the field that contains unique values when combined with the values 
	 * specified by attributeField.
	 */
	public final native void setAttributeField2(String attributeField2) /*-{
		this.attributeField2 = attributeField2;
	}-*/;
	
	/**
	 * The name of the field that contains unique values when combined with the values specified by attributeField and attributeField2.
	 * 
	 * @return String
	 */
	public final native String getAttributeField3() /*-{
		return this.attributeField3
	}-*/;
	
	/**
	 * Set the attributeField3 parameter.
	 * 
	 * @param attributeField3 - The name of the field that contains unique values when combined with the values 
	 * specified by attributeField and attributeField2.
	 */
	public final native void setAttributeField3(String attributeField3) /*-{
		this.attributeField3 = attributeField3;
	}-*/;
	
}
