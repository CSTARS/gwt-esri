package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.layers.FeatureEditResult;

/**
 * 
 * @author Justin Merz
 */
public interface DeleteAttachmentsHandler {
	
	/**
	 * Fires when deleteAttachments is complete.
	 * 
	 * @param results - The result objects, one for each attachment indicating if it was succesfully removed. 
	 */
	public void onDeleteAttachmentsComplete(JsArray<FeatureEditResult> results);

}
