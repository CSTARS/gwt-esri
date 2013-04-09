package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArrayInteger;

/**
 * 
 * @author Justin Merz
 */
public interface QueryIdsHandler {
	
	/**
	 * Fires when queryIds() is complete.
	 * 
	 * @param ids - Array of ObjectIds returned from the query.
	 */
	public void onQueryIdsComplete(JsArrayInteger ids);
	
}
