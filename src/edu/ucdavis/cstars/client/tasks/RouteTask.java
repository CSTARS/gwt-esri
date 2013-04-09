package edu.ucdavis.cstars.client.tasks;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.RouteSolveCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.RouteSolveHandler;

/**
 * Solves a route on a route layer resource in a Network Analyst service exposed by the ArcGIS Server REST API.
 * 
 * @author Justin Merz
 */
public class RouteTask extends JavaScriptObject {
	
	protected RouteTask() {}
	
	/**
	 * Creates a new RouteTask object.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a network analysis service.
	 * @return RouteTask
	 */
	public static native RouteTask create(String url) /*-{
		return new $wnd.esri.tasks.RouteTask(url);
	}-*/;
	
	/**
	 * URL to the ArcGIS Server REST resource that represents a network analysis service.
	 * 
	 * @return String url.
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Solves the route against the route layer with the route parameters.
	 * 
	 * @param params - Route parameters used as input to generate the route.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred solve(RouteParameters params, RouteSolveCallback callback) /*-{		
		this.solve(params, 
			function(solveResult) {
				callback.@edu.ucdavis.cstars.client.callback.RouteSolveCallback::onSolveComplete(Ledu/ucdavis/cstars/client/event/RouteSolveHandler$SolveResult;)(solveResult);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.RouteSolveCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Solves the route against the route layer with the route parameters.
	 * 
	 * @param params - Route parameters used as input to generate the route.
	 * @return Deferred
	 */
	public final native Deferred solve(RouteParameters params) /*-{		
		this.solve(params);
	}-*/;

	/**
	 * Add event handler for errors.
	 * 
	 * @param handler - Fires when an error occurs when executing the task.
	 */
	public final native void addErrorHandler(ErrorHandler handler) /*-{
		$wnd.dojo.connect(this,  "onError",
			function(error) {
				handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for solve.
	 * 
	 * @param handler - Fires when RouteTask.solve() has completed.
	 */
	public final native void addSolveHandler(RouteSolveHandler handler) /*-{
		$wnd.dojo.connect(this,  "onSolveComplete",
			function(solveResult) {
				handler.@edu.ucdavis.cstars.client.event.RouteSolveHandler::onSolveComplete(Ledu/ucdavis/cstars/client/event/RouteSolveHandler$SolveResult;)(solveResult);
			}
		);
	}-*/;
	
}
