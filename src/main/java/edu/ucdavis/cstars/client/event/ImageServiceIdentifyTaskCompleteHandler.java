package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.ImageServiceIdentifyResult;

/**
 * 
 * @author Justin Merz
 */
public interface ImageServiceIdentifyTaskCompleteHandler {
	
	/**
	 * Fires when the identify operation is complete.
	 * 
	 * @param imageServiceIdentifyResult - The result of an identify operation.
	 */
	public void onComplete(ImageServiceIdentifyResult imageServiceIdentifyResult);

}
