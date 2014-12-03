package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class added v2.6.
 * Define the classification definition and optional where clause for the GenerateRendererTask operation.
 * 
 * @author Justin Merz
 */
public class GenerateRendererParameters extends JavaScriptObject {

	protected GenerateRendererParameters() {}
	
	/**
	 * Creates a new GenerateRendererParameters object.
	 * 
	 * @return GenerateRendererParameters
	 */
	public static native GenerateRendererParameters create() /*-{
		return new $wnd.esri.tasks.GenerateRendererParameters();
	}-*/;
	
	/**
	 * A ClassBreaksDefinition or UniqueValueDefinition classification definition used to generate the data classes.
	 * 
	 * @return ClassificationDefinition
	 */
	public final native ClassificationDefinition getClassificationDefinition() /*-{
		return this.classificationDefinition;
	}-*/;
	
	/**
	 * set the classificationDefinition parameter.
	 * 
	 * @param classificationDefinition - A ClassBreaksDefinition or UniqueValueDefinition classification definition 
	 * used to generate the data classes.
	 */
	public final native void setClassificationDefinition(ClassificationDefinition classificationDefinition) /*-{
		this.classificationDefinition = classificationDefinition;
	}-*/;
	
	/**
	 * A where clause used to generate the data classes. Any legal SQL where clause operating on the fields in the 
	 * layer/table is allowed.
	 * 
	 * @return String
	 */
	public final native String getWhere() /*-{
		return this.where;
	}-*/;
	
	/**
	 * Set the where parameter.
	 * 
	 * @param where - A where clause used to generate the data classes. Any legal SQL where clause operating on the 
	 * fields in the layer/table is allowed.
	 */
	public final native void setWhere(String where) /*-{
		this.where = where;
	}-*/;
	
}
