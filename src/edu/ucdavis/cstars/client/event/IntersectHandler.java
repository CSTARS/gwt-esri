package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the intersect operation is complete.
 * 
 * @author Justin Merz
 */
public interface IntersectHandler {

	/**
	 * 
	 * @param geometries - The geometry defining the intersection of input features.
	 */
	public void onIntersectComplete(JsArray<Geometry> geometries);
	
}
