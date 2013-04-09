package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.tasks.IdentifyResult;

/**
 * Fires when the identify operation is complete.
 * 
 * @author Justin Merz
 */
public interface IdentifyHandler {

	/**
	 * 
	 * @param identifyResults - The result of an identify operation.
	 */
	public void onComplete(JsArray<IdentifyResult> identifyResults);
	
}
