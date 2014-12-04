package edu.ucdavis.cstars.client.tasks;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.ImageServiceIdentifyTaskCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ImageServiceIdentifyTaskCompleteHandler;

/**
 * Performs an identify operation on an image service resource . It identifies the content of an image 
 * service for the input location and mosaic rule.
 * 
 * @author Justin Merz
 */
public class ImageServiceIdentifyTask extends JavaScriptObject {
	
	protected ImageServiceIdentifyTask() {}
	
	/**
	 * Creates a new ImageServiceIdentifyTask object.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents an image service.
	 * @return ImageServiceIdentifyTask
	 */
	public static ImageServiceIdentifyTask create(String url) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(url);
	}
	
	public static native ImageServiceIdentifyTask _create(String url) /*-{
		return new $wnd.esri.tasks.ImageServiceIdentifyTask(url);
	}-*/;

	/**
	 * Check that the esri.layers.ImageServiceIdentifyTask has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.tasks.ImageServiceIdentifyTask ) return true;
		$wnd.alert("The ESRI_TASKS_IMAGESERVICEIDENTIFYTASK package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Sends a request to the ArcGIS REST image service resource to identify content based on the 
	 * ImageServiceIdentifyParameters specified in the imageServiceIdentifyParameters argument.
	 * 
	 * @param params - Specifies the criteria used to identify the features.
	 * @param callback - functions to call when operation is completed.
	 * @return Deferred
	 */
	public final native Deferred execute(ImageServiceIdentifyParameters params, ImageServiceIdentifyTaskCallback callback) /*-{
		return this.execute(params, 
			function(imageServiceIdentifyResult) {
				callback.@edu.ucdavis.cstars.client.callback.ImageServiceIdentifyTaskCallback::onComplete(Ledu/ucdavis/cstars/client/tasks/ImageServiceIdentifyResult;)(imageServiceIdentifyResult);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.ImageServiceIdentifyTaskCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the ArcGIS REST image service resource to identify content based on the 
	 * ImageServiceIdentifyParameters specified in the imageServiceIdentifyParameters argument.
	 * 
	 * @param params - Specifies the criteria used to identify the features.
	 * @return Deferred
	 */
	public final native Deferred execute(ImageServiceIdentifyParameters params) /*-{
		return this.execute(params);
	}-*/;
	
	
	/**
	 * Fires when the identify operation is complete.
	 * 
	 * @param handler - Fires when the identify operation is complete.
	 */
	public final native void addCompleteHandler(ImageServiceIdentifyTaskCompleteHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this, "onComplete",
		 	function(imageServiceIdentifyResult) {
		 		handler.@edu.ucdavis.cstars.client.event.ImageServiceIdentifyTaskCompleteHandler::onComplete(Ledu/ucdavis/cstars/client/tasks/ImageServiceIdentifyResult;)(imageServiceIdentifyResult);
			}
		);
	}-*/;
}
