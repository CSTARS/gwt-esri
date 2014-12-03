package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the trimExtend operation is complete.
 * 
 * @author Justin Merz
 */
public interface TrimExtendHandler {

	/**
	 * 
	 * @param geometries - An array of the trimmed or extended geometries.
	 */
	public void onTrimExtendComplete(JsArray<Geometry> geometries);
	
}
