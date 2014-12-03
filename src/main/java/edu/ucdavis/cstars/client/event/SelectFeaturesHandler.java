package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.layers.FeatureLayer.Selections;

/**
 * 
 * @author Justin Merz
 */
public interface SelectFeaturesHandler {

	/**
	 * Fires when selectFeatures() has completed. OnSelectionComplete always fires unless
	 * there is an error returned by the server.
	 * 
	 * @param features - Features returned from the query.This does not equal the current
	 * selection, call getSelectedFeatures() to retrieve the current selection set. 
	 * @param selectionMethod - Selection method used in the selectFeatures method.
	 */
	public void onSelectionComplete(JsArray<Graphic> features, Selections selectionMethod);
	
}
