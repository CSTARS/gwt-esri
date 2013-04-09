package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when drawing is complete.
 * 
 * @author Justin Merz
 */
public interface DrawEndHandler {
	
	/**
	 * 
	 * @param geometry - Geometry drawn on the client.
	 */
	public void onDrawEnd(Geometry geometry);

}
