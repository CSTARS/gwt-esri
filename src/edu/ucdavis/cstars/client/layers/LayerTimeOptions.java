package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.layers.TimeInfo.TimeUnits;

/**
 * Defines the time options for the layer. 
 * 
 * @author Justin Merz
 */
public class LayerTimeOptions extends JavaScriptObject {
	
	protected LayerTimeOptions() {}
	
	/**
	 * If true, the layer will draw all features from the beginning of the data's time extent.
	 * 
	 * @return boolean
	 */
	public final native boolean getTimeDataCumulative() /*-{
		return this.timeDataCumulative;
	}-*/;
	
	/**
	 * Set the timeDataCumulative parameter.
	 * 
	 * @param timeDataCumulative -If true, the layer will draw all features from the beginning of the data's time extent.
	 */
	public final native void setTimeDataCumulative(boolean timeDataCumulative) /*-{
		this.timeDataCumulative = timeDataCumulative;
	}-*/;
	
	/**
	 * The length of time the data is offset from the time when the data was recorded. 
	 * Specify the units using the timeOffsetUnits property.
	 * 
	 * @return int
	 */
	public final native int getTimeOffset() /*-{
		return this.timeOffset;
	}-*/;
	
	/**
	 * Set the timeOffset parameter.
	 * 
	 * @param timeOffset - The length of time the data is offset from the time when the data was recorded. 
	 * Specify the units using the timeOffsetUnits property.
	 */
	public final native void setTimeOffset(int timeOffset) /*-{
		this.timeOffset = timeOffset;
	}-*/;
	
	/**
	 * Temporal unit in which the time offset is measured.
	 * 
	 * @return TimeUnits
	 */
	public final TimeUnits getTimeOffsetUnits() {
		String ou = _getTimeOffsetUnits();
		for( int i = 0 ; i < TimeUnits.values().length; i++ ){
			if( TimeUnits.values()[i].getValue().contentEquals(ou) )
				return TimeUnits.values()[i];
		}
		return TimeUnits.NOT_SET;
	}
	
	private final native String _getTimeOffsetUnits() /*-{
		return this.timeOffsetUnit;
	}-*/;
	
	/**
	 * Set the timeOffsetUnits parameter.
	 * 
	 * @param timeOffsetUnits - Temporal unit in which the time offset is measured.
	 */
	public final void setTimeOffsetUnit(TimeUnits timeOffsetUnits) {
		_setTimeOffsetUnits( timeOffsetUnits.getValue() );
	}
	
	private final native void _setTimeOffsetUnits(String timeOffsetUnits) /*-{
		this.timeOffsetUnits = timeOffsetUnits;
	}-*/;

	/**
	 * If true, the layer participates in time-related rendering and query operations.
	 * 
	 * @return boolean
	 */
	public final native boolean useTime() /*-{
		return this.useTime;
	}-*/;
	
	/**
	 * Set the useTime parameter.
	 * 
	 * @param useTime - If true, the layer participates in time-related rendering and query operations.
	 */
	public final native void setUseTime(boolean useTime) /*-{
		this.useTime = useTime;
	}-*/;
	
}
