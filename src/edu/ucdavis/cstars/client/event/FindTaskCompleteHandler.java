package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.tasks.FindResult;

/**
 * Fires when the find operation is complete. The result is an array of FindResult. This is the same signature that
 * is returned if the optional callback were specified.
 * 
 * @author Justin Merz
 */
public interface FindTaskCompleteHandler {
	
	/**
	 * 
	 * @param findResults - Provides information about a "find result".
	 */
	public void onComplete(JsArray<FindResult> findResults);

}
