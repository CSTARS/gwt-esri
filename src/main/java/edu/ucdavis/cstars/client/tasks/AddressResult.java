package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Return object from AddressCandidate.getAddress()
 * 
 * Different versions of ArcGis Server return different attributes for this object.  If you can't access
 * am attribute using one of the standard methods, then use getAddressValue where the key is the 
 * value you wish to access.
 * 
 * @author Justin Merz
 */
public class AddressResult extends JavaScriptObject {

	protected AddressResult() {}
	
	/**
	 * Return the Address attribute.
	 * 
	 * @return String
	 */
	public final native String getStreet() /*-{
	    if( this.Address ) return this.Address;
	    return "";
	}-*/;
	
	/**
	 * Return the City attribute.
	 * 
	 * @return String
	 */
	public final native String getCity() /*-{
	    if( this.City ) return this.City;
	    return "";
	}-*/;
		
	/**
	 * Return this State attribute.
	 * 
	 * @return String
	 */
	public final native String getState() /*-{
	    if( this.State ) return this.State;
	    return "";
	}-*/;
	
	/**
	 * Return the Zip attribute.
	 * 
	 * @return String
	 */
	public final native String getZipCode() /*-{
	    if (this.Zip) return this.Zip;
	    return "";
	}-*/;
	
	/**
	 * Utility method that will try and return any of the values in the 
	 * Address JavaScript object as long as it has been set
	 * 
	 * @param key - the Key in the JavaScript object to retrieve the value
	 */
	public final native String getAddressValue(String key) /*-{
	    if (this[key]) return this[key];
	    return "";
	}-*/;
	
}
