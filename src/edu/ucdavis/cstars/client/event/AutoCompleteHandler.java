package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Polygon;

/**
 * Fires when the autoComplete operation is complete.
 * 
 * @author Justin Merz
 */
public interface AutoCompleteHandler {
	
	/**
	 * 
	 * @param polygons - The polygons with the gaps filled with set of polylines.
	 */
	public void onAutoCompleteComplete(JsArray<Polygon> polygons);

}
