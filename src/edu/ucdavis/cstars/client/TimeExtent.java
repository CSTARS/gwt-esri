package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * Represents the period in time within which the data was collected. 
 * 
 * @author Justin Merz
 */
public class TimeExtent extends JavaScriptObject {
	
	protected TimeExtent() {}
	
	/**
	 * Creates a new TimeExtent object with the specifed start and end time. If the startTime is null or undefined the start 
	 * time is negative infinity. If the endTime is null or undefined the endTime is positive infinity. To represent an instant
	 * in time set the startTime and endTime to the same time value.
	 * 
	 * @param startTime - The start time for the specified time extent. 
	 * @param endTime - The end time for the specified time extent. 
	 * @return TimeExtent
	 */
	public static native TimeExtent create( JsDate startTime, JsDate endTime ) /*-{
		return new $wnd.esri.TimeExtent( startTime, endTime ); 
	}-*/;
	
	
	
	/**
	 * Get the start time for the specified time extent.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getStartTime() /*-{
		return this.startTime;
	}-*/;
	
	/**
	 * Set the start time for this time extent
	 * 
	 * @param startTime - The start time for the specified time extent. 
	 */
	public final native void setStartTime(JsDate startTime) /*-{
		this.startTime = startTime;
	}-*/;
	
	/**
	 * Get the end time for the specified time extent.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getEndTime() /*-{
		return this.endTime;
	}-*/;
	
	/**
	 * Set the end time for this time extent
	 * 
	 * @param endTime - The end time for the specified time extent. 
	 */
	public final native void setEndTime(JsDate endTime) /*-{
		this.endTime = endTime;
	}-*/;	
	
	/**
	 * Returns a new time extent indicating the intersection between "this" and the
	 *  argument time extent.
	 * 
	 * @param extent - The input time extent.
	 * @return TimeExtent
	 */
	public final native TimeExtent intersection(TimeExtent extent) /*-{
		return this.intersection(extent);
	}-*/;
	
	/**
	 * Returns a new time extent with the given offset from "this' time extent.
	 * 
	 * @param offsetValue - The length of time to offset from "this" time extent.
	 * @param offsetUnits - The offset units, see the TimeInfo constants for a list of valid values.
	 * @return TimeExtent
	 */
	public final native TimeExtent offset(int offsetValue, String offsetUnits) /*-{
		return this.offset(offsetValue, offsetUnits);
	}-*/;
	
}
