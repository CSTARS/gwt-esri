package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * TimeReference contains information about how the time was measured. Defines information 
 * about daylight savings time and the time zone in which the data was collected. 
 * 
 * @author Justin Merz
 */
public class TimeReference extends JavaScriptObject {
	
	protected TimeReference() {}
	
	/**
	 * Indicates whether the time reference respects daylight savings time. If true, the time values 
	 * are represented in both the standard time zone and the daylight savings time (when applicable). 
	 * If false, time values are assumed to be in the standard time zone. 
	 * 
	 * @return boolean
	 */
	public final native boolean respectsDaylightSaving() /*-{
		return this.respectsDaylightSaving;
	}-*/;

	/**
	 * The time zone information associated with the time reference.
	 * 
	 * @return String
	 */
	public final native String getTimeZone() /*-{
		return this.timeZone;
	}-*/;


}
