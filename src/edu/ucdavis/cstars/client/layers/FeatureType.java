package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.JSObject;

/**
 * A type defined by a feature layer. 
 * 
 * @author Justin Merz
 */
public class FeatureType extends JavaScriptObject {

	protected FeatureType() {}
	
	/**
	 * Map of field names to domains. 
	 * 
	 * @return JSObject
	 */
	public final native JSObject domains() /*-{
		return this.domains;
	}-*/;
	
	/**
	 * The feature type identifier.
	 * 
	 * @return int
	 */
	public final native int getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * The feature type name.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;

	/**
	 * Array of feature templates associated with this feature type.
	 * 
	 * @return JsArray<FeatureTemplate>
	 */
	public final native JsArray<FeatureTemplate> templates() /*-{
		return this.templates;
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	
}
