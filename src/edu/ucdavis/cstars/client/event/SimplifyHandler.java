package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the simplify operation is complete.
 * 
 * @author Justin Merz
 */
public interface SimplifyHandler {

	/**
	 * 
	 * @param geometries - The simpified geometries.
	 */
	public void onSimplifyComplete(JsArray<Geometry> geometries);
	
}
