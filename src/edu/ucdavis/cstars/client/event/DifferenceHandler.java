package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the difference operation is complete.
 * 
 * @author Justin Merz
 */
public interface DifferenceHandler {

	/**
	 * 
	 * @param geometries - The geometry defining the difference of input features.
	 */
	public void onDifferenceComplete(JsArray<Geometry> geometries);
	
}
