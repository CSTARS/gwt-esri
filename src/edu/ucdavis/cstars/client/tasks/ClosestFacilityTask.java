package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.ClosestFacilitySolveCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ClosestFacilitySolveCompleteHandler;

/**
 * Helps you find closest facilities around any location (incident) on a network.
 * 
 * When finding closest facilities, you can specify how many to find and whether the direction of travel is toward or away from them.
 * Once you've found the closest facilities, you can display the best route to or from them, return the travel cost for each route, and
 * display directions to each facility.
 * 
 * You can also specify a cutoff cost beyond which ArcGIS Network Analyst should not search for a facility. For instance, you can set
 * up a closest facility problem to search for hospitals within a 15-minute drive time of the site of an accident. Any hospitals that
 * take longer than 15 minutes to reach will not be included in the results.
 * 
 * Note: ClosestFacilityTask, and other closest facility related classes, requires ArcGIS Server 10.0 or above and a "closest facility"
 * layer. A closest facility layer is a layer of type esriNAServerClosestFacilityLayer.
 * 
 * @author Justin Merz
 */
public class ClosestFacilityTask extends JavaScriptObject {
	
	protected ClosestFacilityTask() {}
	
	/**
	 * Creates a new ClosestFacilityTask object.
	 * 
	 * @return  ClosestFacilityTask
	 */
	public static native ClosestFacilityTask create() /*-{
		if( !@edu.ucdavis.cstars.client.tasks.ClosestFacilityTask::assertLoaded()() ) return {};
		return new $wnd.esri.tasks.ClosestFacilityTask();
	}-*/;
	
	/**
	 * Creates a new ClosestFacilityTask object.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a network analysis service.
	 * Use the Service Directory to obtain the URL.
	 * @return ClosestFacilityTask
	 */
	public static native ClosestFacilityTask create(String url) /*-{
		if( !@edu.ucdavis.cstars.client.tasks.ClosestFacilityTask::assertLoaded()() ) return {};
		return new $wnd.esri.tasks.ClosestFacilityTask(url);
	}-*/;
	
	/**
	 * Check that the esri.tasks.closestfacility has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.tasks.ClosestFacilityTask ) return true;
		$wnd.alert("The ESRI_TASKS_CLOSESTFACILITY package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Solve the closest facility.
	 * 
	 * @param params - The ClosestFacilityParameters object.
	 * @param callback - functions to be called when server responds
	 * @return Deferred
	 */
	public final native Deferred solve(ClosestFacilityParameters params, ClosestFacilitySolveCallback callback) /*-{
		return this.solve( params,
			function(result) {
				callback.@edu.ucdavis.cstars.client.callback.ClosestFacilitySolveCallback::onSolveComplete(Ledu/ucdavis/cstars/client/tasks/ClosestFacilitySolveResult;)(result);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.ClosestFacilitySolveCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Solve the closest facility.
	 * 
	 * @param params - The ClosestFacilityParameters object.
	 * @return Deferred
	 */
	public final native Deferred solve(ClosestFacilityParameters params)  /*-{
		return this.solve( params );
	}-*/;
	
	/**
	 * 
	 * @param handler - Fired when the ClosestFacilityTask solve is complete.
	 */
	public final native void addSolveCompleteHandler( ClosestFacilitySolveCompleteHandler handler) /*-{
		$wnd.dojo.connect( this, "onSolveComplete",
			function(result) {
				handler.@edu.ucdavis.cstars.client.event.ClosestFacilitySolveCompleteHandler::onSolveComplete(Ledu/ucdavis/cstars/client/tasks/ClosestFacilitySolveResult;)(result);
			}
		);
	}-*/;
	

}
