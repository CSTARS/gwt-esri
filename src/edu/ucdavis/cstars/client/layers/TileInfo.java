package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * Contains information about the tiling scheme for an ArcGISTiledMapServiceLayer. TileInfo has no constructor.
 * 
 * @author Justin Merz
 */
public class TileInfo extends JavaScriptObject {
	
	protected TileInfo() {}
	
	/**
	 * The dpi of the tiling scheme.
	 * 
	 * @return int
	 */
	public final native int getDpi() /*-{
		return this.dpi;
	}-*/;
	
	/**
	 * Image format of the cached tiles. Valid values are png8, png24, png32, and jpg.
	 * 
	 * @return String
	 */
	public final native String getFormat() /*-{
		return this.format;
	}-*/;
	
	/**
	 * Height of each tile in pixels.
	 * 
	 * @return int
	 */
	public final native int getHeight() /*-{
		return this.height;
	}-*/;
	
	/**
	 * An array of levels of detail that define the tiling scheme.
	 * 
	 * @return JsArray<LOD>
	 */
	public final native JsArray<LOD> getLods() /*-{
		return this.lods;
	}-*/;

	/**
	 * The tiling scheme origin.
	 * 
	 * @return Point
	 */
	public final native Point getOrigin() /*-{
		return this.origin;
	}-*/;
	
	/**
	 * The spatial reference of the tiling schema.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getSpatialReference() /*-{
		return this.spatialReference;
	}-*/;
	
	/**
	 * Width of each tile in pixels.
	 * 	
	 * @return int
	 */
	public final native int getWidth() /*-{
		return this.width;
	}-*/;
	
}
