package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Domains define constraints on a layer field. There are two types of domains, 
 * coded values and range domains. 
 * 
 * @author Justin Merz
 */
public class Domain extends JavaScriptObject {
	
	protected Domain() {}

	/**
	 * The domain name.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * The domain type. Valid values are "range" or "codedValue".
	 * 
	 * @return String
	 */
	public final native String getType() /*-{
		return this.type;
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
