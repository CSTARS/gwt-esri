package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the union operation is complete.
 * 
 * @author Justin Merz
 */
public interface UnionHandler {
	
	/**
	 * 
	 * @param geometry - The geometry defining the union of input features.
	 */
	public void onUnionComplete(Geometry geometry);

}
