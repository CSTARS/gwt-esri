package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.layers.AttachmentInfo;

/**
 * 
 * @author Justin Merz
 */
public interface QueryAttachmentInfosHandler {
	
	/**
	 * Fires when queryAttachmentInfos() is complete.
	 * 
	 * @param attachmentInfos - Information about the attachments associated with the feature.
	 */
	public void onQueryAttachmentInfosComplete(JsArray<AttachmentInfo> attachmentInfos);
	
}
