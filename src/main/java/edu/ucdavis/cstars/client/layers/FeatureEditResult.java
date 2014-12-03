package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Error;

/**
 * The results of a feature edit such as add, update or delete. 
 * 
 * @author Justin Merz
 */
public class FeatureEditResult extends JavaScriptObject {
	
	protected FeatureEditResult() {}
	
	/**
	 * Unique ID of the attachment. Applicable only when adding or deleting feature attachments.
	 * 
	 * @return int
	 */
	public final native int getAttachmentId() /*-{
		return this.attachmentId;
	}-*/;
	
	/**
	 * Information about errors that occur if the edit operation failed.
	 * 
	 * @return JavaScriptObject
	 */
	public final native Error getError() /*-{
		return this.error;
	}-*/;

	/**
	 * Unique ID of the feature or object.
	 * 
	 * @return int
	 */
	public final native int getObjectId() /*-{
		return this.objectId;
	}-*/;

	/**
	 * If true the operation was successful.
	 * 
	 * @return boolean
	 */
	public final native boolean isSuccess() /*-{
		return this.success;
	}-*/;
	
}
