package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Object returned by onQueryAttachmentInfosComplete() in the FeatureLayer. Contains 
 * information about the attachments associated with the feature. 
 * 
 * @author Justin Merz
 */
public class AttachmentInfo extends JavaScriptObject {

	protected AttachmentInfo() {}
	
	// TODO: none of these elements are documented, guessing on types
	
	public final native int getObjectId() /*-{
		return this.objectId;
	}-*/;
	
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	public final native String getId() /*-{
		return this.id;
	}-*/;
	
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	public final native String getContentType() /*-{
		return this.contentType;
	}-*/;
	
	public final native int getSize() /*-{
		return this.size;
	}-*/;
	
}
