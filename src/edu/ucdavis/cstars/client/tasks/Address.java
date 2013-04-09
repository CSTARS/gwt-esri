package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *  The address argument is data object that contains properties representing the various address fields accepted 
 *  by the corresponding geocode service. These fields are listed in the addressFields property of the associated 
 *  geocode service resource. For example, if the addressFields of a geocode service resource includes fields with 
 *  the following names: Street, City, State and Zone, then the address argument is of the form:
 *  
 *  <code>
 *  {
 *    Street: "<street>",
 *    City: "<city>",
 *    State: "<state>",
 *    Zone: "<zone>"
 *  }
 *  </code>
 *  
 *  Locators published using ArcGIS 10 or later support a single line address field which can be specified using the following syntax:
 *  
 *  <code>
 *  var address = {"Single Line Input":"380 New York St, Redlands, CA 92373"};
 *  </code>
 *  
 *  Services Directory can be used to find out the required and optional address fields.
 *  
 *  @author Justin Merz
 */
public class Address extends JavaScriptObject {
	
	protected Address() {}
	
	/**
	 * Create new Address object for addressToLocations()
	 * 
	 * @return Address
	 */
	public static Address create() {
		return JavaScriptObject.createObject().cast();
	}
	
	/**
	 * Sets the street
	 * 
	 * @param street
	 */
	public final native void setStreet(String street) /*-{
		this["street"] = street;
	}-*/;
	
	public final native String getStreet() /*-{
		if( this.street ) return this.street;
		return "";
	}-*/;
	
	/**
	 * Sets the city
	 * 
	 * @param city
	 */
	public final native void setCity(String city) /*-{
		this["city"] = city;
	}-*/;
	
	public final native String getCity() /*-{
		if( this.city ) return this.City;
		return "";
	}-*/;
	
	/**
	 * Sets the state
	 * 
	 * @param state
	 */
	public final native void setState(String state) /*-{
		this["state"] = state;
	}-*/;
	
	public final native String getState() /*-{
		if( this.state ) return this.State;
		return "";
	}-*/;
	
	/**
	 * Sets the zone.  
	 * 
	 * @param zone
	 */
	public final native void setZone(String zone) /*-{
		this["zone"] = zone;
	}-*/;
	
	public final native String getZone() /*-{
		if( this.zone ) return this.zone;
		return "";
	}-*/;
	
	/**
	 * Set the single line address.
	 * 
	 * Requires: ArcGIS 10 and later, otherwise use setAddress(), setCity(),
	 * setState(), setZone() for ArcGIS Server 9.x
	 * 
	 * @param address
	 */
	public final native void setSingleLineInput(String address) /*-{
		// this is what docs say
		//this["Single Line Input"] = address;
		
		// this is what arcgis.com uses
		this["SingleLine"] = address;
	}-*/;
	
}
