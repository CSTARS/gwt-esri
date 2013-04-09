package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the reshape operation is complete.
 * 
 * @author Justin Merz
 */
public interface ReshapeHandler {

	/**
	 * 
	 * @param geometry - The geometry defining the reshaped of input feature.
	 */
	public void onReshapeComplete(Geometry geometry);
	
}
