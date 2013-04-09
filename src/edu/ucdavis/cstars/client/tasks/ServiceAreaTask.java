package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.ServiceAreaSolveCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ServiceAreaSolveHandler;

/**
 * Helps you find service areas around any location on a network. A network service area is a region that
 * encompasses all accessible streets that is, streets that are within a specified impedance. For instance,
 * the 5-minute service area for a point includes all the streets that can be reached within five minutes
 * from that point.
 * 
 * Note: ServiceAreaTask, and other service area related classes, requires ArcGIS Server 10.0 or above
 * and a service area layer. A service area layer is a layer of type esriNAServerServiceAreaLayer.
 * 
 * @author Justin Merz
 */
public class ServiceAreaTask extends JavaScriptObject {
	
	protected ServiceAreaTask() {}
	
	/**
	 * Creates a new ServiceAreaTask object.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a network analysis service. Use the Service Directory to obtain the URL.
	 * @return ServiceAreaTask
	 */
	public static native ServiceAreaTask create(String url) /*-{
		return new $wnd.esri.tasks.ServiceAreaTask(url);
	}-*/;
	
	/**
	 * Solve the service area. 
	 * 
	 * @param params - The ServiceAreaParameters object.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred solve(ServiceAreaParameters params, ServiceAreaSolveCallback callback) /*-{
		return this.solve( params,
			function(serviceAreaSolveResult) {
				callback.@edu.ucdavis.cstars.client.callback.ServiceAreaSolveCallback::onSolveComplete(Ledu/ucdavis/cstars/client/tasks/ServiceAreaSolveResult;)(serviceAreaSolveResult);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.ServiceAreaSolveCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Solve the service area. 
	 * 
	 * @param params - The ServiceAreaParameters object.
	 * @return Deferred
	 */
	public final native Deferred solve(ServiceAreaParameters params) /*-{
		return this.solve( params );
	}-*/;
	
	/**
	 * Add event handler to listen to the onSolveComplete event 
	 * 
	 * @param handler - Fired when the ServiceAreaTask solve is complete.
	 */
	public final native void addSolveHandler(ServiceAreaSolveHandler handler) /*-{
		$wnd.dojo.connect(this, "onSolveComplete",
			function(serviceAreaSolveResult) {
				handler.@edu.ucdavis.cstars.client.event.ServiceAreaSolveHandler::onSolveComplete(Ledu/ucdavis/cstars/client/tasks/ServiceAreaSolveResult;)(serviceAreaSolveResult);
			}
		);
	}-*/;

}
