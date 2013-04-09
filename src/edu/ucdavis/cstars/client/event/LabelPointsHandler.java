package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the labelPoints operation is complete.
 * 
 * @author Justin Merz
 */
public interface LabelPointsHandler {

	/**
	 * 
	 * @param labelPoints - The geometry representing the points calculated inside the polygons.
	 */
	public void onLabelPointsComplete(JsArray<Geometry> labelPoints);
	
}
