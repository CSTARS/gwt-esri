package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the cut operation is complete.
 * 
 * @author Justin Merz
 */
public interface CutHandler {
	
	/**
	 * 
	 * @param geometries - The geometry defining the cut region.
	 */
	public void onCutComplete(JsArray<Geometry> geometries);

}
