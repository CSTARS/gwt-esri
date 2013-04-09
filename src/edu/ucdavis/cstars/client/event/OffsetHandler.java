package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the offset operation is complete.
 * 
 * @author Justin Merz
 */
public interface OffsetHandler {

	/**
	 * 
	 * @param geometries - An array of the offset geometries.
	 */
	public void onOffsetComplete(JsArray<Geometry> geometries);
	
}
