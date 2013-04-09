package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * Fires during the zoom process.
 * 
 * @author Justin Merz
 */
public interface MapZoomHandler {
	
	/**
	 * 
	 * @param extent - Gets the extent during the zoom event.
	 * @param zoomFactor -The scale factor represents the amount as a percentage that the map zoomed in
	 * or out from the previous extent. A value of 2 means the map was zoomed in twice as far as the previous
	 * extent. A value of 0.5 means the map zoomed out twice as far as previously.
	 * @param anchor - The location of the mouse pointer. The Point x and y values are in screen units. This point
	 * acts as an anchor point, and this part of the map stays within the map region during the zoom process.
	 */
	public void onZoom(Extent extent, float zoomFactor, Point anchor);
	
}
