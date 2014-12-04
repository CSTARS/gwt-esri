package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.IdentifyCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.IdentifyHandler;

/**
 * Performs an identify operation on the layers of a map service resource exposed by the ArcGIS Server REST API.
 * 
 * @author Justin Merz
 */
public class IdentifyTask extends JavaScriptObject {

	protected IdentifyTask() {}
	
	/**
	 * Creates a new IdentifyTask object.
	 * 
	 * @param url -URL to the ArcGIS Server REST resource that represents a map service.
	 * @return IdentifyTask
	 */
	public final native static IdentifyTask create(String url) /*-{
		return new $wnd.esri.tasks.IdentifyTask(url);
	}-*/;
	
	/**
	 * Creates a new IdentifyTask object.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a map service.
	 * @param options - Optional parameters
	 * @return IdentifyTask
	 */
	public final native static IdentifyTask create(String url, Options options) /*-{
		return new $wnd.esri.tasks.IdentifyTask(url, options);
	}-*/;
	
	/**
	 * Sends a request to the ArcGIS REST map service resource to identify features based on the IdentifyParameters
	 * specified in the identifyParameters argument. 
	 * 
	 * @param identifyParams - Specifies the criteria used to identify the features.
	 * @param callback - The function to call when the method has completed. 
	 * @return Deferred
	 */
	public final native Deferred execute(IdentifyParameters identifyParams, IdentifyCallback callback) /*-{		
		this.execute(identifyParams, 
			function(identifyResults) {
				callback.@edu.ucdavis.cstars.client.callback.IdentifyCallback::onComplete(Lcom/google/gwt/core/client/JsArray;)(identifyResults);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.IdentifyCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the ArcGIS REST map service resource to identify features based on the IdentifyParameters
	 * specified in the identifyParameters argument. 
	 * 
	 * @param identifyParams - Specifies the criteria used to identify the features.
	 * @return Deferred
	 */
	public final native Deferred execute(IdentifyParameters identifyParams) /*-{		
		this.execute(identifyParams);
	}-*/;
	
	/**
	 * Add event handler for completion.
	 * 
	 * @param handler - Fires when the identify operation is complete.
	 */
	public final native void addCompleteHandler(IdentifyHandler handler) /*-{
		$wnd.dojo.connect(this, "onComplete",
			function(identifyResults) {
				handler.@edu.ucdavis.cstars.client.event.IdentifyHandler::onComplete(Lcom/google/gwt/core/client/JsArray;)(identifyResults);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for errors.
	 * 
	 * @param handler - Fires when an error occurs when executing the task. 
	 */
	public final native void addErrorHandler(ErrorHandler handler) /*-{
		$wnd.dojo.connect(this, "onError",
			function(error) {
				handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public final native void setGdbVersion(String gdbVersion) /*-{
			this["gdbVersion"] = gdbVersion;
		}-*/;
		
	}
	
	
}
