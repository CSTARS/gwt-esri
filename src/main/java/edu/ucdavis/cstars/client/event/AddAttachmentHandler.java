package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.layers.FeatureEditResult;

/**
 * 
 * @author Justin Merz
 */
public interface AddAttachmentHandler {

	/**
	 * The result of the addAttachment operation indicating if the attachment was sucessfully added. 
	 * 
	 * @param result
	 */
	public void onAddAttachmentComplete(FeatureEditResult result);
	
}
