package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the generalize operation is complete.
 * 
 * @author Justin Merz
 */
public interface GeneralizeHandler {

	/**
	 * 
	 * @param geometries - The generalized geometries.
	 */
	public void onGeneralizeComplete(JsArray<Geometry> geometries);
	
}
