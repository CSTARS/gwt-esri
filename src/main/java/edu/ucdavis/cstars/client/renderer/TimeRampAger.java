package edu.ucdavis.cstars.client.renderer;

import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Time ramp agers display aging using a gradual change in symbology. A range of colors and symbol sizes can be specified.
 * 
 * @author Justin Merz
 */
public class TimeRampAger extends SymbolAger {
	
	protected TimeRampAger() {}

	/**
	 * Creates a new TimeRampAger object with the specified color and size ranges.
	 * 
	 * @return TimeRampAger
	 */
	public static native TimeRampAger create() /*-{
		return new $wnd.esri.renderer.TimeRampAger();
	}-*/;
	
	/**
	 * Creates a new TimeRampAger object with the specified color and size ranges.
	 * 
	 * @param minColor - Minimum color. Older features will be closer to the minimum value.
	 * @param maxColor - Maximum color. Newer features will be closer to the maximum value.
	 * @param minSize - Minimum size in pixels.  Older features will be closer to the minimum value.
	 * @param maxSize - Maximum size in pixels. Newer features will be closer to the maximum value.
	 * @return TimeRampAger
	 */
	public static native TimeRampAger create( Color minColor, Color maxColor, int minSize, int maxSize ) /*-{
		return new $wnd.esri.renderer.TimeRampAger([minColor, maxColor], [minSize, maxSize]);
	}-*/;
	
	/**
	 * Creates a new TimeRampAger object with the specified color and size ranges.
	 * 
	 * @param minColor - Minimum color. Older features will be closer to the minimum value.
	 * @param maxColor - Maximum color. Newer features will be closer to the maximum value.
	 * @return TimeRampAger
	 */
	public static native TimeRampAger create( Color minColor, Color maxColor ) /*-{
		return new $wnd.esri.renderer.TimeRampAger([minColor, maxColor]);
	}-*/;
	
	/**
	 * Creates a new TimeRampAger object with the specified color and size ranges.
	 * 
	 * @param minSize - Minimum size in pixels.  Older features will be closer to the minimum value.
	 * @param maxSize - Maximum size in pixels. Newer features will be closer to the maximum value.
	 * @return TimeRampAger
	 */
	public static native TimeRampAger create( int minSize, int maxSize ) /*-{
		return new $wnd.esri.renderer.TimeRampAger([minColor, maxColor], [minSize, maxSize]);
	}-*/;
	
	// getAgedSymbol implemented by SymbolAger

}
