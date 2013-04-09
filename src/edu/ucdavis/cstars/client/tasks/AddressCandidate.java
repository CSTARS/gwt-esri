package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.JSObject;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * Represents an address and its location. AddressCandidate has no constructor. 
 * 
 * @author Justin Merz
 */
public class AddressCandidate extends JavaScriptObject {
	
	protected AddressCandidate() {}
	
	/**
	 * Address of the candidate. It contains one property for each of the address fields defined by
	 * a geocode service. Each address field describes some part of the address information for the candidate.
	 * 
	 * @return JSObject
	 */
	public final native AddressResult getAddressAsObject() /*-{
		return this.address;
	}-*/;
	
	/**
	 * Use this when using single line address requests
	 * 
	 * @return String.
	 */
	public final native String getAddressAsString() /*-{
		return this.address;
	}-*/;
	
	/**
	 * Name value pairs of field name and field value as defined in outFields in Locator.addressToLocations.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JSObject getAttributes() /*-{
		return this.attributes;
	}-*/;
	
	/**
	 * X- and y-coordinate of the candidate.
	 * 
	 * @return Point
	 */
	public final native Point getLocation() /*-{
		return this.location;
	}-*/;
	
	/**
	 * Numeric score between 0 and 100 for geocode candidates. A candidate with a score of 100 means a 
	 * perfect match, and 0 means no match.
	 * 
	 * @return int
	 */
	public final native int getScore() /*-{
		return this.score;
	}-*/;

}
