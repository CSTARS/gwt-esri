package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the convexHull operation is complete
 * 
 * @author Justin Merz
 */
public interface ConvexHullHandler {
	
	/**
	 * 
	 * @param geometry - The geometry defining the convex hull of input geometry.
	 */
	public void onConvexHullComplete(Geometry geometry);

}
