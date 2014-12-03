package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The spatial reference of a map, layer, or inputs to and outputs
 * from a task. Each projected and geographic coordinate system is
 * defined by both a well-known ID (WKID) or a definition string (WKT).
 *  The JavaScript API supports only well-known ID's
 * 
 * @author Justin Merz
 */
public class SpatialReference extends JavaScriptObject {

	protected SpatialReference() { } 
	
	/**
	 * Creates a new SpatialReference object.
	 * 
	 * @param jso - The ArcGis REST JSON representation of the spatial reference
	 * @return SpatialReference
	 */
	public static native SpatialReference create(JavaScriptObject jso) /*-{
		return new $wnd.esri.SpatialReference(jso);
	}-*/;
	
	/**
	 * Creates a new SpatialReference object.
	 * 
	 * @param wkid - The well-known ID of a spatial reference
	 * @return SpatialReference
	 */
	public static native SpatialReference create(int wkid) /*-{
		return new $wnd.esri.SpatialReference({"wkid":wkid});
	}-*/;
	
	/**
	 * Creates a new SpatialReference object.
	 * 
	 * @param wkt - The well-known wkt string
	 * @return SpatialReference
	 */
	public static native SpatialReference create(String wkt) /*-{
		return new $wnd.esri.SpatialReference({"wkt":wkt});
	}-*/;
	
	/**
	 * The well-known ID of a spatial reference
	 * 
	 * @return int
	 */
	public final native int getWkid() /*-{ 
		if( this.wkid ) return this.wkid;
		return -1; 
	}-*/;

	/**
	 * The well-known text that defines a spatial reference. Many browser have a 
	 * limit to the length of a GET request of approximately 2048 characters. 
	 * When using well-known text to specify the spatial reference you can easily 
	 * exceed this limit. In these cases, you will need to setup and use a proxy page.
	 * 
	 * @return String
	 */
	public final native String getWkt() /*-{
		if( this.wkt ) return this.wkt;
		return "";
	}-*/;
	
	/**
	 * Returns an easily serializable object representation of the spatial reference.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	
}
