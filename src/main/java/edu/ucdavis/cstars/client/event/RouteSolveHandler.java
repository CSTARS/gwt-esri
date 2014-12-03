package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.tasks.NAMessage;
import edu.ucdavis.cstars.client.tasks.RouteResult;

/**
 * Fires when RouteTask.solve() has completed.
 * 
 * @author Justin Merz
 */
public interface RouteSolveHandler {

	/**
	 *
	 * @param solveResult - return object from RouteTask.solve() 
	 */
	public void onSolveComplete(SolveResult solveResult);
	
	public static class SolveResult extends JavaScriptObject {
		
		protected SolveResult() {}
		
		public final native JsArray<RouteResult> getRouteResults() /*-{
			return this.routeResults;
		}-*/;
		
		public final native JsArray<Graphic> getBarriers() /*-{
			return this.barriers;
		}-*/;
		
		public final native JsArray<Graphic> getPolygonBarriers() /*-{
			return this.polygonBarriers;
		}-*/;
		
		public final native JsArray<Graphic> getPolylineBarriers() /*-{
			return this.polylineBarriers;
		}-*/;
		
		public final native JsArray<NAMessage> getMessage() /*-{
			return this.message;
		}-*/;
		
	}
}
