package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

import edu.ucdavis.cstars.client.JSObject;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * The results from an ImageServiceIdentifyTask. ImageServiceIdentifyResult has no constructor.
 * 
 * @author Justin Merz
 */
public class ImageServiceIdentifyResult extends JavaScriptObject {
	
	protected ImageServiceIdentifyResult() {}
	
	/**
	 * The set of catalog items that overlap the input geometry. CatalogItems are returned only when 
	 * the image service source is a mosaic dataset.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getCatalogItems() /*-{
		return this.catalogItems;
	}-*/;
	
	/**
	 * The set of visible areas for the identified catalog items. CatalogItemVisibilities are returned only 
	 * when the image service source is a mosaic dataset.
	 * 
	 * @return JsArrayNumber
	 */
	public final native JsArrayNumber getCatalogItemVisibilities() /*-{
		return this.catalogItemVisibilities;
	}-*/;

	/**
	 * The identified location.
	 * 
	 * @return Point
	 */
	public final native Point getLocation() /*-{
		return this.location;
	}-*/;
	
	/**
	 * The identify property name.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * The identify property id.
	 * 
	 * @return int
	 */
	public final native int getObjectId() /*-{
		return this.objectId;
	}-*/;
	
	/**
	 * The attributes of the identified object.
	 * 
	 * @return JSObject
	 */
	public final native JSObject getProperties() /*-{
		return this.properties;
	}-*/;
	
	/**
	 * The identify property pixel value.
	 * 
	 * @return String
	 */
	public final native String getValue() /*-{
		return this.value;
	}-*/;
	
}
