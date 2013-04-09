package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * Date used in geoprocessing.
 * 
 * @author Justin Merz
 */
public class Date extends JavaScriptObject {
	
	protected Date () {}
	
	/**
	 * Creates a new Date object. 
	 * 
	 * @return Date
	 */
	public static native Date create() /*-{
		return new $wnd.esri.tasks.create();
	}-*/;
	
	/**
	 * Date value returned from server.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getDate() /*-{
		return this.date;
	}-*/;
	
	/**
	 * The format of the date used in the date property. The format is EEE MMM dd HH:mm:ss zzz yyyy.
	 * For example, Mon Apr 28 13:31:28 PDT 2008.
	 * 
	 * @return String
	 */
	public final native String getFormat() /*-{
		return this.format;
	}-*/;

}
