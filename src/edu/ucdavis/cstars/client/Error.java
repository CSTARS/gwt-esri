package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Error Object returned when error is thrown.  Think this is what we need here:
 * https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Error
 * 
 * @author Justin Merz
 */
public class Error extends JavaScriptObject {

	protected Error() {}
	
	public final native String getMessage() /*-{
		if( this.message ) return this.message;
		return "";
	}-*/;
	
	public final native String getName() /*-{
		if( this.name ) return this.name;
		return "";
	}-*/;
	
	public final native int getCode() /*-{
		if( this.code != null ) return this.code;
		return -1;
	}-*/;
	
	public final native JsArrayString getDetails() /*-{
		if( this.details ) return details;
		return [];
	}-*/;
	
	// there are other methods which are non-standard, leaving them out for now
	
}
