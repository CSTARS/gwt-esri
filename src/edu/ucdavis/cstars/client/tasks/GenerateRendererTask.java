package edu.ucdavis.cstars.client.tasks;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.GenerateRendererCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GenerateRendererHandler;
import edu.ucdavis.cstars.client.layers.LayerDataSource;
import edu.ucdavis.cstars.client.layers.LayerMapSource;

/**
 * The GenerateRendererTask class creates a renderer based on a classification definition and optional where 
 * clause. The classification definition is used to define the base symbol and color ramp for the renderer. 
 * The output renderer can be applied to graphics layers, feature layers or dynamic layers. The GenerateRendererTask 
 * is available for map service or tables that support the generateDataClasses operation (version 10.1 or greater).
 * 
 * @author Justin Merz
 */
public class GenerateRendererTask {
	
	protected GenerateRendererTask() {}
	
	/**
	 * Creates a new GenerateRendererTask object.
	 * 
	 * @return GenerateRendererTask
	 */
	public static native GenerateRendererTask create(String url) /*-{
		if( !@edu.ucdavis.cstars.client.tasks.GenerateRendererTask::assertLoaded()() ) return {};
		return new $wnd.esri.tasks.GenerateRendererTask(url);
	}-*/;
	
	/**
	 * Creates a new GenerateRendererTask object.
	 * 
	 * @return GenerateRendererTask
	 */
	public static native GenerateRendererTask create(String url, Options options) /*-{
		if( !@edu.ucdavis.cstars.client.tasks.GenerateRendererTask::assertLoaded()() ) return {};
		return new $wnd.esri.tasks.GenerateRendererTask(url, options);
	}-*/;
	
	/**
	 * Check that the esri.tasks.closestfacility has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.tasks.GenerateRendererTask ) return true;
		$wnd.alert("The ESRI_TASKS_GENERATERENDERERTASK package has not been loaded");
		return false;
	}-*/;

	/**
	 * Perform a classification on the layer or table resource. Upon successful completion of the classification operation the onComplete 
	 * event is fired and the optional callback function is invoked. The result is a renderer object that can be applied to graphics layers, 
	 * feature layers or dynamic layers.
	 * 
	 * @param generateRendererParameters - A GenerateRendererParameters object that defines the classification definition and an optional 
	 * where clause.
	 * @param callback - This handler will be called when the operation is complete
	 * @return Deferred
	 */
	public final native Deferred execute(GenerateRendererParameters generateRendererParameters, GenerateRendererCallback callback) /*-{
		return this.execute(generateRendererParameters,
			function(renderer) {
				callback.@edu.ucdavis.cstars.client.callback.GenerateRendererCallback::onComplete(Ledu/ucdavis/cstars/client/renderer/Renderer;)(renderer);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.GenerateRendererCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Perform a classification on the layer or table resource. Upon successful completion of the classification operation the onComplete 
	 * event is fired and the optional callback function is invoked. The result is a renderer object that can be applied to graphics layers, 
	 * feature layers or dynamic layers.
	 * 
	 * @param generateRendererParameters - A GenerateRendererParameters object that defines the classification definition and an optional 
	 * where clause.
	 * @return Deferred
	 */
	public final native Deferred execute(GenerateRendererParameters generateRendererParameters) /*-{
		return this.execute(generateRendererParameters);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fired when the GenerateRendererTask solve is complete.
	 */
	public final native void addCompleteHandler(GenerateRendererHandler handler) /*-{
		$wnd.dojo.connect( this, "onComplete",
			function(renderer) {
				handler.@edu.ucdavis.cstars.client.event.GenerateRendererHandler::onComplete(Ledu/ucdavis/cstars/client/renderer/Renderer;)(renderer);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fired when an error occurs during task execution.
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
		
		/**
		 * 
		 * @param gdbVersion - Specify the geodatabase version to display. (As of v2.7). 
		 * Requires ArcGIS Server service 10.1 or greater
		 */
		public final native void setGdbVersion(String gdbVersion) /*-{
			this["gdbVersion"] = gdbVersion;
		}-*/;
		
		/**
		 * 
		 * @param source - The dynamic layer source. Required when the GenerateRenderer url is set to 
		 * http://<map service url>/dynamicLayer. (As of v2.7). Requires ArcGIS Server service 10.1 or greater
		 */
		public final native void setSource(LayerMapSource source) /*-{
			this["source"] = source;
		}-*/;
		
		/**
		 * 
		 * @param source - The table source. Required when the GenerateRenderer url is set to 
		 * http://<map service url>/dynamicLayer. (As of v2.7). Requires ArcGIS Server service 10.1 or greater
		 */
		public final native void setSource(LayerDataSource source) /*-{
			this["source"] = source;
		}-*/;
		
	}
	
}
