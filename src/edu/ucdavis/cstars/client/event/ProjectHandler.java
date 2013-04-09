package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the project operation is complete.
 * 
 * @author Justin Merz
 */
public interface ProjectHandler {
	
	/**
	 * 
	 * @param geometries - The projected geometries.
	 */
	public void onProjectComplete(JsArray<Geometry> geometries);

}
