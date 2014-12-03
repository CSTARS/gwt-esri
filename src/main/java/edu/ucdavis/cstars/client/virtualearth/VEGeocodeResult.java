package edu.ucdavis.cstars.client.virtualearth;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * Represents a Bing Maps address and its location. Many of the property definitions are taken from the Bing Maps documentation GeocodeResult Class.
 * http://msdn.microsoft.com/en-us/library/cc980950.aspx
 * 
 * @author Justin Merz
 */
public class VEGeocodeResult extends JavaScriptObject {

	protected VEGeocodeResult() {}
	
	/**
	 * Specifies address properties for the result.
	 * 
	 * @return VEAddress
	 */
	public final native VEAddress getAddress() /*-{
		return this.address;
	}-*/;
	
	/**
	 * Best extent for displaying the result.
	 * 
	 * @return Extent
	 */
	public final native Extent getBestView() /*-{
		return this.bestView;
	}-*/;
	
	/**
	 * Contains values that indicate the geocode method used to match the location to the map. The values are "Interpolation", "Parcel", and
	 * "Rooftop". For more information see http://msdn.microsoft.com/en-us/library/cc980868.aspx under "Match Methods".
	 * 
	 * @return String
	 */
	public final native String getCalculationMethod() /*-{
		return this.calculationMethod;
	}-*/;
	
	/**
	 * Value indicating how confident the service is about the result. Values are Low, Medium, and High.
	 * 
	 * @return String
	 */
	public final native String getConfidence() /*-{
		return this.confidence;
	}-*/;
	
	/**
	 * Contains a display name for the result.
	 * 
	 * @return String
	 */
	public final native String getDisplayName() /*-{
		return this.displayName;
	}-*/;
	
	/**
	 * Further refines the geocode results that have been returned. For more details on entities and a list of entities that are returned see,
	 * http://msdn.microsoft.com/en-us/library/cc981001.aspx.
	 * 
	 * @return String
	 */
	public final native String getEntityType() /*-{
		return this.entityType;
	}-*/;
	
	/**
	 * The X and Y coordinates of the result in decimal degrees.
	 * 
	 * @return Point
	 */
	public final native Point getLocation() /*-{
		return this.location;
	}-*/;
	
	/**
	 * An array of values that indicate the geocoding level of the location match. For more information and a list of values,
	 * see http://msdn.microsoft.com/en-us/library/cc980868.aspx.
	 * 
	 * @return String
	 */
	public final native String getMatchCodes() /*-{
		return this.matchCodes;
	}-*/;
	
}
