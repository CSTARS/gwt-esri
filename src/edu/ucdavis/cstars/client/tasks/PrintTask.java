package edu.ucdavis.cstars.client.tasks;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.PrintTaskCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.PrintTaskHandler;

/**
 * Class added v2.6
 * The PrintTask class generates a printer-ready version of the map using an Export Web Map Task available with ArGIS Server 
 * 10.1 and later. The PrintTask class is used when you want more granular control of the user interface for example, if you 
 * want to provide users the ability to define what appears on the printed page. View the Print widget for an out-of-the-box 
 * widget that provides a simple user interface for printing maps.
 * 
 * The PrintTask requires an ArcGIS Server 10.1 Export Web Map Task.
 * 
 * Requires Package.ESRI_TASKS_PRINTASK.
 * 
 * @author Justin Merz
 */
public class PrintTask extends JavaScriptObject {

	protected PrintTask() {}
	
	/**
	 * Creates a new PrintTask object.
	 * 
	 * @param url - The url to the Export Web Map Task. Requires ArcGIS Server 10.1 or later.
	 * @return PrintTask
	 */
	public static native PrintTask create(String url) /*-{
		if( !@edu.ucdavis.cstars.client.tasks.PrintTask::assertLoaded()() ) return {};
		return new $wnd.esri.tasks.PrintTask(url);
	}-*/;
	
	/**
	 * Check that the esri.layers.PrintTask has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.tasks.PrintTask ) return true;
		$wnd.alert("The ESRI_TASKS_PRINTASK package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * The url to the Export Web Map Task. Requires ArcGIS Server 10.1 or later.
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Sends a request to the print service resource to create a print page using the information specified in the printParameters argument. 
	 * On completion, the onComplete event is fired and the optional callback function is invoked.
	 * 
	 * @param params - A PrintParameters object that defines the printing options.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred execute(PrintParameters params, PrintTaskCallback callback) /*-{
		return this.execute(params, 
			function(result) {
				callback.@edu.ucdavis.cstars.client.callback.PrintTaskCallback::onComplete(Ledu/ucdavis/cstars/client/tasks/PrintTask$PrintResult;)(result);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.PrintTaskCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the print service resource to create a print page using the information specified in the printParameters argument. 
	 * On completion, the onComplete event is fired and the optional callback function is invoked.
	 * 
	 * @param params - A PrintParameters object that defines the printing options.
	 * @return Deferred
	 */
	public final native Deferred execute(PrintParameters params) /*-{
		return this.execute(params);
	}-*/;
	
	/**
	 * Fired when the print job has completed.
	 * 
	 * @param handler - Fires when the print operation is complete.
	 */
	public final native void addCompleteHandler(PrintTaskHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this, "onComplete",
		 	function(result) {
		 		handler.@edu.ucdavis.cstars.client.event.PrintTaskHandler::onComplete(Ledu/ucdavis/cstars/client/tasks/PrintTask$PrintResult;)(result);
			}
		);
	}-*/;
	
	/**
	 * Fired when an error occurs while executing the print task.
	 * 
	 * @param handler - Error message returned in a JavaScript error object.
	 */
	public final native void addErrorHandler(ErrorHandler handler) /*-{
		 $wnd.dojo.connect(
		 	this, "onError",
		 	function(result) {
		 		handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	
	/**
	 * A json object that contains the url of the printed image.
	 */
	public static class PrintResult extends JavaScriptObject {
		
		protected PrintResult() {}
		
		/**
		 * Url of the printed image.
		 * 
		 * @return String
		 */
		public final native String getUrl() /*-{
			return this.url;
		}-*/;
		
	}
	
}
