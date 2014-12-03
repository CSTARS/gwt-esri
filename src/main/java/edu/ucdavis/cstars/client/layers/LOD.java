package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An ArcGISTiledMapServiceLayer has a number of LODs (Levels of Detail). Each LOD corresponds to a map at a given scale or resolution.
 * 
 * @author Justin Merz
 */
public class LOD extends JavaScriptObject {

	protected LOD() {}

	public static native LOD create(int level, double resolution, double scale) /*-{
		return {"level": level, "resolution": resolution, "scale": scale };
	}-*/;
	
	/**
	 * ID for each level. The top most level is 0. The ID is returned in Map.getLevel() and set in Map.setLevel().
	 * 
	 * @return in
	 */
	public final native int getLevel() /*-{
		return this.level;
	}-*/;
	
	/**
	 * Resolution in map units of each pixel in a tile for each level.
	 * 
	 * @return float
	 */
	public final native double getResolution() /*-{
		return this.resolution;
	}-*/;

	/**
	 * Scale for each level.
	 * 
	 * @return float
	 */
	public final native double getScale() /*-{
		return this.scale;
	}-*/;

}
