package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * Represents the data object for the dynamically generated map. This is returned after a succesful export operation on
 * ArcGISDynamicMapServiceLayer and Geoprocessor.getResultImage in the callback and in the event result.
 * 
 * @author Justin Merz
 */
public class MapImage extends JavaScriptObject {

	protected MapImage() {}
	
	/**
	 * Creates a new Map Image object.
	 * 
	 * @param extent - Specfiy an extent for the image.
	 * @param href - Specify the url of the image.
	 * @return MapImage
	 */
	public static native MapImage create(Extent extent, String href) /*-{
		return new $wnd.esri.layers.MapImage({"extent":extent,"href":href});
	}-*/;
	
	/**
	 * Extent of exported map.
	 * 
	 * @return Extent
	 */
	public final native Extent getExtent() /*-{
		return this.extent;
	}-*/;
	
	/**
	 * Requested image height in pixels.
	 * 
	 * @return int
	 */
	public final native int getHeight() /*-{
		return this.height;
	}-*/;
	
	/**
	 * URL to returned image.
	 * 
	 * @return String
	 */
	public final native String getHref() /*-{
		return this.href;
	}-*/;
	
	/**
	 * Scale of requested dynamic map.
	 * 
	 * @return float
	 */
	public final native float getScale() /*-{
		return this.scale;
	}-*/;
	
	/**
	 * Requested image width in pixels.
	 * 
	 * @return int
	 */
	public final native int getWidth() /*-{
		return this.width;
	}-*/;
	
}
