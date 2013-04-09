package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.FindTaskCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.FindTaskCompleteHandler;

/**
 * Search a map service exposed by the ArcGIS Server REST API based on a string value. The search can be conducted on a single
 * field of a single layer, on many fields of a layer, or on many fields of many layers.
 * 
 * @author Justin Merz
 */
public class FindTask extends JavaScriptObject {
	
	protected FindTask() {}
	
	/**
	 * Creates a new FindTask object. A URL is a required parameter.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a layer in a service.
	 * @return FindTask
	 */
	public static native FindTask create(String url) /*-{
		return new $wnd.esri.tasks.FindTask(url);
	}-*/;
	
	/**
	 * Creates a new FindTask object. A URL is a required parameter.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a layer in a service.
	 * @param options - Optional parameters.
	 * @return FindTask
	 */
	public static native FindTask create(String url, Options options) /*-{
		return new $wnd.esri.tasks.FindTask(url, options);
	}-*/;
	
	/**
	 * URL to the ArcGIS Server REST resource that represents a map service. 
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Sends a request to the ArcGIS REST map service resource to perform a search based on the FindParameters specified in the findParameters argument.
	 * On completion, the onComplete event is fired and the optional callback function is invoked.
	 * 
	 * @param params - Specifies the layers and fields that are used to search against.
	 * @param taskCallback - fired when server responds
	 * @return Deferred
	 */
	public final native Deferred execute(FindParameters params, FindTaskCallback taskCallback) /*-{		
		return this.execute(params, 
			function(results) {
				taskCallback.@edu.ucdavis.cstars.client.callback.FindTaskCallback::onComplete(Lcom/google/gwt/core/client/JsArray;)(results);
			},
			function(error) {
				taskCallback.@edu.ucdavis.cstars.client.callback.FindTaskCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the ArcGIS REST map service resource to perform a search based on the FindParameters specified in the findParameters argument.
	 * On completion, the onComplete event is fired and the optional callback function is invoked.
	 * 
	 * @param params - Specifies the layers and fields that are used to search against.
	 * @return Deferred
	 */
	public final native Deferred execute(FindParameters params) /*-{		
		return this.execute(params);
	}-*/;
	
	/**
	 * Add complete handler.
	 * 
	 * @param handler - Fires when the find operation is complete. The result is an array of FindResult. 
	 */
	public native final void addFindTaskCompleteHandler(FindTaskCompleteHandler handler) /*-{
		$wnd.dojo.connect( this, "onComplete",
			function(findResults) {
				handler.@edu.ucdavis.cstars.client.event.FindTaskCompleteHandler::onComplete(Lcom/google/gwt/core/client/JsArray;)(handler);
			}
		);
	}-*/;
	
	/**
	 * Add error handler.
	 * 
	 * @param handler - Fires when an error occurs when executing the task.
	 */
	public final native void addErrorHandler(ErrorHandler handler) /*-{
		$wnd.dojo.connect( this, "onError",
			function(error) {
				handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param gdbVersion - Specify the geodatabase version to display. (As of v2.7). Requires ArcGIS Server 
		 * service 10.1 or greater
		 */
		public final native void setGdbVersion(String gdbVersion) /*-{
			this["gdbVersion"] = gdbVersion;
		}-*/;
		
	}

}
