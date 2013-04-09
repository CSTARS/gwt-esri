package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArrayInteger;

/**
 * Fires when the query on IDs is complete.
 * 
 * @author Justin Merz
 */
public interface QueryTaskIdsHandler {

	/**
	 * 
	 * @param featureIds - Array of Feature IDs that satisfy the query.
	 */
	public void onExecuteForIdsComplete(JsArrayInteger featureIds);
	
}
