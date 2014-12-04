package edu.ucdavis.cstars.client.virtualearth;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Bing Maps address details. The property definitions are taken from the Bing Maps documentation Address Class.
 * http://msdn.microsoft.com/en-us/library/cc966788.aspx
 * 
 * @author Justin Merz
 */
public class VEAddress extends JavaScriptObject {
	
	protected VEAddress() {}
	
	/**
	 * Specifies the street line of an address. This property is the most precise, official line for an address relative to the postal agency
	 * servicing the area specified by the Locality, PostalTown, or PostalCode properties. Typical use of this element would be to enclose
	 * a street address, private bag, or any other similar official address.
	 * 
	 * @return String
	 */
	public final native String getAddressLine() /*-{
		return this.addressLine;
	}-*/;
	
	/**
	 * Specifies the subdivision name within the country or region for an address. This element is also commonly treated as the first order
	 * administrative subdivision, but in some cases it is the second, third, or fourth order subdivision within a country, dependency, or region.
	 * 
	 * @return String
	 */
	public final native String getAdminDistrict() /*-{
		return this.adminDistrict;
	}-*/;
	
	/**
	 * Specifies the country or region name of an address.
	 * 
	 * @return String
	 */
	public final native String getCountryRegion() /*-{
		return this.countryRegion;
	}-*/;
	
	/**
	 * Specifies the higher level administrative subdivision used in some countries or regions.
	 * 
	 * @return String
	 */
	public final native String getDistrict() /*-{
		return this.district;
	}-*/;
	
	/**
	 * Contains the complete address.
	 * 
	 * @return String
	 */
	public final native String getFormattedAddress() /*-{
		return this.formattedAddress;
	}-*/;
	
	/**
	 * Specifies the populated place for the address. This commonly refers to a city, but may refer to a suburb or neighborhood in certain countries.
	 * 
	 * @return String
	 */
	public final native String getLocality() /*-{
		return this.locality;
	}-*/;
	
	/**
	 * Specifies the post code, postal code, or ZIP Code of an address.
	 * 
	 * @return String
	 */
	public final native String getPostalCode() /*-{
		return this.postalCode;
	}-*/;
	
	/**
	 * Specifies the postal city of an address.
	 * 
	 * @return String
	 */
	public final native String getPostalTown() /*-{
		return this.postalTown;
	}-*/;

	
}
