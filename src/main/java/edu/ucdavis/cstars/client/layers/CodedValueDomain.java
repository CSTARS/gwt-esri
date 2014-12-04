package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Information about the coded values belonging to the domain. Coded value domains
 * specify a set of valid values for an attribute. 
 * 
 * @author Justin Merz
 */
public class CodedValueDomain extends Domain {
	
	protected CodedValueDomain() {}
	
	// TODO: find out more about structure of coded values
	/**
	 * An array of the coded values in the domain. Each object consists of two properties: name and code.
	 * 
	 * @return JsArray<JavaScriptObject>
	 */
	public final native JsArray<JavaScriptObject> getCodedValues() /*-{
		return this.codedValues
	}-*/;

}
