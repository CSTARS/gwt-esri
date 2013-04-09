package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.TimeExtent;

/**
 * Time information details. 
 * 
 * @author Justin Merz
 */
public class TimeInfo extends JavaScriptObject {
	
	public static enum TimeUnits {
		NOT_SET(""),
		UNIT_CENTURIES("esriTimeUnitsCenturies"),
		UNIT_DAYS("esriTimeUnitsDays"),
		UNIT_DECADES("esriTimeUnitsDecades"),
		UNIT_HOURS("esriTimeUnitsHours"),
		UNIT_MILLISECONDS("esriTimeUnitsMilliseconds"),
		UNIT_MINUTES("esriTimeUnitsMinutes"),
		UNIT_MONTHS("esriTimeUnitsMonths"),
		UNIT_SECONDS("esriTimeUnitsSeconds"),
		UNIT_UNKNOWN("esriTimeUnitsUnknown"),
		UNIT_WEEKS("esriTimeUnitsWeeks"),
		UNIT_YEARS("esriTimeUnitsYears");
		private String val;
		private TimeUnits(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected TimeInfo() {}
	
	/**
	 * The name of the attribute field that contains the end time information.
	 * 
	 * @return String
	 */
	public final native String getEndTimeField() /*-{
		return this.endTimeField;
	}-*/;
	
	/**
	 * Default time-related export options for the layer. When using a dynamic
	 * map service, these options can be overriden for sub-layers using the setLayerTimeOptions method.
	 * 
	 * @return LayerTimeOptions
	 */
	public final native LayerTimeOptions getExportOptions() /*-{
		return this.exportOptions;
	 }-*/;
	
	/**
	 * The name of the attribute field that contains the start time information.
	 * 
	 * @return String
	 */
	public final native String getStartTimeField() /*-{
		return this.startTimeField;
	}-*/;
	
	/**
	 * The time extent for all the data in the layer.
	 * 
	 * @return TimeExtent
	 */
	public final native TimeExtent getTimeExtent() /*-{
		return this.timeExtent;
	}-*/;
	
	/**
	 * Time interval of the data in the layer. Typically used for the TimeSlider when animating the layer.
	 * 
	 * @return int
	 */
	public final native int getTimeInterval() /*-{
		return this.timeInterval;
	}-*/;
	
	/**
	 * Temporal unit in which the time interval is measured. See the Constants table for valid values.
	 * 
	 * @return String
	 */
	public final native String getTimeIntervalUnits() /*-{
		return this.timeIntervalUnits;
	}-*/;
	
	/**
	 * Information about how the time was measured.
	 * 
	 * @return TimeReference;
	 */
	public final native TimeReference getTimeReference() /*-{
		return this.timeReference;
	}-*/;

	/**
	 * The field that contains the trackId.
	 * 
	 * @return - String
	 */
	public final native String getTrackIdField() /*-{
		return this.trackIdField;
	}-*/;

}
