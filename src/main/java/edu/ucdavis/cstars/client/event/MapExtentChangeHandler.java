package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;
import edu.ucdavis.cstars.client.layers.LOD;

/**
 * Fires when the extent of the map has changed.
 * 
 * @author Justin Merz
 */
public interface MapExtentChangeHandler {
	
	/**
	 * 
	 * @param extent - Gets the extent when after the extent has changed.
	 * @param delta - The change in the x and y values from the previous extent. The Point x and y values are in
	 * screen units. This point acts as an anchor point, and this part of the map stays within the map region during the zoom process.
	 * @param levelChange - When using ArcGIS Server tiled map services, the value is "true" when the user zooms to a new level.
	 * The value remains "false" during pan operations.
	 * @param lod - When using ArcGIS Server tiled map services, this argument returns characteristics about the level of detail.
	 */
	public void onMapExtentChange(Extent extent, Point delta, boolean levelChange, LOD lod);

}
